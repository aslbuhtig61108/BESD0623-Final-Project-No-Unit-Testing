package com.promineotech.finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;
import com.promineotech.finalproject.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultBookController implements BookController {

	@Autowired
	private BookService bookService;
	
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.debug("Controller: ISBN={} or Genre={}", isbn, genre);
		return bookService.retrieveABook(isbn, genre);
	}

}
