package com.vuejs.content.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextHolder  implements ApplicationContextAware  {

	private static ApplicationContext appCtx;
	
	public ContextHolder() {
    }
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext; 
	}
	
	public static ApplicationContext getContext() {
		return appCtx;
	}
}
