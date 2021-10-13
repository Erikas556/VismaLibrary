package com.example.vismalibrary.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String category;
    private String language;
    private String publicationDate;
    private Long isbn;
    private String guid;
    private Boolean isTaken;
}
