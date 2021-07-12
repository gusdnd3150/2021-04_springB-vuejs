package com.vuejs.content.admin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuejs.content.admin.dao.AdminBoardDao;

@Service
public class AdminBoardService {
	
	@Autowired
	AdminBoardDao dao;
	
	public Map<String,Object> selectBoardList(Map<String,Object> param){
		return dao.selectBoardList(param);
	}

}
