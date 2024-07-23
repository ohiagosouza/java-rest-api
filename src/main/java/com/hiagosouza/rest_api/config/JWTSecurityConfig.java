package com.hiagosouza.rest_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class JWTSecurityConfig {
  public static String PREFIX;
  public static String KEY;
  public static Long EXPIRATION;

  // Getters
  public static String getPREFIX() {
    return PREFIX;
  }

  public static String getKEY() {
    return KEY;
  }

  public static Long getEXPIRATION() {
    return EXPIRATION;
  }

  // Setters
  public void setPrefix(String prefix){
    PREFIX = prefix;
  }
  public void setKey(String key){
    KEY = key;
  }
  public void setExpiration(Long expiration){
    EXPIRATION = expiration;
  }

}
