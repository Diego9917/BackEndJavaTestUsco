package diegocode.diegotest.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import diegocode.diegotest.Jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration // van a tener metodos que van a estar marcados con configuration bean
@EnableWebSecurity // habilita la seguridad web
@RequiredArgsConstructor

public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    // filtros para la seguridad

    // diferenciar los publicos de los privados
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http 
            .csrf(csrf ->
            csrf.disable()) 
        .authorizeHttpRequests(authRequest -> 
            authRequest
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
        ) 
        .sessionManagement(sessionManagement ->
            sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
        
    }
}