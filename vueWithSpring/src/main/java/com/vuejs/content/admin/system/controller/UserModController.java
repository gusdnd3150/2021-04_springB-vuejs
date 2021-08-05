package com.vuejs.content.admin.system.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.admin.system.service.UserModService;
import com.vuejs.content.util.Convert;

@RestController
public class UserModController {
	
	@Autowired
	UserModService service;
	

	@CrossOrigin(origins= "http://localhost:8070")
	@GetMapping("/api/userList.json")
	public Map<String,Object> userList(HttpServletRequest request) {
		return service.userList(Convert.convertMapParam(request));
	}
	
	@CrossOrigin(origins= "http://localhost:8070")
	@PutMapping("/api/updateUser.json")
	public Map<String,Object> updateUser(@RequestBody Map<String,Object> param) {
		return service.updateUser(Convert.convertToastGridParam(param));
	}
	/*
	@CrossOrigin(origins= "http://localhost:8070")
	@PostMapping("/api/deleteBoard.json")
	public Map<String,Object> deleteBoard(@RequestBody Map<String,Object> param) {
		return service.deleteBoard(Convert.convertToastGridParam(param));
	}
	
*/
}
