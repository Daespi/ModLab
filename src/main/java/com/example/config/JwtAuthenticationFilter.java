package com.example.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;


    // Constructor con inyección de dependencias

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        // Rutas públicas: permitir sin verificación de token
        if (path.equals("/modlab/User/login") || path.equals("/modlab/User/register")) {
            filterChain.doFilter(request, response);
            return;
        }


        // Obtener el token del encabezado Authorization
        String bearerToken = request.getHeader("Authorization");

        // Solo validar si hay token presente
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {

            String token = bearerToken.substring(7); // Extraer token del "Bearer"
            try {
                if (jwtTokenProvider.validateToken(token)) {
                    // Obtener el email del token
                    String email = jwtTokenProvider.getEmailFromToken(token);

                    // Crear un objeto de autenticación
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(email, null, null); // No roles por ahora
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Establecer la autenticación en el contexto de seguridad
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                // Si el token es inválido, retornar un error 401
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired token");
                return;
            }
        }


        // Sin token: continuar como usuario no autenticado (solo si es permitido por la config de seguridad)

        // Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
