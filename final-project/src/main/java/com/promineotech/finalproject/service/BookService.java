package com.promineotech.finalproject.service;

import java.util.List;

import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;

public interface BookService {

	List<Book> retrieveABook(String isbn, Genre genre);

}
