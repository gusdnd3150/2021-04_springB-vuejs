package com.vuejs.content.bestPlace.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuejs.content.bestPlace.dao.BestPlaceDao;

@Service
public class BestPlaceService {
	
	@Autowired BestPlaceDao dao;

	
	public int mergeBestPlace(Map<String,Object> info) {
		return dao.mergeBestPlace(info);
	}
	
	public Map<String,Object> selectBestPlace(Map<String,Object> paramInfo) {
		return dao.selectBestPlace(paramInfo);
	}
}
