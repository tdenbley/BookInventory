package com.ibm.bookinventory.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.bookinventory.service.BookInventoryService;

import java.util.Collection;

import com.ibm.bookinventory.model.BookData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/bookinventory")
public class BookInventoryController {
	private final Logger logger = LoggerFactory.getLogger(BookInventoryController.class);

	@Autowired
	private BookInventoryService bookInventoryService;

	public BookInventoryController() {
	}

	@RequestMapping(value = "/books")
	public ResponseEntity<?> getBooks() {
		Collection<BookData> books = this.bookInventoryService.getBooks();
		ResponseEntity<Collection<BookData>> responseEntity = new ResponseEntity<Collection<BookData>>(books,
				HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/book/{isbn}")
	public ResponseEntity<?> getBook(@PathVariable(value = "isbn") String isbn) {
		logger.info("Entered BookInventoryController.getBook(). isbn=" + isbn);
		BookData book = this.bookInventoryService.getBook(isbn);
		ResponseEntity<BookData> responseEntity = new ResponseEntity<BookData>(book, HttpStatus.OK);
		logger.info("Entered BookInventoryController.getBook(). isbn=" + isbn);
		return responseEntity;
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	ResponseEntity<?> addBook(@RequestBody BookData bookData) {
		logger.info("Entered addBook().  bookData = " + bookData);

		bookData.setAuthor(bookData.getAuthor() + " MODIFIED");

		ResponseEntity<BookData> responseEntity = new ResponseEntity<BookData>(bookData, HttpStatus.OK);

		logger.info("Leaving addBook().  bookData = " + bookData);
		return responseEntity;
	}
}
