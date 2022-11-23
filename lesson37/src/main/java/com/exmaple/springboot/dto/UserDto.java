package com.exmaple.springboot.dto;

import java.util.Date;

import lombok.Value;

@Value
public class UserDto {

  Long id;
  String name;
  String role;
  Date createdAt;

}
