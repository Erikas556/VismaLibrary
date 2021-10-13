package com.example.vismalibrary.service;

import com.example.vismalibrary.model.Book;
import com.example.vismalibrary.model.Users;
import com.example.vismalibrary.repository.BookRepo;
import com.example.vismalibrary.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public UserService(UserRepo userRepo, BookRepo bookRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    public Users addReservation(Users user) {

        Book reservedBook = bookRepo.findBookByName(user.getBookName());
        reservedBook.setIsTaken(true);
        bookRepo.save(reservedBook);
        return userRepo.save(user);
    }
}
