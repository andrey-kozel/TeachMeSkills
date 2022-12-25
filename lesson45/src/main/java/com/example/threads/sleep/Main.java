package com.example.threads.sleep;

public class Main {

  public static void main(String[] args) {
    final RunnableWithSleep thread = new RunnableWithSleep();
    final Thread thread1 = new Thread(thread);
    final Thread thread2 = new Thread(thread);
    final Thread thread3 = new Thread(thread);
    System.out.println("Main thread. Thread: " + Thread.currentThread().getName());
    thread1.start();
    thread2.start();
    thread3.start();
  }

}