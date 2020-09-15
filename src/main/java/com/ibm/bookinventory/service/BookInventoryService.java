package com.ibm.bookinventory.service;

import java.util.Collection;
import com.ibm.bookinventory.model.BookData;

public interface BookInventoryService {
	public Collection<BookData> getBooks();

	public BookData getBook(String isbn);
	
}

