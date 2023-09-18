package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.entities.Product;
import com.example.modelsisspringbootfullstack.entities.ProductType;
import com.example.modelsisspringbootfullstack.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(int id){return productRepository.findById(id);}

    public List<Product> getAll(){return productRepository.findAll();}

    public Product create(String name, ProductType type, Date createdDate){
        Product product = new Product();
        product.setName(name);
        product.setType(type);
        product.setCreatedDate(createdDate);

        return productRepository.save(product);
    }

    public Product update(int id, Product product){
        Product newProduct = findById(id).get();
        newProduct.setName(product.getName());
        newProduct.setType(product.getType());

        return productRepository.save(newProduct);
    }

    public  void delete(int id){
        productRepository.deleteById(id);
    }

    public boolean isNameExists(String name) {
        // Vérifiez si un produit avec le même nom existe déjà dans la base de données
        return productRepository.existsByName(name);
    }

    public boolean isTypeExists(ProductType type) {
        // Vérifiez si un produit avec le même type existe déjà dans la base de données
        return productRepository.existsByType(type);
    }
}
