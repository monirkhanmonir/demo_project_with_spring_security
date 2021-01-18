package com.excellenceict.eprescription.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;


@Configuration
public class MyAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{

		
	private static final  org.apache.logging.log4j.Logger  logger = org.apache.logging.log4j.LogManager.getLogger(MyAuthenticationEntryPoint.class.getName());
	
	

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException{
		response.addHeader("WWW-Authentication", "Basic Realm="+getRealmName());
		logger.error("massage"+authException.getMessage());
		response.setStatus(response.SC_UNAUTHORIZED);
		response.sendError(response.SC_UNAUTHORIZED, "Unauthorized Request");
	}
	@Override
	public void afterPropertiesSet() {
		setRealmName("SptingBootTutorial");
		super.afterPropertiesSet();
	}

}
