package com.vuejs.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuejs.content.dao.APIRepository;

@Service
public class APIService {
	
	@Autowired
	private APIRepository repository;

}
