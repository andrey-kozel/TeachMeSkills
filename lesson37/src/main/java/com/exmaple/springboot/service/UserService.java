package com.exmaple.springboot.service;

import java.util.List;

import com.exmaple.springboot.model.User;
import com.exmaple.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> findUsers() {
    return userRepository.findAll();
  }

  public User createUser(String name, String password, String role) {
    if (userRepository.findUserByName(name).isPresent()) {
      throw new RuntimeException("User already exists");
    }

    final User user = new User(name, password, role);
    userRepository.save(user);
    return user;
  }

  public User get(final Long userId) {
    return userRepository.getReferenceById(userId);
  }
}
