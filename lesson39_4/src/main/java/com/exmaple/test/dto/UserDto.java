package com.exmaple.test.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class UserDto {

  Long id;
  String firstName;
  String lastName;
  String password;


}
