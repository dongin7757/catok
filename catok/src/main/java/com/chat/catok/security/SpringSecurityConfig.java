package com.chat.catok.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf(CsrfConfigurer::disable)
		.cors(Customizer.withDefaults())
		.authorizeHttpRequests(request -> request
		.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
		.requestMatchers("/images/**", "/signUp.do").permitAll()
		.requestMatchers("/admin.do").hasRole("ADMIN")
		.requestMatchers("/user.do").hasRole("USER")
		.anyRequest().authenticated()
		)
		.formLogin(login -> login
		.loginPage("/loginForm.do")
		.loginProcessingUrl("/login.do")
		.usernameParameter("id")
		.passwordParameter("password")
		.defaultSuccessUrl("/loginSuccess.do", true)
		.permitAll()
		)
		.logout(logout -> logout
		.logoutUrl("/logout.do")
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		)
		;
		return http.build();
	}
	
	@Bean
	public PasswordEncoder loginPasswordEncoder(){
		return new NoPasswordEncoder();
	}
}
