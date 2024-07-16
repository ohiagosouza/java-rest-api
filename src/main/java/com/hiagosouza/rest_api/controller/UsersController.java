package com.hiagosouza.rest_api.controller;

import com.hiagosouza.rest_api.model.Users;
import com.hiagosouza.rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UsersController {
  @Autowired
  private UserRepository repository;

  @GetMapping
  public List<Users> getUsers() {
    return repository.findAll();
  }

  @PostMapping
  public void saveUser(@RequestBody Users user) {
    repository.save(user);
  }

  @PutMapping("/{id}")
  public void updateUser(@PathVariable Integer id, @RequestBody Users user) {
    Optional<Users> userRegistered = repository.findById(id);

    if (userRegistered.isPresent()) {
      Users existingUser = userRegistered.get();
      existingUser.setUsername(user.getUsername());
      existingUser.setPassword(user.getPassword());
      repository.save(existingUser);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/{username}")
  public Users findUser(@PathVariable String username) {
    return repository.findByUsername(username);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Integer id) {
    Optional<Users> userRegistered = repository.findById(id);

    if (userRegistered.isPresent()) {
      repository.deleteById(id);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
}