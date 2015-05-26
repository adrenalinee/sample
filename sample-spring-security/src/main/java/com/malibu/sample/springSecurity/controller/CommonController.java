package com.malibu.sample.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	/**
	 * 접근권한없음 페이지
	 */
	@RequestMapping("/accessDenied")
	public void accessDenied() {
		
	}
	
	/**
	 * 로그인 페이지
	 */
	@RequestMapping("/login")
	public void login() {
		
	}
}
