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
		String result ="";
		try {
			UserVo dbUser = repository.selectUserById(user.getUsername());
			if(dbUser != null && user.getPassword().equals(dbUser.getPassword())) {
				result ="success";
			}
			result ="notFound";
		} catch (Exception e) {
			result = e.getMessage();
			e.printStackTrace();
			result="success";
		}
		return result;
	}

}
