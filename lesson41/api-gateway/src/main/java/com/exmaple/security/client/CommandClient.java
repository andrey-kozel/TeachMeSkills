package com.exmaple.security.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "command", url = "${services.command.url}/api/v1/commands")
public interface CommandClient {

  @PostMapping("/hello")
  void sendHello();

}
