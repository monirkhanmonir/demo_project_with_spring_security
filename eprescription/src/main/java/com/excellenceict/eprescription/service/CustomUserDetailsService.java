package com.excellenceict.eprescription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excellenceict.eprescription.dto.UserPrinciple;
import com.excellenceict.eprescription.model.UserInfo;
import com.excellenceict.eprescription.service.interF.UserServiceInteF;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserServiceInteF userservice;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo user =  userservice.getByUserName(username);
		UserPrinciple userprinciple =  UserPrinciple.create(user);
		
		if(userprinciple == null) {
			throw new UsernameNotFoundException("User Not found");
		}
		return userprinciple;
		
	}
	

}
