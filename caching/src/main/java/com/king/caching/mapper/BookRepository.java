package com.king.caching.mapper;

import com.king.caching.domain.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}
