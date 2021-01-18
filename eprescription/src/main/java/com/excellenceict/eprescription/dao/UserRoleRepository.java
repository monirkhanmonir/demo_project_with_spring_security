package com.excellenceict.eprescription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellenceict.eprescription.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	int countByRoleName(String name);
	UserRole findByRoleName(String role);
}
