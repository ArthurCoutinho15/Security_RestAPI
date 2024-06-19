package br.newtonpaiva.JWT_Security_RESTAPI.config;

import br.newtonpaiva.JWT_Security_RESTAPI.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {


    @Autowired
    private CustomUserDetailService userDetailsService;

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
                .httpBasic(); // ou .formLogin() se preferir
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}

