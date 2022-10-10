package com.teachmeskills.repository;

import java.util.List;
import java.util.Optional;

import com.teachmeskills.model.User;

public interface UserRepository {

  List<User> findUsers();

  Optional<User> getUser(String name);

  void createUser(String name, String password, String role);
}
