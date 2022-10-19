package com.example.model;

import java.util.Date;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {
  String username;
  String password;
  Date createdAt;

  public String getUsername() {
    return username + "123";
  }
}
