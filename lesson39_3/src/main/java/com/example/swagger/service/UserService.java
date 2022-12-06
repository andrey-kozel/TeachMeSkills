package com.example.swagger.service;

import com.example.swagger.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public UserDto get(final Long userId) {
    return UserDto.builder()
      .id(userId)
      .firstName("First")
      .lastName("Last")
      .password("Pass")
      .build();
  }
}
