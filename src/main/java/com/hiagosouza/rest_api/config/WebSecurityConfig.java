package com.hiagosouza.rest_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  private static final String[] SWAGGER_WHITELIST = {
      "/v2/api-docs",
      "/swagger-resources",
      "/swagger-resources/**",
      "/configuration/ui",
      "/configuration/security",
      "/swagger-ui.html",
      "/webjars/**"
  };

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(auth -> {
          auth.requestMatchers(SWAGGER_WHITELIST).permitAll();
          auth.requestMatchers("/").permitAll();
          auth.requestMatchers(HttpMethod.POST, "/login", "/users/create").permitAll();
          auth.requestMatchers("/manager", "/users", "/users/all").hasAnyRole("MANAGER");
          auth.requestMatchers("/user").hasAnyRole("USER", "MANAGER");
          auth.anyRequest().authenticated();
        })
        .formLogin(Customizer.withDefaults())
        .logout(LogoutConfigurer::permitAll)
        .build();

  }
}
