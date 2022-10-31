package com.example.object.clone;

public class CloneExample {

  public static void main(String[] args) throws CloneNotSupportedException {
    User user = new User("Andrey", 31, true);
    User newUser = (User) user.clone();

    System.out.println(user);
    System.out.println(newUser);
  }

}
