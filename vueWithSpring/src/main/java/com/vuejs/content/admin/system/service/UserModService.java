package com.vuejs.content.admin.system.service;

import java.util.Map;

public interface UserModService {
	
	Map<String,Object> userList(Map<String,Object> param);
	
	Map<String,Object> updateUser(Map<String,Object> param);
	
	
}
