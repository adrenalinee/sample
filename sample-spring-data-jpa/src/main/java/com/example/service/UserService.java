package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional(readOnly=true)
	public User getUser(String userId) {
		return userRepository.findOne(userId);
	}
	
	@Transactional(readOnly=true)
	public Page<User> getLiset(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
}
