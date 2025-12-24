package com.suhani.bookinventory.service;

import com.suhani.bookinventory.model.Book;
import com.suhani.bookinventory.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository repository;
    @InjectMocks
    private BookService service;
    @Test
    void addBookShouldSaveBookWhenValidInput(){
        Book inputBook = new Book(null, 123L, "Harry Potter", "J.K.Rowling", "Bloomsbury");
        Book savedBook = new Book(1, 123L, "Harry Potter", "J.K.Rowling", "Bloomsbury");
        when(repository.save(inputBook)).thenReturn(savedBook);
        Book result=service.addBook(inputBook);
        assertNotNull(result.getId());
        assertEquals("Harry Potter", result.getTitle());
        verify(repository,Mockito.times(1)).save(inputBook);
    }
    @Test
    void addBookShouldThrowExceptionWhenTitleIsEmpty() {
        Book book = new Book(null, 123L, "", "J.K.Rowling", "Bloomsbury");
        assertThrows(IllegalArgumentException.class,
                () -> service.addBook(book));
        verify(repository, never()).save(any());
    }
    @Test
    void addBookShouldThrowExceptionWhenAuthorIsEmpty() {
        Book book = new Book(null, 123L, "Harry Potter", "", "Bloomsbury");
        assertThrows(IllegalArgumentException.class,
                () -> service.addBook(book));
        verify(repository, never()).save(any());
    }
    @Test
    void getBookByIdShouldReturnBookWhenExists() {
        Book book = new Book(1, 123L, "Harry Potter", "J.K.Rowling", "Bloomsbury");
        when(repository.findById(1)).thenReturn(Optional.of(book));
        Optional<Book> result = service.getBookById(1);
        assertTrue(result.isPresent());
        assertEquals("Harry Potter", result.get().getTitle());
    }


}
