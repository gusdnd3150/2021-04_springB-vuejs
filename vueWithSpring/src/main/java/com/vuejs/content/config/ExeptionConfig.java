package com.vuejs.content.config;

import org.apache.ibatis.javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExeptionConfig {
	
	/*
	 * 특정 예외의 처리를 하고 싶다면 해당 예외 클래스를 상속받아서 구현한 뒤 별도의 로직 구성 후
	 *   @ExceptionHandler 클래스로 넣으면 된다
	 */
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> error400(Exception e) {
		e.printStackTrace();
        System.out.println("공통예외처리 테스트"+ e.getMessage());
        return new ResponseEntity<String>("d",HttpStatus.BAD_REQUEST);
    }
	
	/*
	 * @ExceptionHandler({RuntimeException.class, Exception.class}) public
	 * ResponseEntity<?> error500(Exception e) { log.error("500 Error : " +
	 * catchLog(e)); return ...; }
	 */


}
