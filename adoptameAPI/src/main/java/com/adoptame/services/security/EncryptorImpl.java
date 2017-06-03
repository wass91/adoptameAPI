package com.adoptame.services.security;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptorImpl implements Encryptor{
	public String encrypt(String value) {
    	String passEncoded = "";
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		passEncoded = encoder.encode(value);
		return passEncoded;        
    }
    public String encryptSHA1(String value) {
    	String passEncoded = "";
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(1);
		encoder.setEncodeHashAsBase64(true);
		passEncoded = encoder.encodePassword(value,null);
		return passEncoded;        
    }
    
    public boolean matchesPassword(String rawPassword, String encodedPassword) {
    	StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		boolean matches = encoder.matches(rawPassword, encodedPassword);
		return matches;        
    }
}
