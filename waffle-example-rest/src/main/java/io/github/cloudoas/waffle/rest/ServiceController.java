package io.github.cloudoas.waffle.rest;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request) {
		Principal princiapl = request.getUserPrincipal();
		
		return null==princiapl?"You are not authroized.":String.format("You are logged in as: %s", request.getUserPrincipal());
	}
}
