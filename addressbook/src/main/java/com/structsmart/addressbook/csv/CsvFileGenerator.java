package com.structsmart.addressbook.csv;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import com.structsmart.addressbook.contact.Contact;

@Component
public class CsvFileGenerator {
	public void writeContactsToCsv(List<Contact> contacts, Writer writer) {
		try {
			CSVPrinter printer = new CSVPrinter (writer, CSVFormat.DEFAULT);
			for (Contact contact: contacts) {
				printer.printRecord(contact.getId(),contact.getFirstName(),contact.getLastName(),contact.getAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
