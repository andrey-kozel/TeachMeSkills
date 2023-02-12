package com.example.elastic.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class CreateUserDto {

  String username;
  String password;

}
