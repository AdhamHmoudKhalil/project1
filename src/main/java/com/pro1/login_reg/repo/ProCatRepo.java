package com.pro1.login_reg.repo;

import com.pro1.login_reg.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProCatRepo extends JpaRepository<ProductCategory, Integer> {

}