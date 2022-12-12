package com.store.william.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Deprecated
public class LogInterceptor extends HandlerInterceptorAdapter{
	
	public LogInterceptor() {
		super();
		System.out.println(this);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println(request.getContentType());		
		System.out.println(request.getHeader(""));		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(response.getContentType());		
		System.out.println(response.getHeader(""));		
		super.postHandle(request, response, handler, modelAndView);
	}
	
		

}
