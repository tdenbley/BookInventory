package com.ibm.bookinventory.service;

import java.util.Collection;

import com.ibm.bookinventory.repo.BookInventoryRepo;

import com.ibm.bookinventory.model.BookData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookInventoryServiceImpl implements BookInventoryService {
	
	@Autowired
	private BookInventoryRepo bookInventoryRepo;

	public BookInventoryServiceImpl() {
	}

	@Override
	public Collection<BookData> getBooks() {
		
		Collection<BookData> books = this.bookInventoryRepo.getBooks();
		
		// No business logic anymore
		
		return books;
	}
}