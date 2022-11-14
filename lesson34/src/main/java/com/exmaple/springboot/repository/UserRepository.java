package com.exmaple.springboot.repository;

import java.util.List;
import java.util.Optional;

import com.exmaple.springboot.model.User;

public interface UserRepository {

  List<User> findUsers();

  Optional<User> getUser(String name);

  void createUser(String name, String password, String role);
}
