package com.exmaple.test.controller;

import javax.validation.Valid;

import com.exmaple.test.dto.UpdateUserDto;
import com.exmaple.test.dto.UserDto;
import com.exmaple.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

  @GetMapping("/{userId}")
  public UserDto get(@PathVariable final Long userId) {
    return userService.get(userId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void save(@Valid @RequestBody final UpdateUserDto dto) {
    userService.save(dto);
  }

  @PutMapping("/{userId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void update(
    @PathVariable final Long userId,
    @Valid @RequestBody final UpdateUserDto dto
  ) {
    userService.update(userId, dto);
  }

  @DeleteMapping("/{userId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(@PathVariable final Long userId) {
    userService.delete(userId);
  }

}
