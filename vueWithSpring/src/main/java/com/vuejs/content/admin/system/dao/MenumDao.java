package com.vuejs.content.admin.system.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenumDao {
	
	@Autowired
	SqlSession session;
	
	
	/*
	 *  메뉴 리스트
	 * 
	 */
	public Map<String, Object> menuList(Map<String, Object> param) {
		Map<String, Object> list = new HashMap<String, Object>();
		list.put("result", session.selectList("menu.menuList",param));
		return list;
	}
}
