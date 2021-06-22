package com.vuejs.content.bestPlace.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BestPlaceDao {
	
	@Autowired SqlSession session;

}
