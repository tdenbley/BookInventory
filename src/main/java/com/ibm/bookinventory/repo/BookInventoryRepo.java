package com.ibm.bookinventory.repo;

import com.ibm.bookinventory.model.BookData;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInventoryRepo extends MongoRepository<BookData, Long> {
	
	public BookData findByIsbn(String isbn);
}
