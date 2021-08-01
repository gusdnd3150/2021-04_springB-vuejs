package com.vuejs.content.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private JwtTokenProvider jwtTokenProvider;

	// private final JwtTokenProvider jwtTokenProvider;

	public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Bean  // 권한이 있는 유저가 권한이 미치지 않는 페이지를 이동할 경우
	public AccessDeniedFilter accessDeniedFilter() {
		return new AccessDeniedFilter();
	}
	
	@Bean  // 권한도 없이 페이지에서 접근하려고 했을 경우
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint();
	}
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf().disable().
				sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 역시 사용하지 않습니다.
				.and().
				authorizeRequests().
				antMatchers("/admin/**").hasRole("ADMIN").
				antMatchers("/user/**").hasRole("USER").
				anyRequest().
				permitAll().
				and().
				addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class).
				exceptionHandling().accessDeniedHandler(accessDeniedFilter()).authenticationEntryPoint(authenticationEntryPoint())   // 권한이 낮거나 접근이 제한될 경우
				;
		
	}
}
