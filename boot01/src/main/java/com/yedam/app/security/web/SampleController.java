package com.yedam.app.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	@GetMapping("all")
	private void all() {}
	
	@GetMapping("user")
	private void user() {}
	
	@GetMapping("admin")
	private void admin(){}
}

