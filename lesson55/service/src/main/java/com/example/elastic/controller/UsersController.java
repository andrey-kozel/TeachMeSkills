package com.example.elastic.controller;

import com.example.elastic.config.jwt.Jwt;
import com.example.elastic.converter.UserConverter;
import com.example.elastic.dto.AuthorizeUserDto;
import com.example.elastic.dto.CreateUserDto;
import com.example.elastic.dto.TokenDto;
import com.example.elastic.dto.UserDto;
import com.example.elastic.facade.UserFacade;
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

  private final UserFacade userFacade;
  private final UserConverter userConverter;
  private final Jwt jwt;

  @PostMapping
  public UserDto save(@RequestBody final CreateUserDto request) {
    final AppUser user = userConverter.fromDto(request);
    final AppUser savedUser = userFacade.save(user);
    return userConverter.toDto(savedUser);
  }

  @PostMapping("auth")
  public TokenDto authorize(@RequestBody final AuthorizeUserDto request) {
    final AppUser user = userFacade.verifyUser(request.getUsername(), request.getPassword());
    final String accessToken = jwt.generateToken(user.getUsername());
    return TokenDto.builder()
      .accessToken(accessToken)
      .build();
  }


}
