package com.exmaple.aspect.repository;

import java.util.List;

import com.exmaple.aspect.model.User;

public class InMemoryUserRepository implements UserRepository {

  private final List<User> users = List.of(
    User.builder().id(1).name("1").build(),
    User.builder().id(2).name("2").build(),
    User.builder().id(3).name("3").build(),
    User.builder().id(4).name("4").build(),
    User.builder().id(5).name("5").build()
  );

  @Override
  public User getUser(final int id) {
    System.out.println("Real method called!");
    return users.stream()
      .filter(user -> user.getId() == id)
      .findFirst()
      .orElse(null);
  }
}
