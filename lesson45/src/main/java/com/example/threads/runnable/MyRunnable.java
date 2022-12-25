package com.example.threads.runnable;

public class MyRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println("Some actions. Thread: " + Thread.currentThread().getName());
  }
}
