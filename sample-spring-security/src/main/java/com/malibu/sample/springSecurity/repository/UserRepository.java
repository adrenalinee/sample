package com.malibu.sample.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malibu.sample.springSecurity.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
