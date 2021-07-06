package com.vuejs.content.util;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDao {
	
	@Autowired
	private SqlSession session;
	
	public int insertFile(Map<String,Object> param) {
		System.out.println("파일"+ param.toString());
		return session.insert("FileDao.insertFile", param);
	}

}
