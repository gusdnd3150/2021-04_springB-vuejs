package com.vuejs.content.bestPlace.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vuejs.content.bestPlace.service.BestPlaceService;
import com.vuejs.content.util.Convert;
import com.vuejs.content.vo.UserVo;

@RestController
public class BestPlaceController {
	
	
	@Autowired BestPlaceService service;
	
	@CrossOrigin(origins= "http://localhost:8070")
	@PostMapping("/api/insertBestPlace")
	public int insertBestPlace(@RequestBody Map<String,Object> plObejct) {
		System.out.println("pl data:"+plObejct.toString());
		return service.mergeBestPlace(plObejct);
	}
	
	@CrossOrigin(origins= "http://localhost:8070")
	@PostMapping("/api/selectBestPlace.json")
	public Map<String,Object> selectBestPlace(@RequestBody Map<String,Object> paramInfo){
		return service.selectBestPlace(Convert.convertMapParam(paramInfo)); 
	}
}
