package com.vuejs.content.bestPlace.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vuejs.content.util.PagingUtill;

@Repository
public class BestPlaceDao {
	
	@Autowired SqlSession session;

	public int mergeBestPlace(Map<String,Object> info) {
		return session.insert("bestPlace.mergeBestPlace",info);
	}
	
	
	public Map<String,Object> selectBestPlace(Map<String,Object> paramInfo) {
		PagingUtill pageData=  new PagingUtill(session,"bestPlace.selectBestPlace",paramInfo, "");
		System.out.println(pageData.getData());
		return  pageData.getData();
	}


	
}
