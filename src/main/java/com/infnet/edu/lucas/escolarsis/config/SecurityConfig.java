package com.infnet.edu.lucas.escolarsis.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.infnet.edu.lucas.escolarsis.Business.Services.ProfessorService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${spring.application.name}")
    private String appName;
    @Value("${springdoc.swagger-ui.path}")
    private String swaggerUiPath;
    @Value("${springdoc.api-docs.path}")
    private String swaggerApiDocsPath;
    @Autowired
    private ProfessorService professorService;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(httpRequests ->
                    httpRequests
                    .requestMatchers(HttpMethod.POST, "/professor/create").permitAll()
                    .requestMatchers(HttpMethod.POST, "/professor/login").permitAll()
                    .requestMatchers(
                            "/api-docs/**",
                            "/swagger-ui/**",
                            "/swagger-ui.html"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager(professorService))
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(ProfessorService professorService) {        
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(professorService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        
        return new ProviderManager(daoAuthenticationProvider);
    }

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("*"));
		configuration.setAllowedMethods(List.of("*"));
		configuration.setAllowedHeaders(List.of("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}