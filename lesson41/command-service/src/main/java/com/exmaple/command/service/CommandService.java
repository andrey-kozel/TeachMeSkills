package com.exmaple.command.service;

import com.exmaple.command.client.QueueClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandService {

  private final QueueClient queueClient;

  public void sendHelloMessage() {
    queueClient.sendHelloMessage();
  }
}
