package com.example.threads.deadlock;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    final Object knife = "knife";
    final Object fork = "fork";
    final KnifeFirstThread knifeFirstThread = new KnifeFirstThread(knife, fork);
    final ForkFirstThread forkFirstThread = new ForkFirstThread(knife, fork);

    final Thread thread = new Thread(knifeFirstThread);
    final Thread thread2 = new Thread(forkFirstThread);
    final Thread thread3 = new Thread(() -> thread.interrupt());

    thread2.start();
    thread.start();

    Thread.sleep(2000);

    thread3.start();;
  }

}
