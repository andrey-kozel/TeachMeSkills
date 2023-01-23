package com.example.threads.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedMethod {

  private final static Lock LOCK = new ReentrantLock(true);

  public static void printMessage(final String threadName) throws InterruptedException {
    try {
      LOCK.lock();
      System.out.println("Synchronized method. Thread: " + threadName);
      Thread.sleep(1000);
    } finally {
      LOCK.unlock();
    }
  }

}
