package com.example.vismalibrary.repository;

import com.example.vismalibrary.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <Users, Long> {

}
