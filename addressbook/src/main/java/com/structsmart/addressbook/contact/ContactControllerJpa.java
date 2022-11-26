package com.structsmart.addressbook.contact;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.structsmart.addressbook.csv.CsvFileGenerator;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ContactControllerJpa {
	
	public ContactControllerJpa(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}
			
	private ContactRepository contactRepository;

	@Autowired
	private CsvFileGenerator csvGenerator;
	
	@GetMapping("/export-to-csv")
	public void exportIntoCSV(HttpServletResponse response, ModelMap model) throws IOException{
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=\"contact.csv\"");
		String userName = getLoggedInUsername(model);
		List<Contact> contacts = contactRepository.findByUserName(userName);
		
		csvGenerator.writeContactsToCsv(contacts, response.getWriter());
	}

	@RequestMapping("list-contacts")
	public String listAllContacts(ModelMap model){
		String userName = getLoggedInUsername(model);
		
		List<Contact> contacts = contactRepository.findByUserName(userName);
		model.addAttribute("contacts",contacts);
		return "listContacts";
	}
	
	@RequestMapping(value="add-contacts", method = RequestMethod.GET)
	public String showContactsPage(ModelMap model){
		Contact contact = new Contact("", 0, "", "", "","https://robohash.org/Poza");
		model.put("contact", contact);
		return "addContacts";
	}

//contact from row 40 needs to be identical to attribute from addContacts form attribute in order to be connected!!!
//@Valid needs to be used in order for the conditions from contacts.java to work
//binding result is used to take care of thrown errors when validation is being used
	@RequestMapping(value="add-contacts", method = RequestMethod.POST)
	public String addContacts(ModelMap model, @Valid Contact contact, BindingResult result){
		
		if (result.hasErrors()) {
			return "addContacts";
		}
		String username = getLoggedInUsername(model);
		contact.setUserName(username);
		contact.setPicture("https://robohash.org/" + contact.getFirstName() + contact.getLastName() + "?size=150x150");
		contactRepository.save(contact);
		return "redirect:list-contacts";
	}
	
	@RequestMapping("delete-contact")
	public String deleteContact(@RequestParam int id){
		contactRepository.deleteById(id);
		return "redirect:list-contacts";
	}
	
	@RequestMapping(value="update-contact", method = RequestMethod.GET)
	public String showUpdateContact(@RequestParam int id, ModelMap model){
		Contact contact = contactRepository.findById(id).get();
		model.addAttribute("contact",contact);
		return "addContacts";
	}
	
	@RequestMapping(value="update-contact", method = RequestMethod.POST)
	public String updateContact(ModelMap model, @Valid Contact contact, BindingResult result){
		
		if (result.hasErrors()) {
			return "addContacts";
		}
		
		String username = getLoggedInUsername(model);
		contact.setUserName(username);
		contact.setPicture("https://robohash.org/" + contact.getFirstName() + contact.getLastName()+ "?size=150x150");
		contactRepository.save(contact);
		return "redirect:list-contacts";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
