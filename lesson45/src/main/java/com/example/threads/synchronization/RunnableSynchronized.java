package com.example.threads.synchronization;

public class RunnableSynchronized implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Run by " + Thread.currentThread().getName() + ", i = " + i);
      try {
        SynchronizedMethod.printMessage(Thread.currentThread().getName());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("Thread finished " + Thread.currentThread().getName());
  }
}
