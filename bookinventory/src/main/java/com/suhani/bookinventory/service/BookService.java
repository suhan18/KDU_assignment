package com.suhani.bookinventory.service;

import com.suhani.bookinventory.model.Book;
import com.suhani.bookinventory.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class BookService {
    private final BookRepository repository;
    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }
    public Book addBook(Book book) {
        if(book.getTitle()==null||book.getTitle().isBlank()){
            throw new IllegalArgumentException("Title is required");
        }
        if(book.getAuthor()==null||book.getAuthor().isBlank()) {
            throw new IllegalArgumentException("Author is required");
        }
        //if valid then we save the book to the repository
        return repository.save(book);
    }
    public Optional<Book> getBookById(Integer id) {
        return repository.findById(id);
    }
    public List<Book> getAllBooks()
    {
        return repository.findAll();
    }

}
