package com.example.modelsisspringbootfullstack.controllers;


import com.example.modelsisspringbootfullstack.entities.Product;
import com.example.modelsisspringbootfullstack.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/test_recrutement")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/Product")
    public ResponseEntity<String> add(@RequestBody Product product) {
        // Vérifier si un produit avec le même nom existe déjà dans la base de données
        if (productService.isNameExists(product.getName())) {
            return ResponseEntity.badRequest().body("Ce nom existe déjà.");
        }

        // Vérifier si un produit avec le même type existe déjà dans la base de données
        if (productService.isTypeExists(product.getType())) {
            return ResponseEntity.badRequest().body("Ce type existe déjà.");
        }

        productService.create(product.getName(), product.getType(), product.getCreatedDate());
        return ResponseEntity.ok().body("{\"message\": \"Produit ajouté\"}");
    }




    @GetMapping("/product/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") int id){
        Product product = productService.findById(id).get();
        return ResponseEntity.ok().body(product);
    }
    @GetMapping("/product/all")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> produits = productService.getAll();
        return ResponseEntity.ok().body(produits);
    }
    @DeleteMapping("/product/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam("id") int id){
        productService.delete(id);
        return ResponseEntity.ok().body("{\"message\": \"Produit supprimé\"}");
    }
    @PutMapping("/product/update")
    public ResponseEntity<Product> update(@RequestParam("id") int id, @RequestBody Product product){
        Product newProduct = productService.update(id,product);
        return ResponseEntity.ok().body(newProduct);
    }

}
