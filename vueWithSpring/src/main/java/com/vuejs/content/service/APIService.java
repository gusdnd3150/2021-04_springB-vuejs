package com.vuejs.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuejs.content.dao.APIRepository;
import com.vuejs.content.vo.UserVo;

@Service
public class APIService {
	
	@Autowired
	private APIRepository repository;
	
	public String login(UserVo user) {
		String result ="loginfail";
		try {
			UserVo dbUser = repository.selectUserById(user.getUsername());
			if(dbUser != null && user.getPassword().equals(dbUser.getPassword())) {
				result ="success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
