package com.vuejs.content.vo;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
public class UserVo {
	
	private String username;
	private String password;
	private String role;
	private String token;
	
}
