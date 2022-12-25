package com.example.threads.interrupt;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    RunnableForInterrupt thread = new RunnableForInterrupt();

    final Thread thread1 = new Thread(thread);

    thread1.start();

    Thread.sleep(1000);

    thread1.interrupt();
  }

}
