package com.example.threads.join;

public class RunnableForJoin implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Run by " + Thread.currentThread().getName() + ", i = " + i);
      try {
        Thread.sleep(500);
      } catch (final Exception ex) {
        ex.printStackTrace();
      }
    }
    System.out.println("Thread finished " + Thread.currentThread().getName());
  }
}
