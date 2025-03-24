package com.pro1.login_reg.controller;

import com.pro1.login_reg.model.ProductCategory;
import com.pro1.login_reg.service.ProCatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product Category", description = "API für Produktkategorien")
@RestController
@RequestMapping("/Product-category")
public class ProductCategoryController {

    @Autowired
    private ProCatService service;

    @Operation(summary = "Gibt alle Produktkategorien zurück")
    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProCats() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @Operation(summary = "Erstellt eine neue Produktkategorie")
    @PostMapping
    public ResponseEntity<ProductCategory> createProduct(@RequestBody ProductCategory procat) {
        ProductCategory newProCat = service.createProCat(procat);
        return new ResponseEntity<>(newProCat, HttpStatus.CREATED);
    }

    @Operation(summary = "Löscht eine Produktkategorie anhand der ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProCat(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Aktualisiert eine bestehende Produktkategorie anhand der ID")
    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateProduct(@PathVariable int id,
                                                         @RequestBody ProductCategory proCat) {
        ProductCategory updatedProCat = service.updateProCat(id, proCat);
        return new ResponseEntity<>(updatedProCat, HttpStatus.OK);
    }
}
