package com.springboot.springmvc.securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {


    //JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    /*//In-memory user details
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails jen = User.builder()
                .username("jen")
                .password("{noop}test123")
                .roles("USER")
                .build();
        UserDetails kim = User.builder()
                .username("kim")
                .password("{noop}test123")
                .roles("USER","MODERATOR")
                .build();
        UserDetails kai = User.builder()
                .username("kai")
                .password("{noop}test123")
                .roles("USER", "MODERATOR", "OWNER")
                .build();

        return new InMemoryUserDetailsManager(jen, kim, kai);
    }*/


    //reference custom login form
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("USER")
                        .requestMatchers("/moderators").hasRole("MODERATOR")
                        .requestMatchers("/owners").hasRole("OWNER")
                        .anyRequest().authenticated()
        ).formLogin( form ->
                form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        )
                .logout(logout -> logout.permitAll()


        ).exceptionHandling(configurer ->
                configurer
                        .accessDeniedPage("/access-denied")
                );
    return http.build();
    }
}
