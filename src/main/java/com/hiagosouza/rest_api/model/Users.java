package com.hiagosouza.rest_api.model;

import jakarta.persistence.*;

@Entity
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(length = 15, nullable = false, unique = true)
  private String username;
  @Column(length = 120, nullable = false)
  private String password;

  @Override
  public String toString() {
    return "Users id: " + id + ", Username: " + username + ", Password: " + password;
  }

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
