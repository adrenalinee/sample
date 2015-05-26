package com.malibu.sample.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/**
	 * 메인 페이지
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
