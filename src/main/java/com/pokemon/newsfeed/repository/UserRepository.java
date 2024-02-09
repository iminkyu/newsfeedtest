package com.pokemon.newsfeed.repository;

import com.pokemon.newsfeed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
