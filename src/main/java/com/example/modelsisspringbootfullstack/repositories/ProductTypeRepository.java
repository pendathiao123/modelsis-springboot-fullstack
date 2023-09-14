package com.example.modelsisspringbootfullstack.repositories;

import com.example.modelsisspringbootfullstack.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

}

