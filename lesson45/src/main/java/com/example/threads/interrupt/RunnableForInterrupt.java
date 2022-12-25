package com.example.threads.interrupt;

public class RunnableForInterrupt implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Run by " + Thread.currentThread().getName() + ", i = " + i);
      try {
        Thread.sleep(500);
      } catch (final Exception ex) {
        // SHOW EXAMPLE WITHOUT RETURN
        System.out.println("I'm interrupted :(");
        return;
      }
    }
    System.out.println("Thread finished " + Thread.currentThread().getName());
  }
}
