package com.exmaple.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests((requests) -> requests
        .antMatchers("/", "/login").permitAll()
        .antMatchers("/api/v1/users/**").hasAnyRole("USER")
        .antMatchers("/api/v1/admins/**").hasAnyRole("ADMIN")
        .anyRequest().authenticated()
      )
      .formLogin()
      .permitAll()
      .and()
      .logout((logout) -> logout.permitAll());

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
