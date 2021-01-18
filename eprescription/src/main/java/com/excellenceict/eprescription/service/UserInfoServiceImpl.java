package com.excellenceict.eprescription.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellenceict.eprescription.dao.UserInfoRepository;
import com.excellenceict.eprescription.model.UserInfo;
import com.excellenceict.eprescription.service.interF.UserServiceInteF;

@Service
public class UserInfoServiceImpl implements UserServiceInteF{
	@Autowired
	UserInfoRepository userRepo;
	
	@Override
	public UserInfo saveUser(UserInfo user) {
		
		return userRepo.save(user);
	}

	@Override
	public UserInfo updateUser(UserInfo user) {
		
		return userRepo.save(user);
	}

	@Override
	public UserInfo getById(Long id) {
		Optional<UserInfo> userOptional = userRepo.findById(id);
		if(userOptional.isPresent() && userOptional.get() !=null) {
			return userOptional.get();
		}
		return null;
	}

	@Override
	public UserInfo getByUserName(String username) {
		
		return userRepo.findByUsername(username);
		
	}

	@Override
	public String userDelete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
