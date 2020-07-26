package com.course.HelloSpring2.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // creación de usuario personalizado en memoria
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Se establece a que URL va a tener acceso cada rol
        http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                .hasRole("ADMIN")
                .antMatchers("/", "/personas")
                // cualquier rol
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                // Se establece cual es la página cuando no se tiene permiso
                .exceptionHandling().accessDeniedPage("/errors/403");
    }
}
