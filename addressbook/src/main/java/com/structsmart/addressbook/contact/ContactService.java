package com.structsmart.addressbook.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ContactService {
	
	private static int contactCount = 0;
	
	private static List<Contact> contacts = new ArrayList<>();
	
	static {
		contacts.add(new Contact ("Marius", ++contactCount, "Marius1", "Pop", "Cluj_Napoca", "https://robohash.org/MariusPop"));
		contacts.add(new Contact ("Marius", ++contactCount, "Florina", "Alb", "Cluj_Napoca", "https://robohash.org/FlorinaAlb"));
		contacts.add(new Contact ("Florina", ++contactCount, "Florina", "Alb", "Cluj_Napoca", "https://robohash.org/FlorinaAlb"));
	}
	
	public List<Contact> findByUsername(String username){
		Predicate<? super Contact> predicate = contact -> contact.getUserName().equalsIgnoreCase(username);
		return contacts.stream().filter(predicate).toList();
	}
	
	public void addContact(String userName, String firstName, String lastName, String address, String picture) {
		Contact contact = new Contact (userName, ++contactCount, firstName, lastName, address, picture);
		contacts.add(contact);
	}
//WHere is the below contact object coming from?
	public void deleteById(int id) {
		Predicate<? super Contact> predicate = contact -> contact.getId() == id;
		contacts.removeIf(predicate);
	}

	public Contact findById(int id) {
		Predicate<? super Contact> predicate = contact -> contact.getId() == id;
		Contact contact = contacts.stream().filter(predicate).findFirst().get();
		return contact;
	}

	public void updateContact(String userName, int id, String firstName, String lastName, String address, String picture) {
		Predicate<? super Contact> predicate = contact -> contact.getId() == id;
		contacts.removeIf(predicate);
		
		Contact contact = new Contact (userName, ++contactCount, firstName, lastName, address, picture);
		contacts.add(contact);	
}
	
//Shortcut method to update values by deleting contact and creating a new one with correct values
//	public void updateContact(@Valid Contact contact) {
//		deleteById(contact.getId());
//		contacts.add(contact);	
//	}
}

//contactService.updateContact(username, contact.getFirstName(), contact.getLastName(), contact.getAddress(), picture);