package com.example.waiting;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {

  private Data data;

  Sender(Data data) {
    this.data = data;
  }

  public void run() {
    String packets[] = {
      "First packet",
      "Second packet",
      "Third packet",
      "Fourth packet",
      "End"
    };

    for (String packet : packets) {
      data.send(packet);

      // Thread.sleep() to mimic heavy server-side processing
      try {
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Thread Interrupted");
      }
    }
  }

}
