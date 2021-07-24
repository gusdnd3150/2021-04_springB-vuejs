package com.vuejs.content.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Convert {
	
	static public Map<String,Object> convertMapParam(HttpServletRequest request){
		Map<String,Object> newParam = new HashMap<String, Object>();
		
		Enumeration<?> enm = request.getParameterNames();
		
		
		System.out.println("===============[일반 request 파람]===============");
		
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
	
	
	@SuppressWarnings("unchecked")
	static public Map<String,Object> convertToastGridParam(Map<String,Object> request){
		Map<String,Object> newParam = new HashMap<String, Object>();
		

		Set<String> keys = request.keySet();
		Iterator<String> iter = keys.iterator();
		
		
		System.out.println("===============[ toast grid request 파람]===============");
		
		while(iter.hasNext()) {
			String reKey = (String) iter.next();
			System.out.println("key:   "+ reKey);
			
			if(reKey.contains("deletedRows") || reKey.contains("updatedRows")) {
				List<Map<String,Object>> jsonList = (List<Map<String, Object>>) request.get(reKey);
				//System.out.print(test);
				newParam.put("jsonList", jsonList);
			}else {
				String val =   request.get(reKey).toString();
				if(val == null || val.length() == 0 || val.equals("") || val.equals("undefined")) {
					val = null;
				}
				newParam.put(reKey, val);
				
			}
			
		}

		System.out.println("[ grid convert 후 파람]: "+ newParam.toString());
		System.out.println("==============================");
		
		return newParam;
	} 
	
}
