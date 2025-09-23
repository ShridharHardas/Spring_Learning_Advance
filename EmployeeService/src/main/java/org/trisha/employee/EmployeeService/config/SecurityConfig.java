package org.trisha.employee.EmployeeService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception {
                http.authorizeHttpRequests(auth->
                        auth.requestMatchers("/auth/emp").permitAll()
                        .requestMatchers("/auth/emp/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                    .csrf(csrfConfig->csrfConfig.disable())
                        .formLogin(Customizer.withDefaults());
                return http.build();

    }
    @Bean
    UserDetailsService inmemoryUserDetailsService() {
        UserDetails adminUser= User.withUsername("Shridhar")
                .password(passwordEncoder().encode("@Admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(adminUser);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
