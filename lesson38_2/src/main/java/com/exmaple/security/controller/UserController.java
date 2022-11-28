package com.exmaple.security.controller;

import com.exmaple.security.converter.UserConverter;
import com.exmaple.security.dto.UserDto;
import com.exmaple.security.model.AppUser;
import com.exmaple.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserConverter userConverter;

  @GetMapping("/{id}")
  public UserDto get(@PathVariable final Long id) {
    final AppUser user = userService.getUser(id);
    return userConverter.toDto(user);
  }

}
