package com.vuejs.content.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class PagingUtill {
	
	private SqlSession session;
	private String sqlQuery;
	private Map<String,Object> param;
	private int total;
	private int selectPage;
	private int cntPerPage;
	private List<Map<String,Object>> result;
	
	public PagingUtill() {}
	public PagingUtill(SqlSession session, String sqlQuery,Map<String,Object> param) {
		this.session = session;
		this.sqlQuery = sqlQuery;
		this.param = param;
		
		try {
			this.invok();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void invok() {
		total =  session.selectOne(sqlQuery+"Count", param);
		 
        selectPage = Integer.parseInt((String) (param.get("selectPage") == null ? "1" : param.get("selectPage")));
        cntPerPage = Integer.parseInt((String) (param.get("cntPerPage") == null ? "9" : param.get("cntPerPage")));
        //selectPage = param.containsKey("selectPage") == false ? 1 : Integer.parseInt(param.get("selectPage").toString());
        //cntPerPage = param.containsKey("cntPerPage") == false ? 9 : Integer.parseInt(param.get("cntPerPage").toString());
        
        param.put("startNum", (selectPage - 1 ) * cntPerPage);
        param.put("cntPerPage", cntPerPage);
        param.put("selectPage", selectPage);
        param.put("total", total);
        
        System.out.println("페이징파람"+param.toString());
        
        result = session.selectList(sqlQuery,param);
        
        param.put("result", result);
       
	}
	
	public Map<String,Object> getData(){
		return param;
	}
	

}
