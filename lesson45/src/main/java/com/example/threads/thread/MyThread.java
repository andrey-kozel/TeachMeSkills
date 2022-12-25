package com.example.threads.thread;

public class MyThread extends Thread {

  @Override
  public void run() {
    System.out.println("Some actions. Thread: " + getName());
  }
}
