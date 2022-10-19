package com.example;

import java.util.Date;

import com.example.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) {

    User user = User.builder()
      .username("name")
      .password("password")
      .createdAt(new Date())
      .build();
    log.info("User created. User=[{}]", user);
    log.info("User created. Username=[{}]", user.getUsername());
  }


}
