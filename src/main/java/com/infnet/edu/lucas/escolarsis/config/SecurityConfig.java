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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                .csrf(csrf -> csrf.ignoringRequestMatchers("/professor/create", "/professor/login"))
                .authorizeHttpRequests(httpRequests ->
                    httpRequests
                    .requestMatchers(
                        "/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                        ).permitAll()
                        .requestMatchers(HttpMethod.POST, "/professor/create").permitAll()
                        .requestMatchers(HttpMethod.POST, "/professor/login").permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager(professorService))
                .httpBasic(Customizer.withDefaults())
                .formLogin(customizer -> 
                    customizer
                    .successForwardUrl("/swagger-ui/index.html")
                    .defaultSuccessUrl("/swagger-ui/index.html")
                )
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
        
        DaoAuthenticationProvider daoAuthenticationProvider2 = new DaoAuthenticationProvider();
        daoAuthenticationProvider2.setUserDetailsService(userDetailsService());
        
        return new ProviderManager(daoAuthenticationProvider2, daoAuthenticationProvider);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        
        userDetailsManager.createUser(
                User.withUsername("professor")
                        .password("{noop}professor")
                        .roles("professor")
                        .authorities("professor")
                        .build()
        );
        
        return userDetailsManager;
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