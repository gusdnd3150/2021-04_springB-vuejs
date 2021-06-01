package com.vuejs.content.controller;

import org.apache.logging.log4j.message.Message;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.service.APIService;
import com.vuejs.content.util.EntityUtil;
import com.vuejs.content.vo.MainVo;
import com.vuejs.content.vo.UserVo;

@RestController
public class APIController {

	@Autowired
	private APIService service;

	@Autowired
	private EntityUtil entityUtil;

	@PostMapping("/api/join")
	public int join(@RequestBody UserVo user) {
		return service.joinUser(user);
	}

	@PostMapping("/api/login")
	public UserVo login(@RequestBody UserVo user) {
		System.out.println("정보:"+user.toString());
		return service.login(user);
	}

	@PostMapping("/admin")
	public void adminTest(@RequestBody UserVo user) {
		System.out.println("admin 토큰 검사 통과");
	}

	@PostMapping("/user/resouce")
	public String userTest(@RequestBody UserVo user) {
		System.out.println("user 토큰 검사 통과");
		service.testauth(user.getToken());
		return "ok";
	}

	@PostMapping("/api/test")
	public String test(@RequestBody UserVo user) {
		service.testauth(user.getToken());
		return "ok";
	}

	@GetMapping("/user/test")
	public String usertest(@RequestBody UserVo user) {
		service.testauth(user.getToken());
		System.out.println("인증 통과 후 여길타나?...");
		return "ok";
	}

}
