package com.ibm.bookinventory.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bookinventory.service.BookInventoryService;

import java.util.Collection;

import com.ibm.bookinventory.model.BookData;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/bookinventory")
public class BookInventoryController
{
	@Autowired
	private BookInventoryService bookInventoryService;
	
	public BookInventoryController() {
	}

    @RequestMapping(value = "/books")
	public ResponseEntity<?> getBooks() {
    	Collection<BookData> books = this.bookInventoryService.getBooks();
    	ResponseEntity<Collection<BookData>> responseEntity = new ResponseEntity<Collection<BookData>>(books, HttpStatus.OK); 
		return responseEntity;
	}
}
