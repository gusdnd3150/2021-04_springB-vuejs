package com.vuejs.content.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class Convert {
	
	static public Map<String,Object> convertMapParam(HttpServletRequest request){
		Map<String,Object> newParam = new HashMap<String, Object>();
		
		Enumeration<?> enm = request.getParameterNames();
		
		
		System.out.println("===============[request 파람]===============");
		
		while(enm.hasMoreElements()) {
			String reKey = (String) enm.nextElement();
			System.out.println("key:   "+ reKey);
			
			String val =   request.getParameter(reKey).toString();
			if(val == null || val.length() == 0 || val.equals("") || val.equals("undefined")) {
				val = null;
			}
			newParam.put(reKey, val);
		}

		System.out.println("[convert 후 파람]: "+ newParam.toString());
		System.out.println("==============================");
		
		return newParam;
	}
	
	/*
	static public Map<String,Object> convertMapParam(Map<String,Object> paramMap){
		Map<String,Object> newParam = new HashMap<String, Object>();
		
		Map<String,Object> params = (Map<String, Object>) paramMap.get("params");
		
		Set<String> keySet = params.keySet();
		Iterator<String> it = keySet.iterator();
		

		System.out.println("===============[paramMap 파람]===============");
		
		while(it.hasNext()) {
			String MapKey = it.next();
			System.out.println("key:   "+ MapKey);
			
			String val =   params.get(MapKey).toString();
			if(val == null || val.length() == 0 || val.equals("")) {
				val = null;
			}
			newParam.put(MapKey, val);
		}
		System.out.println("[convert 후 파람]: "+ newParam.toString());
		System.out.println("==============================");
		
		return newParam;
	} 
	*/
}
