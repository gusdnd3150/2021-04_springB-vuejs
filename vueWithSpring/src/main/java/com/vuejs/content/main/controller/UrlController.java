package com.vuejs.content.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController implements ErrorController{

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error";
	}
	
	@RequestMapping("/error")
	public String redirect(HttpServletRequest request) {
		return "index.html";
	}
	
}
