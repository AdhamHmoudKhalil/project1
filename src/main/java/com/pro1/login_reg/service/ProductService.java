package com.pro1.login_reg.service;

import com.pro1.login_reg.model.Product;

import com.pro1.login_reg.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repi;

    public List<Product> getAllProducts() {
        return repi.findAll();
    }
    public Product createProduct(Product product) {
        return repi.save(product);
    }

    public void delete(int id) {
        repi.deleteById(id);
    }

    public Product updateProduct(int id, Product product) {
        Product exsistingProduct = repi.findById(id)
                .orElseThrow(() -> new RuntimeException("Kein Product gefunden"));

        exsistingProduct.setName(product.getName());
        exsistingProduct.setQuantity(product.getQuantity());
        exsistingProduct.setPrice(product.getPrice());

        return repi.save(exsistingProduct);
    }
}
