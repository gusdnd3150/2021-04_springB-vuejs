package com.vuejs.content.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private JwtTokenProvider jwtTokenProvider;

	public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	// OncePerRequestFilter 사용
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
		// header에서 값을 추출하는 것"X-AUTH-TOKEN"
		
		System.out.println("토큰"+token);
		System.out.println("토큰 유효성 검사:" + jwtTokenProvider.validateToken(token));
		
		if (token != null && jwtTokenProvider.validateToken(token)) {
			Authentication authentication = jwtTokenProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("검사 통과----------------------------------------");
		}
		
		filterChain.doFilter(request, response);
		
		
	}

	
	// GenericFilterBean 필터 구현 시 사용
	/*@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
		// header에서 값을 추출하는 것"X-AUTH-TOKEN"
		
		System.out.println("토큰"+token);
		System.out.println("토큰 유효성 검사:" + jwtTokenProvider.validateToken(token));
		
		if (token != null && jwtTokenProvider.validateToken(token)) {
			Authentication authentication = jwtTokenProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("검사 통과----------------------------------------");
		}
		
		chain.doFilter(request, response);
	}*/
}
