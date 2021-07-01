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
	
	static public Map<String,Object> convertMapParam( Map<String,Object> paramMap){
		Map<String,Object> newParam = new HashMap<String, Object>();
		
		Map<String,Object> params = (Map<String, Object>) paramMap.get("params");
		
		Set<String> keySet = params.keySet();
		Iterator<String> it = keySet.iterator();
		

		while(it.hasNext()) {
			String MapKey = it.next();
			System.out.println("key:"+ MapKey);
			
			String val =   params.get(MapKey).toString();
			if(val == null || val.length() == 0 || val.equals("")) {
				val = null;
			}
			newParam.put(MapKey, val);
		}
		
		/*
		while(it.hasNext()) {
			String MapKey = it.next();
			System.out.println("key:"+ MapKey);
			
			String val =   paramMap.get(MapKey).toString();
			if(val == null || val.length() == 0 || val.equals("")) {
				val = null;
			}
			newParam.put(MapKey, val);
		}*/
		
		
		/*
		if(!newParam.containsKey("cntPerPage")){  //페이지당 보여줄 개수 
			newParam.put("cntPerPage", 7);
		}*/
		
		System.out.println("convert 파람: "+ newParam.toString());
		
		return newParam;
	} 

}
