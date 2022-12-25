package com.example.threads.synchronization;

public class SynchronizedMethod {

  public static synchronized void printMessage(final String threadName) throws InterruptedException {
    System.out.println("Synchronized method. Thread: " + threadName);
    Thread.sleep(1000);
  }

}
