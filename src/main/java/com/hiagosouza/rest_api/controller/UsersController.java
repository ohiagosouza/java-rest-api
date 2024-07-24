package com.hiagosouza.rest_api.controller;

import com.hiagosouza.rest_api.model.User;
import com.hiagosouza.rest_api.repository.UserRepository;
import com.hiagosouza.rest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsersController {
  @Autowired
  private UserRepository repository;

  @Autowired
  private UserService userService;

  @GetMapping("/list-all")
  public ResponseEntity<Iterable<User>> getUsers() {
    return ResponseEntity.ok(repository.findAll());
  }

  @PostMapping("/create")
  public ResponseEntity<User> postUser(@RequestBody User user) {
    userService.createUser(user);
    return ResponseEntity.ok(user);
  }

  @PutMapping(value = "/{id}")
  public void updateUser(@PathVariable Long id, @RequestBody User user) {
    Optional<User> userRegistered = repository.findById(id);

    if (userRegistered.isPresent()) {
      User existingUser = userRegistered.get();
      existingUser.setName(user.getName());
      existingUser.setRoles(user.getRoles());
      existingUser.setUsername(user.getUsername());
      existingUser.setPassword(user.getPassword());
      existingUser.setUpdatedAt(user.getUpdatedAt());
      repository.save(existingUser);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/{username}")
  public User findUser(@PathVariable String username) {
    return repository.findByUsername(username);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteUser(@PathVariable Long id) {
    Optional<User> userRegistered = repository.findById(id);

    if (userRegistered.isPresent()) {
      repository.deleteById(id);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
}