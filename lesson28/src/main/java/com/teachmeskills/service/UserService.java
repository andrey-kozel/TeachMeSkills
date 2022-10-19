package com.teachmeskills.service;

import java.util.List;

import com.teachmeskills.model.User;
import com.teachmeskills.repository.UserRepository;

public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findUsers() {
    return userRepository.findUsers();
  }

  public void createUser(String name, String password, String role) {
    if (userRepository.getUser(name).isPresent()) {
      throw new RuntimeException("User already exists");
    }

    userRepository.createUser(name, password, role);
  }
}
