//package com.hiagosouza.rest_api.init;
//
//import com.hiagosouza.rest_api.model.User;
//import com.hiagosouza.rest_api.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@Component
//public class StartApplication implements CommandLineRunner {
//  @Autowired
//  private UserRepository repository;
//
//  @Autowired
//  public PasswordEncoder encoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//  @Override
//  @Transactional
//  public void run(String... args) throws Exception {
//    User user = repository.findByUsername("admin");
//    if (user == null) {
//      user = new User();
//      user.setName("ADMIN");
//      user.setUsername("admin");
//      user.setPassword(encoder().encode("admin"));
//      user.setRole("MANAGER");
//      repository.save(user);
//    }
//  }
//}