package com.malibu.sample.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malibu.sample.springSecurity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
