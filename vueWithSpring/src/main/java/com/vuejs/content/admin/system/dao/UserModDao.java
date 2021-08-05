package com.vuejs.content.admin.system.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vuejs.content.util.PagingUtill;

@Repository
public class UserModDao {
	
	@Autowired
	SqlSession session;
	
	public Map<String,Object> userList(Map<String,Object> paramInfo) {
		PagingUtill pageData=  new PagingUtill(session,"userMod.userList",paramInfo,"grid");
		//System.out.println(pageData.getData());
		return  pageData.getData();
	}

	public Map<String,Object> updateUser(Map<String,Object> param) {
		Map<String,Object> result = new HashMap<String, Object>();
		
		try {
			session.update("userMod.updateUser",param);
			result.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", false);
		}
		return result;
	}
}
