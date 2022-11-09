package com.example.mvc.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CreateUserDto {

  @NotEmpty
  private final String name;
  @NotEmpty
  private final String password;
  @NotEmpty
  private final String role;

}
