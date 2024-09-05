package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // bean 등록, web과 관련된 부분 담당
public class URLController {
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	@GetMapping("/test")
	@ResponseBody // => AJAX 데이터만 반환
	public String urlGetTest(String keyword) {
		return "Server Response : Get Method \n Select - " + keyword;
	}

	@RequestMapping(path = "/test", method = RequestMethod.POST)
	@ResponseBody // => AJAX 데이터만 반환
	public String urlPostTest(String keyword) {
		return "Server Response : Get Method \n Select - " + keyword;
	}
}