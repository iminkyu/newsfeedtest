package com.pokemon.newsfeed.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User extends Timestamped {
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
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING) // 이넘 타입을 데이터베이스에 저장할 때 사용
    private UserRoleEnum role;

    public User(String userId, String password, String email, String name, UserRoleEnum role) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.role = role;
    }
}
