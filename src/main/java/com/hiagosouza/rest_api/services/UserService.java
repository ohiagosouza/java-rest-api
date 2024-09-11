package com.hiagosouza.rest_api.services;

import com.hiagosouza.rest_api.model.User;
import com.hiagosouza.rest_api.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;
  @Autowired
  private PasswordEncoder encoder;

  private final Logger logger = LoggerFactory.getLogger(LoginService.class);


  public void createUser(User user) {
    String pass = user.getPassword();
    user.setPassword(encoder.encode(pass));
    user.setCreatedAt(LocalDateTime.now());
    user.setUpdatedAt(LocalDateTime.now());
    repository.save(user);
  }

  public void updateUser(User user) {
    String pass = user.getPassword();
    logger.info("Update user: {}", user);

    user.setName(user.getName());
    user.setRoles(user.getRoles());
    user.setUsername(user.getUsername());
    user.setPassword(encoder.encode(pass));
    user.setCreatedAt(user.getCreatedAt());
    user.setUpdatedAt(LocalDateTime.now());
    repository.save(user);

  }
}
