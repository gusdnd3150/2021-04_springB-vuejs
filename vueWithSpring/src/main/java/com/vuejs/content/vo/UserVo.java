package com.vuejs.content.vo;

import org.springframework.stereotype.Component;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
public class UserVo {
	
	private String user_id;
	private String user_pwd;
	private String user_auth;
	private String token;
	
}
