package com.example.worker.client;

import java.util.Optional;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.example.worker.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueClient {

  private final AmazonSQS sqs;

  public Optional<Message> getMessage() {
    ReceiveMessageResult receiveMessageResult = sqs.receiveMessage("http://localhost:4566/000000000000/test2");
    return receiveMessageResult.getMessages().stream()
      .findFirst()
      .map(m -> Message.builder()
        .content(m.getBody())
        .receipt(m.getReceiptHandle())
        .build());
  }

  public void deleteMessage(final String receipt) {
    sqs.deleteMessage(new DeleteMessageRequest("http://localhost:4566/000000000000/test2", receipt));
  }

}
