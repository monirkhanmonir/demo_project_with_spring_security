package com.excellenceict.eprescription.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.excellenceict.eprescription.model.UserInfo;

@Configuration
public class BeanConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}


	@Bean
	public PasswordEncoder getPasswordEncoder() {
	
		return new BCryptPasswordEncoder();
	}
	
}
