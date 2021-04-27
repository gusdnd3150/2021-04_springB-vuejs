package com.vuejs.content.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MainVo {

	private String id;
	private String username;
	private String password;
}
