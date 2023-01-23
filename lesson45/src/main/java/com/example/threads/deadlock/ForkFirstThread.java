package com.example.threads.deadlock;

public class ForkFirstThread implements Runnable {

  final Object knife;
  final Object fork;

  public ForkFirstThread(final Object knife, final Object fork) {
    this.knife = knife;
    this.fork = fork;
  }

  @Override
  public void run() {
    System.out.println("I would like to eat");
    synchronized (fork) {
      System.out.println("I've got fork");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      synchronized (knife) {
        System.out.println("I've knife");

      }
    }

    System.out.println("I've finished");
  }
}
