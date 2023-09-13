package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.entities.Product;
import com.example.modelsisspringbootfullstack.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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

    public Product create(String name, String type){
        Product product = new Product();
        product.setName(name);
        product.setType(type);

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
}
