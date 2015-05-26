package com.malibu.sample.springSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malibu.sample.springSecurity.entity.User;
import com.malibu.sample.springSecurity.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	List<UserRole> findByUser(User user);
}
