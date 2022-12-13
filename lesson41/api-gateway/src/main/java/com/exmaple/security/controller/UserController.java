package com.exmaple.security.controller;

import com.exmaple.security.config.jwt.Jwt;
import com.exmaple.security.converter.UserConverter;
import com.exmaple.security.dto.AuthResultDto;
import com.exmaple.security.dto.CredentialsDto;
import com.exmaple.security.dto.UserDto;
import com.exmaple.security.model.AppUser;
import com.exmaple.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserConverter userConverter;
  private final Jwt jwt;

  @PostMapping("/registration")
  public UserDto registerUser(@RequestBody final CredentialsDto credentials) {
    final AppUser user = userConverter.fromDto(credentials);
    final AppUser saved = userService.saveUser(user);
    return userConverter.toDto(saved);
  }

  @PostMapping("/auth")
  public AuthResultDto authorize(@RequestBody final CredentialsDto credentials) {
    AppUser user = userService.verifyUser(credentials.getUsername(), credentials.getPassword());

    String token = jwt.generateToken(user.getUsername());
    return new AuthResultDto(token);
  }

  @GetMapping("/me")
  public UserDto getCurrenUser() {
    final User authorized = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    final AppUser user = userService.getUser(authorized.getUsername());
    return userConverter.toDto(user);
  }

}
