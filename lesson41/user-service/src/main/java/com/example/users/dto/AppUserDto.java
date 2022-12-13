package com.example.users.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@Builder
public class AppUserDto {

  long id;
  String username;
  String password;
  String role;
}
