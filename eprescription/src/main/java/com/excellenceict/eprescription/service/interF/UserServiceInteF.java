package com.excellenceict.eprescription.service.interF;

import java.util.List;

import org.springframework.stereotype.Service;

import com.excellenceict.eprescription.model.UserInfo;

public interface UserServiceInteF {
	UserInfo saveUser(UserInfo user);
	UserInfo updateUser(UserInfo user);
	UserInfo getById(Long id);
	UserInfo getByUserName(String username);
	String userDelete(Long id);
	List<UserInfo> getAll();
}
