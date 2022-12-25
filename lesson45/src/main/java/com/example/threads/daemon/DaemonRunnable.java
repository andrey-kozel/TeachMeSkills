package com.example.threads.daemon;

public class DaemonRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println("Thread started. Thread: " + Thread.currentThread().getName());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Thread finished. Thread: " + Thread.currentThread().getName());
  }
}
