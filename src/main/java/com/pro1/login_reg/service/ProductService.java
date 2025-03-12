package com.pro1.login_reg.service;

import com.pro1.login_reg.model.Product;
import com.pro1.login_reg.model.ProductCategory;
import com.pro1.login_reg.repo.ProCatRepo;
import com.pro1.login_reg.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repi;

    @Autowired
    private ProCatRepo proCatRepo; // Repository für ProductCategory

    public List<Product> getAllProducts() {
        return repi.findAll();
    }
    public Product createProduct(Product product) {
        if (product.getCategory() != null && product.getCategory().getID() != 0) {
            ProductCategory category = proCatRepo.findById(product.getCategory().getID())
                    .orElseThrow(() -> new RuntimeException("Kategorie nicht gefunden"));
            product.setCategory(category); // Setze die verwaltete Kategorie
        } else {
            throw new RuntimeException("Produkt muss eine gültige Kategorie haben");
        }

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
