package com.structsmart.addressbook.user;

public interface UserService {
	void save(User user);
	User findByUsername(String username);
}
