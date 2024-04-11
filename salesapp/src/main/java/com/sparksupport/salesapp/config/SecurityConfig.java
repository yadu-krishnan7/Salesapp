package com.sparksupport.salesapp.config;

import org.springframework.security.core.userdetails.User; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  
    private final RestAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(RestAuthenticationEntryPoint restAuthenticationEntryPoint){
        this.authenticationEntryPoint = restAuthenticationEntryPoint;
    }

    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http
     .authorizeHttpRequests(authz -> authz.requestMatchers("/api/**").authenticated())
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .httpBasic(httpBasicConfigurer -> httpBasicConfigurer.authenticationEntryPoint(authenticationEntryPoint));

            return http.build();
}
@Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder) { 

    UserDetails admin = User.withUsername("admin") 
            .password(encoder.encode("admin")) 
            .roles("ADMIN", "USER") 
            .build(); 

    UserDetails user = User.withUsername("user") 
            .password(encoder.encode("user")) 
            .roles("USER") 
            .build(); 

    return new InMemoryUserDetailsManager(admin, user); 
} 


 @Bean
 public PasswordEncoder getPasswordEncoder(){
    return new BCryptPasswordEncoder();
 }




   
}
