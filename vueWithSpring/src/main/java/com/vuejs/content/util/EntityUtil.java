package com.vuejs.content.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class EntityUtil {
	
	public ResponseEntity<Object> getResponseResult(String result,@Nullable Object vo){
		System.out.println("result Message:"+result);
		if(result.equals("success")) {
			return new ResponseEntity<Object>(result,HttpStatus.OK);
		}else if(result.equals("notFound")) {
			return new ResponseEntity<Object>(result,HttpStatus.NO_CONTENT);
		}else if(result.equals("fail")) {
			return new ResponseEntity<Object>(result,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(result,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
