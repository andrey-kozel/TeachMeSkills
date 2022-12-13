package com.example.users.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {

  String login;
  String password;
}
