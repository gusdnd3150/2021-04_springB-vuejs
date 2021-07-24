package com.vuejs.content.admin.basicInfo.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vuejs.content.util.PagingUtill;

@Repository
public class AdminBoardDao {
	
	@Autowired
	SqlSession session;

	
	public Map<String,Object> selectBoardList(Map<String,Object> paramInfo) {
		PagingUtill pageData=  new PagingUtill(session,"adminBoard.selectBoardList",paramInfo,"grid");
		System.out.println(pageData.getData());
		return  pageData.getData();
	}
	
	public Map<String,Object> deleteBoard(Map<String,Object> param) {
		Map<String,Object> result = new HashMap<String, Object>();
		
		try {
			session.delete("adminBoard.deleteBoard",param);
			result.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
		}
		return result;
	}
	
	public Map<String,Object> updateBoard(Map<String,Object> param) {
		Map<String,Object> result = new HashMap<String, Object>();
		
		try {
			session.update("adminBoard.mergeBoard",param);
			result.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
		}
		return result;
	}
}
