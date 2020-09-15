package com.ibm.bookinventory.repo;

import java.util.Collection;

import com.ibm.bookinventory.model.BookData;

public interface BookInventoryRepo {
	
	public Collection<BookData> getBooks();
	
}
