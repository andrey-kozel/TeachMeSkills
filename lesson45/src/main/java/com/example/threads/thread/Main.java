package com.example.threads.thread;

public class Main {

  public static void main(String[] args) {
    final MyThread thread1 = new MyThread();
    System.out.println("Main thread. Thread: " + Thread.currentThread().getName());
    thread1.start();
  }

}
