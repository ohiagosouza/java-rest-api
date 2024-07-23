package com.hiagosouza.rest_api.security;

import java.util.Date;
import java.util.List;

public class JWTObject {
  private String subject;
  private Date issuedAt;
  private Date expiration;
  private List<String> roles;

  // Getters
  public String getSubject() {
    return subject;
  }

  public Date getIssuedAt() {
    return issuedAt;
  }

  public Date getExpiration() {
    return expiration;
  }

  public List<String> getRoles() {
    return roles;
  }

  // Setters
  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setIssuedAt(Date issuedAt) {
    this.issuedAt = issuedAt;
  }

  public void setExpiration(Date expiration) {
    this.expiration = expiration;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }
}
