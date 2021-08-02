package com.vuejs.content.admin.system.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.admin.system.service.MenuService;
import com.vuejs.content.util.Convert;

@RestController
public class MenuController {
	
	@Autowired
	MenuService service;
	
	@CrossOrigin(origins= "http://localhost:8070")
	@RequestMapping("/api/getMenuList.json")
	public Map<String,Object> menuList(HttpServletRequest request){
		return service.menuList(Convert.convertMapParam(request));
	}

}
