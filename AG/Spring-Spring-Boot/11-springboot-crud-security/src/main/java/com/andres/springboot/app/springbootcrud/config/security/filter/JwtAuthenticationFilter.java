package com.andres.springboot.app.springbootcrud.config.security.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.andres.springboot.app.springbootcrud.domain.entities.User;
import static com.andres.springboot.app.springbootcrud.config.security.TokenJwtConfig.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        User user = null;
        String password = null;
        String username = null;

        try {
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);

            username = user.getUsername();
            password = user.getPassword();

        } catch (IOException e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);

        return authenticationManager.authenticate(authenticationToken);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult
                .getPrincipal();

        String username = user.getUsername();

        Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();

        Claims claims = Jwts.claims()
                .add("authorities", new ObjectMapper().writeValueAsString(roles))
                .add("username", username)
                .build();

        Date now = new Date();
        Date tokenExpirate = new Date(now.getTime() + EXPIRATION_TIME);

        String token = Jwts.builder()
                .subject(username)
                .claims(claims)
                .signWith(SECRET_KEY)
                .expiration(tokenExpirate)
                .issuedAt(new Date())
                .compact();

        response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);

        Map<String, String> json = new HashMap<>();

        json.put("token", token);
        json.put("username", username);
        json.put("message", "Hola " + username + "has iniciado sesion con exito");

        response.getWriter().write(new ObjectMapper().writeValueAsString(json));

        response.setContentType(CONTENT_TYPE);

        response.setStatus(200);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        Map<String, String> json = new HashMap<>();
        json.put("message", "Error en la autenticacion  username o password incorrecto");
        json.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(json));

        response.setStatus(401);
        response.setContentType(CONTENT_TYPE);

    }

}
