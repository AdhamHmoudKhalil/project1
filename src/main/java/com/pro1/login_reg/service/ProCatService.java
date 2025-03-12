package com.pro1.login_reg.service;

import com.pro1.login_reg.model.ProductCategory;
import com.pro1.login_reg.repo.ProCatRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProCatService {
    private final ProCatRepo repu;

    public ProCatService(ProCatRepo repu) {
        this.repu = repu;
    }

    public List<ProductCategory> getAllProducts() {
        return repu.findAll();
    }

    public ProductCategory createProCat(ProductCategory procat) {
        return repu.save(procat);
    }

    public void delete(int id) {
        repu.deleteById(id);
    }

    public ProductCategory updateProCat(int id, ProductCategory proCat) {
        ProductCategory existingProCat = repu.findById(id)
                .orElseThrow(() -> new RuntimeException("Keine ProductCategory gefunden"));

        existingProCat.setName(proCat.getName());
        existingProCat.setBeschreibung(proCat.getBeschreibung());

        return repu.save(existingProCat);
    }
}