package com.structsmart.addressbook.contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
	public List<Contact> findByUserName(String userName);
}
