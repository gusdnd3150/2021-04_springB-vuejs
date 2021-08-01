package com.vuejs.content.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		System.out.println("시큐리티 앤드포인트 접근");
		request.setAttribute("test", "");
		response.sendRedirect("/error");
	}

}
