package com.vuejs.content.bestPlace.controller;

import java.util.Iterator;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vuejs.content.bestPlace.service.BestPlaceService;
import com.vuejs.content.util.Convert;
import com.vuejs.content.util.FileService;
import com.vuejs.content.vo.UserVo;

@RestController
public class BestPlaceController {
	
	
	@Autowired BestPlaceService service;
	@Autowired FileService fileService;
	
	@CrossOrigin(origins= "http://localhost:8070")
    @RequestMapping(path="/api/insertBestPlace.json",method=RequestMethod.POST)
	public int insertBestPlace(HttpServletRequest request) {
		fileService.fileUpload(request,"bestPlace","image");
		Convert.convertMapParam(request);
		//service.mergeBestPlace(Convert.convertMapParam(plObejct))
		return 1;
	}
	
	@CrossOrigin(origins= "http://localhost:8070")
	@RequestMapping("/api/selectBestPlace.json")
	public Map<String,Object> selectBestPlace(HttpServletRequest request){
		return service.selectBestPlace(Convert.convertMapParam(request)); 
	}
}
