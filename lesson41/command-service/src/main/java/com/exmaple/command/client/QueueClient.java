package com.exmaple.command.client;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueClient {

  private final AmazonSQS sqs;

  public void sendHelloMessage() {
    sqs.sendMessage(new SendMessageRequest("http://localhost:4566/000000000000/test", "Hello!"));
  }
}
