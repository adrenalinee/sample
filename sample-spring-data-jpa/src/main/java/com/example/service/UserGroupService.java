package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.UserGroup;
import com.example.predicate.UserGroupPredicate;
import com.example.repository.UserGroupRepository;

@Service
public class UserGroupService {
	
	@Autowired
	UserGroupRepository userGroupRepository;
	
	@Transactional(readOnly=true)
	public Page<UserGroup> search(Long userGroupId, String userName, Pageable pageable) {
		return userGroupRepository.findAll(UserGroupPredicate.search(userGroupId, userName), pageable);
	}
}
