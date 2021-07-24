package com.vuejs.content.admin.basicInfo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuejs.content.admin.basicInfo.dao.AdminBoardDao;

@Service
public class AdminBoardService {
	
	@Autowired
	AdminBoardDao dao;
	
	public Map<String,Object> selectBoardList(Map<String,Object> param){
		return dao.selectBoardList(param);
	}
	
	public Map<String,Object> deleteBoard(Map<String,Object> param) {
		return dao.deleteBoard(param);
	}
	
	public Map<String,Object> updateBoard(Map<String,Object> param) {
		return dao.updateBoard(param);
	}
	
}
