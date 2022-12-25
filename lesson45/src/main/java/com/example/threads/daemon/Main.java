package com.example.threads.daemon;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    final DaemonRunnable daemonRunnable = new DaemonRunnable();
    final Thread thread = new Thread(daemonRunnable);
    thread.setDaemon(true);
    thread.start();

    Thread.sleep(1000);
  }

}
