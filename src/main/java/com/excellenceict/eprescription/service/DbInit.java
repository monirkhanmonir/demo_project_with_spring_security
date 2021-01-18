package com.excellenceict.eprescription.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.excellenceict.eprescription.dao.UserInfoRepository;
import com.excellenceict.eprescription.dao.UserRoleRepository;
import com.excellenceict.eprescription.model.UserInfo;
import com.excellenceict.eprescription.model.UserRole;

@Configuration
public class DbInit {
	
	@Autowired
	UserInfoRepository userrepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRoleRepository roleRepo;
	@Value("${login.username}")
	private String username;
	@Value("${login.password}")
	private String password;
	
	
	@PostConstruct
	private void init() {
		String u_role = "ROLE_ADMIN";
		int roleExistCount = roleRepo.countByRoleName(u_role);
		System.out.println("Passsword:"+passwordEncoder.encode(password));
		UserRole role = null;
		if(roleExistCount == 1) {
			
			role  = roleRepo.findByRoleName(u_role);
		}else {
			role = new UserRole();
			role.setRoleName(u_role);
			role  = roleRepo.save(role);
		}
		
		UserInfo userInfo  = userrepo.findByUsername(username);
		if(	userInfo == null) {
			userInfo  = new UserInfo();
			userInfo.setEmail("test@gmail.com");
			userInfo.setUsername(username);
			userInfo.setPasssword(passwordEncoder.encode(password));
			
			
		}
		userInfo.setRoles(Arrays.asList(role));		
		userrepo.save(userInfo);
		
	}
}
