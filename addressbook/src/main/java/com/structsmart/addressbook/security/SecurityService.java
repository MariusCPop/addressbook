package com.structsmart.addressbook.security;

public interface SecurityService {
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
