package com.example.worker.service;

import java.util.Optional;

import com.example.worker.client.QueueClient;
import com.example.worker.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandService {

  private final QueueClient queueClient;

  public Optional<Message> getCommand() {
    return queueClient.getMessage();
  }

  public void deleteMessage(final String receipt) {
    queueClient.deleteMessage(receipt);
  }

}
