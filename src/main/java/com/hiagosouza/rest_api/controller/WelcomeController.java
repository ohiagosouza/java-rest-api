package com.hiagosouza.rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
  @GetMapping("/")
  public String welcomeMessage() {
    return "<h1>Homepage!<h1>";
  }

  @GetMapping("/user")
  public String privateUser() {
    return "<h1>Private user<h1>";
  }

  @GetMapping("/manager")
  public String privateAdmin() {
    return "<h1>Private Admin<h1>";
  }
}
