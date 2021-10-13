package com.example.vismalibrary.controller;

import com.example.vismalibrary.model.Book;
import com.example.vismalibrary.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add") // method to add book to DB
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/get{uuid}") // method to return a book by guid
    public ResponseEntity<Book> getBookByGUID(@PathVariable String uuid) {
        Book book = bookService.getBookByGuid(uuid);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/books") // method to return a list of all books
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{availability}") // method to return available or taken books
    public ResponseEntity<List<Book>> getTakenOrAvailableList(@PathVariable String availability) {
        List<Book> books = bookService.getAvailableOrTakenList(availability);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{filter}/{option}") // method that returns all books from DB by given filter
    public ResponseEntity<List<Book>> filterBooks(@PathVariable String filter, @PathVariable String option) {
        List<Book> bookList = bookService.filterBooks(filter, option);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @DeleteMapping("/delete{id}") // method to delete a book from DB
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
