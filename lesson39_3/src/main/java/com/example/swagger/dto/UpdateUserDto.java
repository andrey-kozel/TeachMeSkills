package com.example.swagger.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class UpdateUserDto {

  @Size(min = 2, max = 20)
  @NotEmpty
  String firstName;

  @Size(min = 2, max = 20)
  @NotEmpty
  String lastName;

  @Size(min = 8, max = 20)
  @NotEmpty
  String password;

}
