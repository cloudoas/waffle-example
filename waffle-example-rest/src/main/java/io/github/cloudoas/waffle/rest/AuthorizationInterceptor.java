package io.github.cloudoas.waffle.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthorizationInterceptor implements HandlerInterceptor{
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			logger.info("preHandle - " + request.getRequestURI());
			logger.info("handler - " + handler.getClass().getCanonicalName());		
		}

		return true;
	}
}
