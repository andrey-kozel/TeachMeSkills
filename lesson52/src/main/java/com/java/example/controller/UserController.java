package com.java.example.controller;

import java.util.List;

import com.java.example.converter.UserConverter;
import com.java.example.dto.UserDto;
import com.java.example.entity.UserEntity;
import com.java.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private static final int PAGE_SIZE = 20;

  private final UserService userService;
  private final UserConverter userConverter;

  @GetMapping("/offset-paging")
  public List<UserDto> getOffsetUsers(@RequestParam("page") final long page) {
    final List<UserEntity> users = userService.getOffsetUsers(page, PAGE_SIZE);
    return userConverter.toDto(users);
  }

  @GetMapping("/filter-paging")
  public List<UserDto> getFilteredUsers(@RequestParam("idOffset") final long idOffset) {
    final List<UserEntity> users = userService.getFilteredUsers(idOffset, PAGE_SIZE);
    return userConverter.toDto(users);
  }

}
