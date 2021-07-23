package com.vuejs.content.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
	
	
	static public Map<String,Object> convertToastGridParam(HttpServletRequest request){
		Map<String,Object> newParam = new HashMap<String, Object>();
		

		
		Enumeration<?> enm = request.getParameterNames();
		
		
		
		System.out.println("===============[request 파람]===============");
		
		while(enm.hasMoreElements()) {
			String reKey = (String) enm.nextElement();
			System.out.println("key:   "+ reKey);
			
			if(reKey.contains("deletedRows")) {
				String jsonList = request.getParameter("deletedRows");
				System.out.println("여길타나"+ jsonList);
			}else {
				String val =   request.getParameter(reKey).toString();
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
