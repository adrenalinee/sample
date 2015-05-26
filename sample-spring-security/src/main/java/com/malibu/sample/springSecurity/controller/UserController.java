package com.malibu.sample.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malibu.sample.springSecurity.entity.User;
import com.malibu.sample.springSecurity.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 사용자 목록 페이지
	 * @param model
	 */
	@RequestMapping("")
	public void users(Model model) {
		Iterable<User> users = userService.getAll();
		model.addAttribute("users", users);
	}
	
	/**
	 * 로그인한 사용자의 개인정보 보기 페이지
	 * @param userDetails
	 * @param model
	 * @return
	 */
	@RequestMapping("me")
	public String me(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		String userId = userDetails.getUsername();
		
		User user = userService.get(userId);
		if (user == null) {
			throw new RuntimeException("user not exist. userId: " + userId);
		}
		
		model.addAttribute("user", user);
		
		return "users/view";
	}
	
	/**
	 * 특정사용자의 개인 정보 보기 페이지
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("{userId}")
	public String view(@PathVariable String userId, Model model) {
		User user = userService.get(userId);
		if (user == null) {
			throw new RuntimeException("user not exist. userId: " + userId);
		}
		
		model.addAttribute("user", user);
		
		return "users/view";
	}
	
}
