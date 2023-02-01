package com.java.example.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {

  long id;
  String name;
  String role;
  String password;
  Instant createdAt;

}
