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


    public void delete(int id) {
        repo.deleteById(id);
    }

    public User updateUser(int id, User user) {// würde mehr sinn machen ein object zu erstellen
    User existingUser = repo.findById(id).orElseThrow(() -> new RuntimeException("kein user gefunden"));

        existingUser.setName(user.getName());
        existingUser.getAdresse(user.getAdresse());
        existingUser.setId(user.getId());
        existingUser.setHausNr(user.getHausNr());
        existingUser.setPostleitzahl(user.getPostleitzahl());
        return repo.save(existingUser);
    }
}
