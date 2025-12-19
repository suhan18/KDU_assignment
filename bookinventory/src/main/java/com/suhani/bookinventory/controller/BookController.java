package com.suhani.bookinventory.controller;

import com.suhani.bookinventory.model.Book;
import com.suhani.bookinventory.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    public BookController(BookService bookService) {
        this.service = bookService;
    }
    // BookController.java
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        Book book = service.getBookById(id).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = service.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

}
