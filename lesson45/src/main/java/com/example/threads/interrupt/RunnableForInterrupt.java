package com.example.threads.interrupt;

public class RunnableForInterrupt implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Run by " + Thread.currentThread().getName() + ", i = " + i + "Interrupted = " + Thread.currentThread().isInterrupted());
      try {
        Thread.sleep(500);
      } catch (final InterruptedException ex) {
        System.out.println("I'm interrupted :(" + Thread.currentThread().isInterrupted());
        return;
      }
    }
    System.out.println("Thread finished " + Thread.currentThread().getName());
  }
}
