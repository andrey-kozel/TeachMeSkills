package com.example.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.users.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final AtomicLong idSequence = new AtomicLong();
  private final List<User> users = new ArrayList<>();

  public User get(final String username) {
    return users.stream()
      .filter(u -> u.getUsername().equals(username))
      .findFirst()
      .orElse(null);
  }

  public boolean verify(final String login, final String password) {
    return users.stream()
      .filter(u -> u.getUsername().equals(login))
      .anyMatch(u -> u.getPassword().equals(password));
  }

  public User save(final String login, final String password) {
    final User user = User.builder()
      .username(login)
      .password(password)
      .id(idSequence.incrementAndGet())
      .build();

    users.add(user);

    return user;
  }
}
