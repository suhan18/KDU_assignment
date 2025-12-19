package com.suhani.bookinventory2.repository;

/*import com.suhani.bookinventory.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    private final Map<Integer, Book> bookStore=new HashMap<>();
    private Integer idCounter=1;
    public Book save(Book book) {
        book.setId(idCounter++);
        bookStore.put(book.getId(), book);
        return book;
    }
    //Optional<Book> coz there may or may not be a book
    public Optional<Book> findById(Integer id) {
        return Optional.ofNullable(bookStore.get(id));
    }
    //new ArrayList<> so callers don’t modify internal map.
    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }
}*/

import com.suhani.bookinventory2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

