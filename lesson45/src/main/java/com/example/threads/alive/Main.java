package com.example.threads.alive;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    final Thread thread1 = new Thread(new AliveRunnable());
    System.out.println("Main thread. Thread: " + Thread.currentThread().getName());
    System.out.println("Before starting: " + thread1.isAlive());
    thread1.start();
    System.out.println("Running: " + thread1.isAlive());
    thread1.join();
    System.out.println("After finish: " + thread1.isAlive());
  }

}
