package com.malibu.sample.springSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malibu.sample.springSecurity.entity.User;
import com.malibu.sample.springSecurity.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional(readOnly=true)
	public Iterable<User> getAll() {
		return userRepository.findAll();
	}
	
	@Transactional
	public User get(String userId) {
		return userRepository.findOne(userId);
	}
}
