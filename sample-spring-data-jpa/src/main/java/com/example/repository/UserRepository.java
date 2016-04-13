package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	User findByEmail(String email);
	
	List<User> findByName(String name, Pageable pageable);
	
	@Query("select u from User u join u.company on c where c.name = :companyName")
	List<User> getCompanyMember(@Param("companyName") String companyName);
}
