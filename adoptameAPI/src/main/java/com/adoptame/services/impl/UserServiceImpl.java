package com.adoptame.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adoptame.services.UserService;
import com.adoptame.services.entities.User;
import com.adoptame.services.repositories.UserRepository;
import com.adoptame.services.security.Encryptor;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Encryptor encryptor;
	
	public Encryptor getEncryptor() {
		return encryptor;
	}

	public void setEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public User create(String name, String email, String password) throws Exception {
		User user = null;
		try {
			user = new User();
			user.setNames(name);
			user.setEmail(email);
			user.setPassword(encryptor.encrypt(password));
			user = userRepository.saveAndFlush(user);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return user;
	}

	@Override
	public User login(String email, String password) throws Exception {
		User user = userRepository.findByEmail(email);
		if(encryptor.matchesPassword(password, user.getPassword())){
			setContextAuthentication(""+user.getId(), user.getPassword());
		}else{
			return null;
		}
		return user;
	}
	
	private void setContextAuthentication(String userName, String password) {
		Authentication auth = new UsernamePasswordAuthenticationToken(userName,password);
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	private  void clearContextAuthentication() {
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
		SecurityContextHolder.getContext().setAuthentication(null);
		SecurityContextHolder.clearContext();
	}

}
