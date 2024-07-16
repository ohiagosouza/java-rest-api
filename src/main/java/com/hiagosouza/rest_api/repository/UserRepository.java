package com.hiagosouza.rest_api.repository;

import com.hiagosouza.rest_api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
  Users findByUsername(String username);
}
