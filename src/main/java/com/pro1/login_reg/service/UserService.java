package com.pro1.login_reg.service;

import com.pro1.login_reg.model.User;
import com.pro1.login_reg.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> getAllProducts(){
        return repo.findAll();
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public void delete(String username) {
        // Changed from int id to String username
        repo.deleteById(username);
    }

    public User updateUser(String username, User user) {
        // Find by username instead of ID
        User existingUser = repo.findById(username)
                .orElseThrow(() -> new RuntimeException("Kein User gefunden"));

        // Update user details
        existingUser.setPasswort(user.getPasswort());
        existingUser.setNachName(user.getNachName());
        existingUser.setAdresse(user.getAdresse());
        existingUser.setHausNr(user.getHausNr());
        existingUser.setPostleitzahl(user.getPostleitzahl());

        return repo.save(existingUser);
    }
}