package com.example.modelsisspringbootfullstack.repositories;

import com.example.modelsisspringbootfullstack.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
