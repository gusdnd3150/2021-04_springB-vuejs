package com.vuejs.content.admin.system.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuejs.content.admin.system.dao.UserModDao;

@Service
public class UserModServiceImpl implements UserModService{

	@Autowired
	UserModDao dao;

	@Override
	public Map<String, Object> userList(Map<String, Object> param) {
		return dao.userList(param);
	}

	@Override
	public Map<String, Object> updateUser(Map<String, Object> param) {
		return dao.updateUser(param);
	}
}
