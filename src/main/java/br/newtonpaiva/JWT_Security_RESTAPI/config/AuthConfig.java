package br.newtonpaiva.JWT_Security_RESTAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                        .antMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .antMatchers(HttpMethod.GET, "/auth/username/**").permitAll()
                        .antMatchers(HttpMethod.GET, "/auth/user/**").permitAll()
                        .antMatchers("/auth/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        var user = org.springframework.security.core.userdetails.User.withUsername("arthur")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        var admin = org.springframework.security.core.userdetails.User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
