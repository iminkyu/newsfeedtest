package com.pokemon.newsfeed.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userSeq;
    @Column(nullable = false, unique = true, length = 50)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String name;

    public User(String userId, String password, String email, String name) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public void updateUser(String userId, String password, String email, String name){}

}
