package com.promineotech.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.finalproject.entity.Book;
import com.promineotech.finalproject.entity.Genre;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBookDao implements BookDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> retrieveABook(String isbn, Genre genre) {
		log.debug("DAO: ISBN={} or Genre={}",isbn, genre);
		
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM books "
			+ "WHERE isbn = :isbn OR genre = :genre";
		
		// @formatter:on
		Map<String, Object> params = new HashMap<>();
			params.put("isbn", isbn);
			params.put("genre", genre.toString());
		
		// Use a rowmapper to generate a list
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Book.builder()
					.booknumber_pk(rs.getInt("booknumber_pk"))
					.title(rs.getString("title"))
					.isbn(rs.getString("isbn"))
					.genre(Genre.valueOf(rs.getString("genre")))
					.book_authors(rs.getString("book_authors"))
					.notes(rs.getString("notes"))
					.build();
				// @formatter:on
			}});
	}

}
