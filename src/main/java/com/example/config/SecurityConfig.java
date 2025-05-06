package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.Customizer;

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
            .cors(Customizer.withDefaults()) // Activa CORS (necesita WebMvcConfigurer)
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF para facilitar desarrollo
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/modlab/**").permitAll() // Permite acceso sin autenticación
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
