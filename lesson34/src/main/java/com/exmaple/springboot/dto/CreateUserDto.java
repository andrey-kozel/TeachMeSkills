package com.exmaple.springboot.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CreateUserDto {

  @NotEmpty
  private String name;
  @NotEmpty
  private String password;
  @NotEmpty
  private String role;

}
