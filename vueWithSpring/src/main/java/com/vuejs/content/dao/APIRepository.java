package com.vuejs.content.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class APIRepository {
	
	@Autowired
	private SqlSession sqlsession;

}
