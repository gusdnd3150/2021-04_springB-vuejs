package com.vuejs.content.admin.basicInfo.dao;

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
		PagingUtill pageData=  new PagingUtill(session,"adminBoard.selectBoardList",paramInfo);
		System.out.println(pageData.getData());
		return  pageData.getData();
	}
	
	public int deleteBoard(Map<String,Object> param) {
		return session.delete("adminBoard.deleteBoard",param);
	}
}
