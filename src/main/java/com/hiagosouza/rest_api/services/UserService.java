package com.hiagosouza.rest_api.services;

import com.hiagosouza.rest_api.model.User;
import com.hiagosouza.rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;
  @Autowired
  private PasswordEncoder encoder;

  public void createUser(User user) {
    String pass = user.getPassword();
    user.setPassword(encoder.encode(pass));
    repository.save(user);
  }
}
