package com.example.mvc.dto;

import lombok.Data;

@Data
public class CreateUserDto {

  private final String name;
  private final String password;
  private final String role;

}
