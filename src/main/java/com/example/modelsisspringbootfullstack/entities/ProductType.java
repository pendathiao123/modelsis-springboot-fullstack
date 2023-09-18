package com.example.modelsisspringbootfullstack.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class ProductType implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    @OneToMany
    @JoinColumn(name = "products")
    private List<Product> productList;

}

