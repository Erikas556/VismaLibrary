package com.example.vismalibrary.service;

import com.example.vismalibrary.model.Book;
import com.example.vismalibrary.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBook(Book book) {
        book.setGuid(UUID.randomUUID().toString());
        book.setIsTaken(false);
        return bookRepo.save(book);
    }

    public Book getBookByGuid(String guid) {
        return bookRepo.getByGuid(guid);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    public List<Book> filterBooks(String filter, String option) {

        if (filter.equalsIgnoreCase("author")) {
            return bookRepo.findAllByAuthor(option);
        }
        else if (filter.equalsIgnoreCase("category")) {
            return bookRepo.findAllByCategory(option);
        }
        else if (filter.equalsIgnoreCase("language")) {
            return bookRepo.findAllByLanguage(option);
        }
        else if (filter.equalsIgnoreCase("ISBN")) {
            Long isbn = Long.parseLong(option);
            return bookRepo.findAllByIsbn(isbn);
        }
        else if (filter.equalsIgnoreCase("name")) {
            return bookRepo.findAllByName(option);
        }
        return bookRepo.findAll();
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    public List<Book> getAvailableOrTakenList(String availability) {

        if (availability.equalsIgnoreCase("taken")) {
            return bookRepo.findAllByIsTakenIsTrue();
        } else if (availability.equalsIgnoreCase("available")) {
            return bookRepo.findAllByIsTakenIsFalse();
        }
        return bookRepo.findAll();
    }
}
