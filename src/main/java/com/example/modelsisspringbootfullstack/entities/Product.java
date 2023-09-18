package com.example.modelsisspringbootfullstack.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Product implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType type;

    private Date createdDate;
}
