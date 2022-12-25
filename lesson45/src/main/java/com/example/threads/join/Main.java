package com.example.threads.join;

public class Main {

  public static void main(String[] args) {
    final RunnableForJoin thread = new RunnableForJoin();
    final Thread thread1 = new Thread(thread);
    final Thread thread2 = new Thread(thread);
    final Thread thread3 = new Thread(thread);
    System.out.println("Main thread. Thread: " + Thread.currentThread().getName());

    thread1.start();

    try {
      thread1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    thread2.start();
    thread3.start();
  }

}
