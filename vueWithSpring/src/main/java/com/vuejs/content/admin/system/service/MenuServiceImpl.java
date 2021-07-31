package com.vuejs.content.admin.system.service;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuejs.content.admin.system.dao.MenumDao;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	MenumDao dao;

	@Override
	public Map<String, Object> menuList(Map<String, Object> param) {
		return dao.menuList(param);
	}

}
