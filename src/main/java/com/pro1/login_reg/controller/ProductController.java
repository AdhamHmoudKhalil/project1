package com.pro1.login_reg.controller;

import com.pro1.login_reg.model.Product;
import com.pro1.login_reg.model.User;
import com.pro1.login_reg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);

    }
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = service.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProdct(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id,
                                           @RequestBody Product product) {

        Product updatedProduct = service.updateProduct(id, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}


