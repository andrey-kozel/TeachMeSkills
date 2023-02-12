package com.example.elastic.controller;

import java.util.List;

import com.example.elastic.dto.UserDto;
import com.example.elastic.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class UserSearchController {

  private final UserFacade userFacade;

  @GetMapping("/users")
  public List<UserDto> findUsers(@RequestParam("description") final String description) {
    return userFacade.findUsers(description);
  }

}
