package com.exmaple.oauth.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @GetMapping("/me")
  public String get() {
    return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
  }

}
