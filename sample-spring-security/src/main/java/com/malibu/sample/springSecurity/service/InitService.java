package com.malibu.sample.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malibu.sample.springSecurity.entity.Role;
import com.malibu.sample.springSecurity.entity.User;
import com.malibu.sample.springSecurity.entity.UserRole;
import com.malibu.sample.springSecurity.repository.RoleRepository;
import com.malibu.sample.springSecurity.repository.UserRepository;
import com.malibu.sample.springSecurity.repository.UserRoleRepository;

@Service
public class InitService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Transactional
	public void initData() {
		initAdmi();
		initUser();
	}
	
	private void initAdmi() {
		Role role = new Role();
		role.setName("관리자");
		role.setAuthority("ADMIN");
		roleRepository.save(role);
		
		User user = new User();
		user.setUserId("adrenal");
		user.setName("신동성");
		user.setPassword("1234");
		user.setEmail("asdf@ghjk.com");
		userRepository.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		userRoleRepository.save(userRole);
	}
	
	private void initUser() {
		Role role = new Role();
		role.setName("일반 사용자");
		role.setAuthority("USER");
		roleRepository.save(role);
		
		User user = new User();
		user.setUserId("windmil");
		user.setName("심풍풍");
		user.setPassword("5678");
		user.setEmail("qwer@tyui.net");
		userRepository.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		userRoleRepository.save(userRole);
	}
}
