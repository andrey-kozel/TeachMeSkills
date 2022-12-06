package com.example.swagger.controller;

import javax.validation.Valid;

import com.example.swagger.dto.UpdateUserDto;
import com.example.swagger.dto.UserDto;
import com.example.swagger.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserDto get(@PathVariable final Long userId) {
    log.info("Get user. Id=[{}]", userId);
    return userService.get(userId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void save(@Valid @RequestBody final UpdateUserDto dto) {
    log.info("Create user. Dto=[{}]", dto);
  }

  @PutMapping("/{userId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void update(
    @PathVariable final Long userId,
    @Valid @RequestBody final UpdateUserDto dto
  ) {
    log.info("Update user. Id=[{}] Dto=[{}]", userId, dto);
  }

  @DeleteMapping("/{userId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(@PathVariable final Long userId) {
    log.info("Delete user. Id=[{}]", userId);
  }

}
