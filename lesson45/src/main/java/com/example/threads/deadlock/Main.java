package com.example.threads.deadlock;

public class Main {

  public static void main(String[] args) {
    final Object knife = "knife";
    final Object fork = "fork";
    final KnifeFirstThread knifeFirstThread = new KnifeFirstThread(knife, fork);
    final ForkFirstThread forkFirstThread = new ForkFirstThread(knife, fork);

    final Thread thread = new Thread(knifeFirstThread);
    final Thread thread2 = new Thread(forkFirstThread);

    thread2.start();
    thread.start();
  }

}
