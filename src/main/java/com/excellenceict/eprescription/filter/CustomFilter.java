package com.excellenceict.eprescription.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.excellenceict.eprescription.model.UserInfo;
import com.excellenceict.eprescription.service.CustomUserDetailsService;
import com.excellenceict.eprescription.service.UserInfoServiceImpl;
import com.excellenceict.eprescription.service.interF.UserServiceInteF;

@Configuration
public class CustomFilter extends OncePerRequestFilter{
	
	@Autowired
	UserServiceInteF userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	CustomUserDetailsService userDetailsService;
 
	private UserInfo getUserInfo(HttpServletRequest request) {
			String authString = null;
		Enumeration<String> headersNameEnumeration = 	request.getHeaderNames();
		while(headersNameEnumeration.hasMoreElements()) {
			String headerKey = headersNameEnumeration.nextElement();
			if(headerKey.equalsIgnoreCase("Authorization")) {
				authString = request.getHeader(headerKey);
				break;
			}
		}
		
		if(authString !=null && !authString.equals("")) {
			String[] authParts = authString.split("\\s+");  
			String authinfo = authParts[1];
			byte[] bytes = DatatypeConverter.parseBase64Binary(authinfo);
			String decodeAuth = new String(bytes);
			String userNameAndPassword[] = decodeAuth.split(":");
			
			if(userNameAndPassword[0]!=null && userNameAndPassword[1]!=null) {
				UserInfo user = userService.getByUserName(userNameAndPassword[0]);
				if(passwordEncoder.matches(userNameAndPassword[1], user.getPasssword())) {
					return user;
				}
				return null;
			}
			
		}
		return null;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			UserInfo user = getUserInfo(request);
			UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
			UsernamePasswordAuthenticationToken authenticationToken  = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		filterChain.doFilter(request, response);
	}

}
