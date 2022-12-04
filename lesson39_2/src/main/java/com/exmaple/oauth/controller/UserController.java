package com.exmaple.oauth.controller;

import java.util.List;

import com.exmaple.oauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  public String get() {
    return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
  }

  @GetMapping
  public List<String> find() {
    return userService.find();
  }

}
