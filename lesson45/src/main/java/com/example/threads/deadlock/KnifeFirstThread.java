package com.example.threads.deadlock;

public class KnifeFirstThread implements Runnable {

  final Object knife;
  final Object fork;

  public KnifeFirstThread(final Object knife, final Object fork) {
    this.knife = knife;
    this.fork = fork;
  }

  @Override
  public void run() {
    System.out.println("I would like to eat");
    synchronized (knife) {
      System.out.println("I've knife");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      synchronized (fork) {
        System.out.println("I've fork");
      }
    }

    System.out.println("I've finished");
  }
}
