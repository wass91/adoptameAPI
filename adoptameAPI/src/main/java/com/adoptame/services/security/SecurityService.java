package com.adoptame.services.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.adoptame.services.entities.User;

public abstract class SecurityService {
	
	protected Integer getUserLoginId() {
		User user = null;
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication!=null){
			user = (User) authentication.getPrincipal();
		}
		if (user!=null) { 
			return user.getId();
		} else return null;
		
	}

}
