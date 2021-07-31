package com.vuejs.content.admin.system.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.admin.system.service.MenuService;
import com.vuejs.content.util.Convert;

@RestController
public class MenuController {
	
	@Autowired
	MenuService service;
	
	public Map<String,Object> menuList(HttpServletRequest request){
		return service.menuList(Convert.convertMapParam(request));
	}

}
