package com.example.threads.alive;

public class AliveRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println("Some actions. Thread: " + Thread.currentThread().getName());
  }
}
