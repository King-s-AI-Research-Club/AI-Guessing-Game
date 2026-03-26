package com.aiguess.backend.model;
import jakarta.persistence.*;
import lombok.Data;

//This is user table, every field here becomes a column in the database

@Data
@Entity
@Table(name = "users")
public class User {

    //creating primary key for users table
    //also auto increments as users are added
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //column named username, which should be unique | is needed(can't be null)
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

}
