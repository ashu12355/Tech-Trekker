package org.ashu.tech_trekker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    
    @Bean
    UserDetailsService userDetailsService() {
        var user1 = User.builder()
        .username("Ashu")
        .password(passwordEncoder().encode("ashu"))
        .roles("")
        .build();

        var user2 = User.builder()
        .username("Rahul")
        .password(passwordEncoder().encode("rahul"))
        .roles("")
        .build();
        
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
    
}
