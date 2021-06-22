package com.vuejs.content.main.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlController implements ErrorController{

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error";
	}
	
	@GetMapping("/error")
	public String redirect() {
		return "index.html";
	}
	
}
