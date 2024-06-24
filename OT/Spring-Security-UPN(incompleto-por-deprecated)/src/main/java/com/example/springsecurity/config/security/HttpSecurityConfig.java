package com.example.springsecurity.config.security;

import com.example.springsecurity.util.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(
                        sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(authConfig ->
                    authConfig
                            .requestMatchers(HttpMethod.POST, "/api/auth/authenticate")
                            .permitAll()
                            .requestMatchers(HttpMethod.GET,"/api/auth/authenticate")
                            .permitAll()
                            .requestMatchers("/error").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/products")
                            .hasAuthority(Permission.READ_ALL_PRODUCTS.name())
                            .requestMatchers(HttpMethod.POST, "/api/products")
                            .hasAuthority(Permission.SAVE_ONE_PRODUCT.name())
                            .anyRequest().denyAll()
                );


        return http.build();
    }

}
