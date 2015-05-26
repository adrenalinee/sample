package com.malibu.sample.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accessDenied")
public class AccessDeniedController {
	
	/**
	 * 접근권한없으 페이지
	 */
	@RequestMapping("")
	void accessDenied() {
		
	}
}
