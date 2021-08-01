package com.vuejs.content.main.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vuejs.content.vo.UserVo;

@Repository
public class APIRepository {
	
	@Autowired
	private SqlSession sqlsession;

	
	public Map<String,Object> selectUserById(String username) {
		return sqlsession.selectOne("main.selectUserById",username);
	}
	
	public int joinUser(Map<String,Object> user) {
		return sqlsession.insert("main.joinUser",user);
	}
	
	public boolean dupCheck(Map<String,Object> param) {
		int result = sqlsession.selectOne("main.dupCheck",param);
		return result != 0;
	}
	
}
