package com.aiguess.backend.repository;

import com.aiguess.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//This interface is a way to talk to database!
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);     //letting search user by their username
    Optional<User> findByEmail(String email);           //letting search user by their email
}