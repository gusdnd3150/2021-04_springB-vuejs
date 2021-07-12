package com.vuejs.content.config;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class SingleToneBean {
	
	static private List<Map<String,Object>> data;
	
	@PostConstruct
	public void init() {
		// 임시로 생성 나중에 싱글톤 필요할 경우 여기서 처리하자
		System.out.print("싱글톤 빈 생성 및 초기화 메서드 지정");
		
		setData(); // 필요한 데이터를 초기화시키는 함수
	}
	
	
	public void setData() { // 나중에 필요하면 사용
		
		
		//data = ...
		
	}

}
