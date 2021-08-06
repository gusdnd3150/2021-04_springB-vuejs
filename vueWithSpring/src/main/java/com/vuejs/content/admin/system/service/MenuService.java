package com.vuejs.content.admin.system.service;

import java.util.Map;

public interface MenuService {

	
	/*
	 *  메뉴 리스트
	 * 
	 */
	Map<String,Object> menuList(Map<String,Object> param);
	
	/*
	 *  어드민페이지 메뉴리스트
	 * 
	 */
	Map<String,Object> menuList2(Map<String,Object> param);
}
