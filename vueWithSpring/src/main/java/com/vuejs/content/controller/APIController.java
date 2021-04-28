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
import com.vuejs.content.vo.MainVo;
import com.vuejs.content.vo.UserVo;

@RestController
public class APIController {
	
	@Autowired
	private APIService service;

	@GetMapping("/api/test")
	public ResponseEntity<MainVo> test(@RequestBody MainVo vo) {
		System.out.println("파람정보 테스트"+vo.toString());
		return new ResponseEntity<MainVo>(vo,HttpStatus.OK);
	}
	
	@PostMapping("/api/login")
	public ResponseEntity<String> login(@RequestBody UserVo user){
		String result = "";
		ResponseEntity<String> response = null;
		
		try {
			result = service.login(user);
			response = new ResponseEntity<String>(result,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response =  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
