package com.suhani.bookinventory2.service;

import com.suhani.bookinventory2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book addBook(Book book);

    Optional<Book> getBookById(Integer id);

    List<Book> getAllBooks();
}
