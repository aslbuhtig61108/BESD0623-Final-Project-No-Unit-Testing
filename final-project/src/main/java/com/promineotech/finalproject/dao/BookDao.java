package com.promineotech.finalproject.dao;

import java.util.List;
import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;

public interface BookDao {

	List<Book> retrieveABook(String isbn, Genre genre);

}
