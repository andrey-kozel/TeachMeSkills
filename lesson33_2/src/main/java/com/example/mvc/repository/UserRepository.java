package com.example.mvc.repository;

import java.util.List;
import java.util.Optional;

import com.example.mvc.model.User;

public interface UserRepository {

  List<User> findUsers();

  Optional<User> getUser(String name);

  void createUser(String name, String password, String role);
}
