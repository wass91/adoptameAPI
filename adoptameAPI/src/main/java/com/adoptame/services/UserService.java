package com.adoptame.services;

import com.adoptame.services.entities.User;

public interface UserService {
	public User create(String name, String email, String password) throws Exception;
	
	public User login(String email, String password)  throws Exception;
}
