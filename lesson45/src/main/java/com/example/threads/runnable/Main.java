package com.example.threads.runnable;

public class Main {

  public static void main(String[] args) {
    final Thread thread1 = new Thread(new MyRunnable());
    final Thread thread2 = new Thread(new MyRunnable());
    final Thread thread3 = new Thread(new MyRunnable());
    System.out.println("Main thread. Thread: " + Thread.currentThread().getName());
    thread1.start();
    thread2.start();
    thread3.start();
  }

}
