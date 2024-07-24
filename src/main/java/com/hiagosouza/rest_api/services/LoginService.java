package com.hiagosouza.rest_api.services;

import com.hiagosouza.rest_api.config.JWTSecurityConfig;
import com.hiagosouza.rest_api.dto.Login;
import com.hiagosouza.rest_api.dto.Session;
import com.hiagosouza.rest_api.model.User;
import com.hiagosouza.rest_api.repository.UserRepository;
import com.hiagosouza.rest_api.security.JWTCreator;
import com.hiagosouza.rest_api.security.JWTObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

@RestController
public class LoginService {
  @Autowired
  private PasswordEncoder encoder;
  @Autowired
  private JWTSecurityConfig securityConfig;
  @Autowired
  private UserRepository repository;

  private final Logger logger = LoggerFactory.getLogger(LoginService.class);

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public Session userLogin(@RequestBody Login login) {
    logger.info("Login attempt for user: {} ", login.getUsername());
    User user = repository.findByUsername(login.getUsername());
    if (user != null) {
      boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
      if (!passwordOk) {
        throw new RuntimeException("Senha inválida para o login: " +
            login.getUsername());
      }

      Session session = new Session();
      session.setLogin(user.getUsername());

      JWTObject jwtObject = new JWTObject();
      jwtObject.setIssuedAt(Date.from(Instant.now()));
      jwtObject.setExpiration(Date.from(Instant.now().plusMillis(JWTSecurityConfig.EXPIRATION)));
      jwtObject.setRoles(user.getRoles());
      session.setToken(JWTCreator.create(JWTSecurityConfig.PREFIX,
          JWTSecurityConfig.KEY, jwtObject));

      return session;
    } else {
      throw new RuntimeException("Erro ao tentar fazer login");
    }
  }
}
