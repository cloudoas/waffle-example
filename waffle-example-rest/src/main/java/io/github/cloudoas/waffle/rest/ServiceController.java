package io.github.cloudoas.waffle.rest;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServiceController {
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	private static final String CACHED_PRINCIPAL = "session.cached.principal";
	
	@RequestMapping("/hello")
	public String hello() {
		logger.info("handling hello..");
		return "hello";
	}
	
	private Principal getCachedPrincipal(HttpServletRequest request){
		return (Principal) request.getSession(true).getAttribute(CACHED_PRINCIPAL);
	}
	
	private void cachePrincipal(HttpServletRequest request, Principal principal) {
		if (null!=principal) {
			request.getSession(true).setAttribute(CACHED_PRINCIPAL, principal);
		}
	}
	
	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request) {
		logger.info("handling userInfo..");
		Principal principal = getCachedPrincipal(request);
		
		if (null==principal) {
			logger.info("no cached principal. get from request.");
			principal = request.getUserPrincipal();
			
			cachePrincipal(request, principal);
		}else {
			logger.info("use cached principal.");
		}
		
		return null==principal?"You are not authroized.":String.format("You are logged in as: %s", request.getUserPrincipal());
	}
}
