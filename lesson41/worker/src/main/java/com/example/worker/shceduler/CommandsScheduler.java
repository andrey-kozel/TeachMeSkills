package com.example.worker.shceduler;

import com.example.worker.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandsScheduler {

  private final CommandService commandService;

  @Scheduled(cron = "* * * * * *")
  public void processMessage() {
    commandService.getCommand()
      .ifPresentOrElse(
        m -> {
          System.out.println(m.getContent());
          commandService.deleteMessage(m.getReceipt());
        },
        () -> System.out.println("Message not found"));
  }

}
