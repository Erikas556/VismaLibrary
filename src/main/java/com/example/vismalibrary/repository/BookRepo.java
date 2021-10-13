package com.example.vismalibrary.repository;

import com.example.vismalibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    Book getByGuid(String guid);

    List<Book> findAllByAuthor(String option);

    List<Book> findAllByCategory(String option);

    List<Book> findAllByLanguage(String option);

    List<Book> findAllByIsbn(Long isbn);

    Book findBookByName(String name);

    List<Book> findAllByName(String option);

    List<Book> findAllByIsTakenIsFalse();

    List<Book> findAllByIsTakenIsTrue();
}
