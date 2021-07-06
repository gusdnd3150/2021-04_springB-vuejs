package com.vuejs.content.main.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.message.Message;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.main.service.APIService;
import com.vuejs.content.util.Convert;
import com.vuejs.content.util.EntityUtil;
import com.vuejs.content.vo.MainVo;
import com.vuejs.content.vo.UserVo;

@RestController
public class APIController {

	@Autowired
	private APIService service;

	@Autowired
	private EntityUtil entityUtil;

	@CrossOrigin(origins= "http://localhost:8070")
	@PostMapping("/api/join")
	public int join(HttpServletRequest request) {
		return service.joinUser(Convert.convertMapParam(request));
	}

	@CrossOrigin(origins= "http://localhost:8070")
	@PostMapping("/api/login")
	public Map<String,Object> login(HttpServletRequest request) {
		return service.login(Convert.convertMapParam(request));
	}

}
