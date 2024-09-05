package com.yedam.app.web.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WebAdvice {
	//예외처리
	@ExceptionHandler
	public ResponseEntity<String> invokeError(IllegalAccessException error){
	return new ResponseEntity<> ("Error Message", HttpStatus.BAD_REQUEST);
	}
	
	//공통변수선언
	@ModelAttribute("contextPath")
	public String contextPath
	(HttpServletRequest request) {
		return request.getContextPath();
	}
}
