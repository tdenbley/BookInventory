package com.ibm.bookinventory.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ibm.bookinventory.model.BookData;

@Repository
public interface BookInventoryRepo extends MongoRepository<BookData, Long> {

	public BookData findByIsbn(String isbn);
	
}
