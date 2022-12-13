package com.exmaple.command.controller;

import com.exmaple.command.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/commands")
@RestController
@RequiredArgsConstructor
public class CommandsController {

  private final CommandService commandService;

  @PostMapping("/hello")
  public void sendHelloCommand() {
    commandService.sendHelloMessage();
  }

}
