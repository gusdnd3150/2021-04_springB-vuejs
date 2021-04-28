package com.vuejs.content.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vuejs.content.vo.UserVo;

@Repository
public class APIRepository {
	
	@Autowired
	private SqlSession sqlsession;

	
	public UserVo selectUserById(String username) {
		return sqlsession.selectOne("main.selectUserById",username);
	}
	
}
