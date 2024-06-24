package com.andres.springboot.app.springbootcrud.config.security;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.andres.springboot.app.springbootcrud.config.security.filter.JwtAuthenticationFilter;
import com.andres.springboot.app.springbootcrud.config.security.filter.JwtValidationFilter;


@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

    private  AuthenticationConfiguration authenticationConfiguration;

    public SpringSecurityConfig(AuthenticationConfiguration authenticationConfiguration){
        this.authenticationConfiguration = authenticationConfiguration;
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return this.authenticationConfiguration.getAuthenticationManager();
    } 

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((auth) -> auth
                                .requestMatchers(HttpMethod.GET, "/api/users").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll()
                                // .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
                                // .requestMatchers(HttpMethod.GET, "/api/products", "/api/products/{id}").hasAnyRole("ADMIN","USER")
                                // .requestMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN")
                                // .requestMatchers(HttpMethod.PUT, "/api/product/{id}").hasRole("ADMIN")
                                // .requestMatchers(HttpMethod.DELETE,"/api/products/{id}").hasRole("ADMIN")
                                .anyRequest().authenticated()
                                )
                .addFilter(new JwtAuthenticationFilter(this.authenticationManager()))
                .addFilter(new JwtValidationFilter(this.authenticationManager()))
                .csrf(config -> config.disable())
                .cors(cors -> cors.configurationSource(this.configurationSource()))
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    @NonNull
    CorsConfigurationSource configurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<>(new CorsFilter(this.configurationSource()));

        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return corsBean;
    }

}
