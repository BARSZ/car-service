package com.project.cscb869.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Configuration
    public class SecurityConfiguration {
        @Bean
        InMemoryUserDetailsManager userDetailsManager(){
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();

            UserDetails admin = User.withDefaultPasswordEncoder()
                    .username("admin")
                    .password("password")
                    .roles("ADMIN")
                    .build();

            return new InMemoryUserDetailsManager(user, admin);
        }
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.formLogin()
                    .loginPage("/login").permitAll();
            return http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> {
                        auth.requestMatchers("/api/services").permitAll();
                        auth.requestMatchers("/register").permitAll();
                        auth.requestMatchers("/api/workers").hasRole("ADMIN");
                    })
                    .httpBasic(Customizer.withDefaults())
                    .build();
        }
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
}
