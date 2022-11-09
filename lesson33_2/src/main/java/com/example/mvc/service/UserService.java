package com.example.mvc.service;

import java.util.List;

import com.example.mvc.model.User;
import com.example.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

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
