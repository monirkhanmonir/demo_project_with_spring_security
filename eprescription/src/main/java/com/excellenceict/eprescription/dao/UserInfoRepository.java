package com.excellenceict.eprescription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellenceict.eprescription.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
	UserInfo findByUsername(String username);
}
