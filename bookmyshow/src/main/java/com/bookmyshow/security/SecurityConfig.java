package com.bookmyshow.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Slf4j
@Profile("!test")
public class SecurityConfig {

    @Value("${bookmyshow.user.name}")
    private String username;
    @Value("${bookmyshow.user.password}")
    private String password;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable().authorizeHttpRequests()
                .requestMatchers("/api-docs/**",
                        "/swagger-ui/**", "/actuator/**").permitAll();
        http.httpBasic(withDefaults());
        http.
        authorizeHttpRequests().requestMatchers("/api/**").hasRole("ADMIN")
                .requestMatchers("/api/v1/platforOffers/", "/api/v1/theatre/")
                .hasRole("USER")
                .anyRequest().authenticated();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .roles("USER", "ADMIN")
                .build());
        manager.createUser(User.withUsername(username)
                .password(passwordEncoder().encode(password))
                .roles("USER")
                .build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
