package com.exmaple.security.controller;

import com.exmaple.security.client.dto.AppUserDto;
import com.exmaple.security.client.dto.VerifyResultDto;
import com.exmaple.security.config.jwt.Jwt;
import com.exmaple.security.converter.UserConverter;
import com.exmaple.security.dto.AuthResultDto;
import com.exmaple.security.dto.CredentialsDto;
import com.exmaple.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
  public AppUserDto registerUser(@RequestBody final CredentialsDto credentials) {
    final AppUserDto user = userConverter.fromDto(credentials);
    return userService.saveUser(user);
  }

  @PostMapping("/auth")
  public ResponseEntity authorize(@RequestBody final CredentialsDto credentials) {
    final VerifyResultDto result = userService.verifyUser(credentials.getUsername(), credentials.getPassword());

    if (!result.isValid()) {
      return ResponseEntity
        .badRequest()
        .body("Invalid credentials");
    }

    final String token = jwt.generateToken(credentials.getUsername());

    return ResponseEntity
      .ok(new AuthResultDto(token));
  }

  @GetMapping("/me")
  public AppUserDto getCurrenUser() {
    final User authorized = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return userService.getUser(authorized.getUsername());
  }

}
