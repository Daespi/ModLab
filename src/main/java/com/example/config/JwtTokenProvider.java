package com.example.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // Si no se proporciona la clave secreta en el archivo de configuración, generamos una automáticamente
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Value("${jwt.expiration}")
    private long validityInMilliseconds;

    // Generación de token con valores de configuración
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(secretKey)
                .compact();
    }

    // Método para obtener el username desde el token
    public String getUsernameFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            throw new JwtException("Token inválido o expirado", e);
        }
    }

    // Método para obtener el email desde el token
    public String getEmailFromToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .get("email", String.class);  // Obtiene el claim "email"
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            throw new JwtException("Token inválido o expirado", e);
        }
    }

    // Método para verificar si el token está expirado
    public boolean isTokenExpired(String token) {
        try {
            Date expiration = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expiration.before(new Date());
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            throw new JwtException("Token inválido o expirado", e);
        }
    }

    // Validación del token
    public boolean validateToken(String token) {
        try {
            String username = getUsernameFromToken(token);
            return username != null && !isTokenExpired(token);
        } catch (JwtException e) {
            return false;
        }
    }
}
