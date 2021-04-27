package com.vuejs.content.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.service.APIService;
import com.vuejs.content.vo.MainVo;

@RestController
public class APIController {
	
	@Autowired
	private APIService service;

	@PostMapping("/api/test")
	public ResponseEntity<MainVo> test(@RequestBody MainVo vo) {
		System.out.println("파람정보 테스트"+vo.toString());
		return new ResponseEntity<MainVo>(vo,HttpStatus.OK);
	}
}
