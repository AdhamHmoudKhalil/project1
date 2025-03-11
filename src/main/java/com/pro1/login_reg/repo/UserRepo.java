package com.pro1.login_reg.repo;

import com.pro1.login_reg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    // This method is now available to check if a username exists
    boolean existsById(String username);
}