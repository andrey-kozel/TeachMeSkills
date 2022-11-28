package com.exmaple.security.repository;

import java.util.List;

import com.exmaple.security.model.AppUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private final PasswordEncoder passwordEncoder;
  private final List<AppUser> users;

  public UserRepository(final PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
    this.users = List.of(
      AppUser.builder().id(1).username("user").password(passwordEncoder.encode("password")).role("USER").build(),
      AppUser.builder().id(1).username("admin").password(passwordEncoder.encode("password")).role("ADMIN").build()
    );
  }

  public AppUser get(final Long id) {
    return users.stream()
      .filter(u -> u.getId() == id)
      .findFirst()
      .orElse(null);
  }

  public AppUser get(final String username) {
    return users.stream()
      .filter(u -> u.getUsername().equals(username))
      .findFirst()
      .orElse(null);
  }
}
