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
		cntPerPage = Integer.parseInt((String) (param.containsKey("cntPerPage") == false ? "7" : param.get("cntPerPage")));
        selectPage = Integer.parseInt((String) (param.containsKey("selectPage") == false ? "1" : param.get("selectPage")));
        
        param.put("startNum", (selectPage - 1 ) * cntPerPage);
        param.put("cntPerPage", cntPerPage);
        param.put("selectPage", selectPage);
        param.put("total", total);
        
        result = session.selectList(sqlQuery,param);
        
        param.put("result", result);
        //System.out.println(param.toString());
	}
	
	public Map<String,Object> getData(){
		return param;
	}
	

}
