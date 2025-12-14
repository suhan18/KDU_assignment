package com.suhani.bookinventory.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*package com.suhani.bookinventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private Long isbn;
    private  String title;
    private String author;
    private String publisher;
}*/
@Entity//becomes a DB table
@Data
@NoArgsConstructor      // REQUIRED by JPA
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MySQL auto-increment
    private Integer id;

    private Long isbn;
    private String title;
    private String author;
    private String publisher;
}


