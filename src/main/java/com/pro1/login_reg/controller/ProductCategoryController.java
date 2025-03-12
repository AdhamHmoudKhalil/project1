package com.pro1.login_reg.controller;

import com.pro1.login_reg.model.ProductCategory;

import com.pro1.login_reg.service.ProCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductCategoryController {
    @Autowired
    private ProCatService service;
@GetMapping("ProCat")
public String loadhtml(){
    return "ProCat";
}
    @GetMapping("/allProCat")
    public ResponseEntity<List<ProductCategory>> getAllProCats() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);

    }
    @PostMapping("/ProCat")
    public ResponseEntity<ProductCategory> createProduct(@RequestBody ProductCategory procat) {
        ProductCategory newProCat = service.createProCat(procat);
        return new ResponseEntity<>(newProCat, HttpStatus.CREATED);
    }

    @DeleteMapping("/ProCat/{id}")
    public ResponseEntity<Void> deleteProCat(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/ProCat/{id}")
    public ResponseEntity<ProductCategory> updateProduct(@PathVariable int id,
                                                 @RequestBody ProductCategory ProCat) {

        ProductCategory updatedProCat = service.updateProCat(id, ProCat);
        return new ResponseEntity<>(updatedProCat, HttpStatus.OK);
    }
}


