package com.suhani.bookinventory2.service;

import com.suhani.bookinventory2.model.Book;
import com.suhani.bookinventory2.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            throw new IllegalArgumentException("Author is required");
        }
        return repository.save(book);
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }
}
