package com.example.threads.sleep;

public class RunnableWithSleep implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Run by " + Thread.currentThread().getName() + ", i = " + i);
      try {
        Thread.sleep(1000);
      } catch (final Exception ex) {
        ex.printStackTrace();
      }
    }
    System.out.println("Thread finished " + Thread.currentThread().getName());
  }
}
