package com.promineotech.finalproject.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.finalproject.dao.BookDao;
import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBookService implements BookService {

	@Autowired
	private BookDao bookDao;

	@Transactional (readOnly = true)
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.info("The retrieveABook method was"
			+ " called with an ISBN={} or Genre={}",isbn, genre);
		List<Book> books = bookDao.retrieveABook(isbn, genre);
		
		if (books.isEmpty()) {
			String errorMessage = String.format("No books were found with"
				+ " the provided isbn=%s and/or genre=%s", isbn, genre);
			throw new NoSuchElementException(errorMessage);
			
		}
		Collections.sort(books);
		return books;
	}

}
