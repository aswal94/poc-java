package com.zoomla.poc.controllers;

import com.zoomla.poc.models.User;
import com.zoomla.poc.respositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> index() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User store(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User show(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/users/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        userRepository.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/search")
    public List<User> findByName(@RequestParam String fullName) {
        return userRepository.findByFullName(fullName);
    }
}
