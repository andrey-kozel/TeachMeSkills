package com.exmaple.oauth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  private static final List<String> USERS = new ArrayList<>();

  public void save(String userId) {
    USERS.add(userId);
  }

  public List<String> find() {
    return USERS;
  }
}
