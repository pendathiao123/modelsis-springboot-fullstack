package com.example.modelsisspringbootfullstack.controllers;

import com.example.modelsisspringbootfullstack.entities.ProductType;
import com.example.modelsisspringbootfullstack.services.ProductTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/test_recrutement/product-types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping("/ProductType")
    public ResponseEntity<String> addProductType(@RequestBody ProductType productType) {

        ProductType addedProductType = productTypeService.addProductType(productType.getName());
        return ResponseEntity.ok().body("Type de produit ajouté avec succès.");
    }

    @GetMapping("/all")
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }

}

