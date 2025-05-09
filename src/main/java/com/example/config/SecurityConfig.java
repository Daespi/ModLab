package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfig {

    // Codificador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración de seguridad
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.addAllowedOrigin("http://localhost:4200");  // Frontend
                config.addAllowedMethod("*");  // Permite todos los métodos (GET, POST, PUT, DELETE)
                config.addAllowedHeader("*");  // Permite todos los headers
                config.setAllowCredentials(true);  // Permite el envío de cookies o cabeceras de autenticación
                return config;
            }))
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF
            .authorizeRequests(auth -> auth
                .requestMatchers("/modlab/**").permitAll() // Permite acceso sin autenticación a todas las rutas /modlab/*
                .anyRequest().authenticated() // Requiere autenticación para el resto de las solicitudes
            );

        return http.build();
    }
}
