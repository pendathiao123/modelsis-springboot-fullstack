package com.example.modelsisspringbootfullstack.repositories;

import com.example.modelsisspringbootfullstack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
