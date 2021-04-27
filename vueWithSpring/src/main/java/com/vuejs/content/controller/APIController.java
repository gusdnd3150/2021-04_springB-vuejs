package com.vuejs.content.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.vo.MainVo;

@RestController
public class APIController {

	@PostMapping("/api/test")
	public String test(@RequestBody MainVo vo) {
		System.out.println("파람정보 테스트"+vo.toString());
		MainVo test = new MainVo();
		test.setId("test~");
		return test.toString();
	}
}
