package com.example.waiting;

public class Data {

  private String packet;

  private boolean hasPacket = false;

  public synchronized String receive() {
    while (!hasPacket) {
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Thread Interrupted");
      }
    }
    this.hasPacket = false;

    String returnPacket = packet;
    notifyAll();
    return returnPacket;
  }

  public synchronized void send(String packet) {
    while (hasPacket) {
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Thread Interrupted");
      }
    }
    this.hasPacket = true;
    this.packet = packet;
    notifyAll();
  }
}
