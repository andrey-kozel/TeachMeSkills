package com.exmaple.security.controller;

import com.exmaple.security.client.CommandClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/commands")
@RequiredArgsConstructor
public class CommandController {

  private final CommandClient commandClient;

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping("/hello")
  public void sendHello() {
    commandClient.sendHello();
  }

}
