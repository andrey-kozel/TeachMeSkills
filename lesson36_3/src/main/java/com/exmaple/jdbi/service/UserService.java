package com.exmaple.jdbi.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.exmaple.jdbi.model.User;
import com.exmaple.jdbi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  @PostConstruct
  public void init() {
    System.out.println(userRepository.findAll());
    userRepository.save("name3", "password", "role");
    System.out.println(userRepository.findAll());
    System.out.println(userRepository.findUserByName("nam"));
  }

  public List<User> findUsers() {
    return userRepository.findAll();
  }

  public void createUser(String name, String password, String role) {
    if (userRepository.findUserByName(name).isPresent()) {
      throw new RuntimeException("User already exists");
    }

    userRepository.save(name, password, role);
  }

}
