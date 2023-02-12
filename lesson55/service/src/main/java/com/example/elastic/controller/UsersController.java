package com.example.elastic.controller;

import com.example.elastic.converter.UserConverter;
import com.example.elastic.dto.CreateUserDto;
import com.example.elastic.dto.UserDto;
import com.example.elastic.model.AppUser;
import com.example.elastic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {

  private final UserService userService;
  private final UserConverter userConverter;

  @PostMapping
  public UserDto save(@RequestBody final CreateUserDto request) {
    final AppUser user = userConverter.fromDto(request);
    final AppUser savedUser = userService.save(user);
    return userConverter.toDto(savedUser);
  }

}
