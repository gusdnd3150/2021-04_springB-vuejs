package com.vuejs.content.bestPlace.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BestPlaceDao {
	
	@Autowired SqlSession session;

	public int mergeBestPlace(Map<String,Object> info) {
		return session.insert("bestPlace.mergeBestPlace",info);
	}
}
