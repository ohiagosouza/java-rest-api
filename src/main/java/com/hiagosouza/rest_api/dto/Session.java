package com.hiagosouza.rest_api.dto;

public class Session {
  private String login;
  private String token;

  // Getters
  public String getLogin() {
    return login;
  }

  public String getToken() {
    return token;
  }

  // Setters
  public void setLogin(String login) {
    this.login = login;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
