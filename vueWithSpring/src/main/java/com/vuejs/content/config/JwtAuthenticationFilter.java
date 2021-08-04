package com.vuejs.content.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private JwtTokenProvider jwtTokenProvider;
	private ObjectMapper objectMapper = new ObjectMapper();

	public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	// OncePerRequestFilter 사용
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Map<String, Object> responseMessage = new HashMap<String, Object>();

		String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
		// header에서 값을 추출하는 것"X-AUTH-TOKEN"

		System.out.println("토큰" + token);
		System.out.println("토큰 유효성 검사:" + jwtTokenProvider.validateToken(token));

		if (token != null && jwtTokenProvider.validateToken(token)) {
			Authentication authentication = jwtTokenProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("검사 통과----------------------------------------");
			request.setAttribute("user_id", jwtTokenProvider.getUserPk(token));
		}
		/*	
		else if() {
			/* 이곳에 토큰값 유효시간 만료될 경우 로직을 짜서 response로 보낸 후 axios인터셉터에서 로그인연장을 진행하면될듯 */
			/*
		 response.setContentType("application/json");
		 response.setCharacterEncoding("utf-8");
		 responseMessage.put("result", "no Autho"); String result =
		 objectMapper.writeValueAsString(responseMessage);
		 response.getWriter().write(result);
			 
		}
			 */
		filterChain.doFilter(request, response);

		  
		 

	}

	// GenericFilterBean 필터 구현 시 사용
	/*
	 * @Override public void doFilter(ServletRequest request, ServletResponse
	 * response, FilterChain chain) throws IOException, ServletException {
	 * HttpServletRequest hRequest = (HttpServletRequest) request;
	 * 
	 * String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
	 * // header에서 값을 추출하는 것"X-AUTH-TOKEN" // HttpServletRequest 와 일반 SevletRequest는
	 * 다른듯하다 set,get이 컨트롤러에서 안먹힘
	 * 
	 * System.out.println("토큰"+token); System.out.println("토큰 유효성 검사:" +
	 * jwtTokenProvider.validateToken(token));
	 * 
	 * if (token != null && jwtTokenProvider.validateToken(token)) { Authentication
	 * authentication = jwtTokenProvider.getAuthentication(token);
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * System.out.println("검사 통과----------------------------------------"); }
	 * chain.doFilter(request, response); }
	 */
}
