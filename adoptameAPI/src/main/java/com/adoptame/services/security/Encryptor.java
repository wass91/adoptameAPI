package com.adoptame.services.security;

public interface Encryptor {
	public String encrypt(String value);
    public String encryptSHA1(String value);
    public boolean matchesPassword(String rawPassword, String encodedPassword);
}
