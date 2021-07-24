package com.vuejs.content.admin.basicInfo.controller;

import java.util.HashMap;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.admin.basicInfo.service.AdminBoardService;
import com.vuejs.content.util.Convert;

@RestController
public class AdminBoardController {
	
	@Autowired AdminBoardService service;
	
	@CrossOrigin(origins= "http://localhost:8070")
	@GetMapping("/api/selectBoardList.json")
	public Map<String,Object> test(HttpServletRequest request) {
		return service.selectBoardList(Convert.convertMapParam(request));
	}
	
	@CrossOrigin(origins= "http://localhost:8070")
	@PostMapping("/api/deleteBoard.json")
	public Map<String,Object> deleteBoard(@RequestBody Map<String,Object> param) {
		return service.deleteBoard(Convert.convertToastGridParam(param));
	}
	
	@CrossOrigin(origins= "http://localhost:8070")
	@PutMapping("/api/updateBoard.json")
	public Map<String,Object> updateBoard(@RequestBody Map<String,Object> param) {
		return service.updateBoard(Convert.convertToastGridParam(param));
	}

}
