package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(List.of("http://localhost:4200")); // frontend
        cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        cors.setAllowedHeaders(List.of("*"));
        cors.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);
        return new CorsFilter(source);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtTokenProvider);


        http
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // ✅ ENDPOINTS públicos
                .requestMatchers(HttpMethod.POST, "/modlab/User/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/modlab/User/users").permitAll()
                .requestMatchers("/modlab/User/**").permitAll()
                .requestMatchers("/modlab/**").permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // necesario para CORS
                // ✅ ENDPOINTS privados
                .requestMatchers("/modlab/ShippingAddress/**", "/address", "/address/add", "/profile").authenticated()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}




// package com.example.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;

// import java.util.List;

// @Configuration
// public class SecurityConfig {

//     private final JwtTokenProvider jwtTokenProvider;

//     public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     // CORS global config
//     @Bean
//     public CorsFilter corsFilter() {
//         CorsConfiguration cors = new CorsConfiguration();
//         cors.setAllowedOrigins(List.of("http://localhost:4200")); // Frontend origin
//         cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//         cors.setAllowedHeaders(List.of("*"));
//         cors.setAllowCredentials(true);

//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", cors);
//         return new CorsFilter(source);
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtTokenProvider);

//         http
//             .cors(Customizer.withDefaults())
//             .csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth
//                 // === RUTAS PÚBLICAS ===
//                 .requestMatchers(HttpMethod.POST, "/modlab/User/login").permitAll()
//                 .requestMatchers(HttpMethod.POST, "/modlab/User/register").permitAll() // ✅ Registro
//                 .requestMatchers(HttpMethod.GET, "/generate-token").permitAll()
//                 .requestMatchers("/modlab/User/**").permitAll() // Otros endpoints de usuario públicos
//                 .requestMatchers("/modlab/**").permitAll() // Otras rutas públicas
//                 .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Para CORS
//                 // === RUTAS PROTEGIDAS ===
//                 .requestMatchers("/modlab/ShippingAddress/**", "/address", "/address/add", "/profile").authenticated()
//                 .anyRequest().authenticated()
//             )
//             .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }
// }
