package com.vuejs.content.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.util.Convert;

@RestController
public class InterceptorController {
	
	@CrossOrigin(origins= "http://localhost:8070")
	@RequestMapping("/api/interceptor")
	public Map<String,Object> interceptorTest(HttpServletRequest request) {
		System.out.println("여길타나");
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("result", "test");
		
		return response;
	}
}
