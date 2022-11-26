package com.structsmart.addressbook.contact;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Contact {
	
	
	private String userName;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2, message="Enter at least 3 characters!")
	private String firstName;

	private String lastName;
	
	private String address;
	

	private String picture = "https://robohash.org/" + firstName + lastName;
	
	public Contact() {
		
	}

	
	public Contact(String userName, int id, String firstName,
			String lastName, String address, String picture) {
		super();
		
		this.userName = userName;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.picture = picture;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}



	

}
