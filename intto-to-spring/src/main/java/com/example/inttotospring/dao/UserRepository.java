package com.example.inttotospring.dao;

import com.example.inttotospring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
