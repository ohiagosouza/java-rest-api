package com.hiagosouza.rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/")
  public String welcomeMessage() {
    return "<h1>Hello, World!<h1>";
  }
}
