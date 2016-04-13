package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.example.entity.UserGroup;

public interface UserGroupRepository
	extends JpaRepository<UserGroup, String>,
	QueryDslPredicateExecutor<UserGroup> {
	
	UserGroup findByName(String name);
}
