package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.entities.ProductType;
import com.example.modelsisspringbootfullstack.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public ProductType addProductType(String name) {
        ProductType productType = new ProductType();
        productType.setName(name);
        return productTypeRepository.save(productType);
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    public Optional<ProductType> getProductTypeById(int id) {
        return productTypeRepository.findById(id);
    }

    public ProductType createProductType(String name) {
        ProductType productType = new ProductType();
        productType.setName(name);
        return productTypeRepository.save(productType);
    }

    public void deleteProductType(int id) {
        productTypeRepository.deleteById(id);
    }
}
