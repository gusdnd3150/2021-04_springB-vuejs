package com.vuejs.content.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JsonResponseVo {
	
	private String status;
	private String code;
	private String result;

}
