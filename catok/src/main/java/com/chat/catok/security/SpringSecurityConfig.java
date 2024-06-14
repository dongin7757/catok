package com.chat.catok.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {
	
	@Autowired
	UserDetailsService userDetailService;
	
	@Bean
	public PasswordEncoder loginPasswordEncoder(){
//		return new NoPasswordEncoder();
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf(CsrfConfigurer::disable)
		.cors(Customizer.withDefaults())
		.authorizeHttpRequests(request -> request
		.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
		.requestMatchers("/images/**", "/signUp.do", "/sessionExpired.do").permitAll()
//		.requestMatchers("/admin.do").hasRole("ADMIN") // ADMIN 권한 허용페이지
//		.requestMatchers("/user.do").hasRole("USER") // USER 권한 허용페이지
		.anyRequest().authenticated()
		)
		.formLogin(login -> login
			.loginPage("/loginForm.do")
			.loginProcessingUrl("/login.do")
			.usernameParameter("id")
			.passwordParameter("password")
			.defaultSuccessUrl("/main.do", true)
			.permitAll()
		)
		.logout(logout -> logout
			.logoutUrl("/logout.do")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
		)
		.rememberMe(rememberMe -> rememberMe
			.key("remember-me")
			.tokenValiditySeconds(864000) // 하루
			.userDetailsService(userDetailService)
			.rememberMeParameter("remember-me")
			.rememberMeCookieName("remember-me-cookie")
		)
		.sessionManagement(sessionManagement -> sessionManagement
			.maximumSessions(1) // 최대 허용 세션 수 (-1은 무제한)
			.maxSessionsPreventsLogin(false) // 최대 허용이 넘으면 처리 true는 현재 세션, false는 기존 세션
			.expiredUrl("/sessionExpired.do")
		)
		.sessionManagement(session -> session
			.invalidSessionUrl("/sessionExpired.do")
		)
		;
		return http.build();
	}
	
}
