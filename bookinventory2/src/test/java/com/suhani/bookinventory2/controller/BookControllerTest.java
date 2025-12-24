package com.suhani.bookinventory2.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suhani.bookinventory2.model.Book;
import com.suhani.bookinventory2.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private BookService service;

    @Test
    void getBookByIdShouldReturnBookWhenBookExists() throws Exception {

        Book book = new Book(1, 123L, "Harry Potter", "J.K. Rowling", "Bloomsbury");

        when(service.getBookById(1)).thenReturn(Optional.of(book));

        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Harry Potter"))
                .andExpect(jsonPath("$.author").value("J.K. Rowling"));

        verify(service, times(1)).getBookById(1);
    }
    @Test
    void getBookByIdShouldReturn404WhenBookDoesNotExist() throws Exception
    {
        when(service.getBookById(99)).thenReturn(Optional.empty());
        mockMvc.perform(get("/books/99"))
                .andExpect(status().isNotFound());
        verify(service, times(1)).getBookById(99);
    }
    @Test
    void getBookByIdShouldReturn404WhenBookIsNull() throws Exception{
        List<Book> books = List.of(
                new Book(1, 111L, "Book One", "Author One", "Pub One"),
                new Book(2, 222L, "Book Two", "Author Two", "Pub Two")
        );
        when(service.getAllBooks()).thenReturn(books);
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].title").value("Book One"))
                .andExpect(jsonPath("$[1].title").value("Book Two"));
        verify(service, times(1)).getAllBooks();
    }

    @Test
    void addBookShouldReturnCreatedBook() throws Exception {

        Book inputBook = new Book(null, 123L, "Harry Potter", "J.K.Rowling", "Bloomsbury");
        Book savedBook = new Book(1, 123L, "Harry Potter", "J.K.Rowling", "Bloomsbury");

        when(service.addBook(any(Book.class))).thenReturn(savedBook);

        mockMvc.perform(post("/books")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(inputBook))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Harry Potter"))
                .andExpect(jsonPath("$.author").value("J.K.Rowling"));

        verify(service, times(1)).addBook(any(Book.class));
    }


}

