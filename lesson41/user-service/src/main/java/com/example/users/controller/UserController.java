package com.example.users.controller;

import com.example.users.converter.UserConverter;
import com.example.users.dto.AppUserDto;
import com.example.users.dto.CreateUserDto;
import com.example.users.dto.VerifyResultDto;
import com.example.users.dto.VerifyUserDto;
import com.example.users.model.User;
import com.example.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserConverter userConverter;

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public AppUserDto getUser(@PathVariable(name = "id") final String id) {
    final User user = userService.get(id);

    return userConverter.toDto(user);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/verify")
  public VerifyResultDto verifyUser(final VerifyUserDto request) {
    final boolean isValid = userService.verify(request.getLogin(), request.getPassword());

    return VerifyResultDto.builder()
      .valid(isValid)
      .build();

  }

  @RequestMapping(method = RequestMethod.POST)
  public AppUserDto saveUser(final CreateUserDto request) {
    final User user = userService.save(request.getLogin(), request.getPassword());

    return userConverter.toDto(user);
  }

}
