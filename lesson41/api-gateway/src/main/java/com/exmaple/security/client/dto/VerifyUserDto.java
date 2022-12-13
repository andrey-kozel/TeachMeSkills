package com.exmaple.security.client.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VerifyUserDto {

  String login;
  String password;

}
