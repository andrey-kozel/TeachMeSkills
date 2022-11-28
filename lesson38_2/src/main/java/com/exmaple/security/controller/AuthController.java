package com.exmaple.security.controller;

import com.exmaple.security.config.jwt.Jwt;
import com.exmaple.security.dto.AuthResultDto;
import com.exmaple.security.dto.CredentialsDto;
import com.exmaple.security.model.AppUser;
import com.exmaple.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;
  private final Jwt jwt;

  @PostMapping
  public AuthResultDto authorize(@RequestBody final CredentialsDto credentials) {
    AppUser user = userService.getUser(credentials.getUsername(), credentials.getPassword());

    String token = jwt.generateToken(user.getUsername());
    return new AuthResultDto(token);
  }

}
