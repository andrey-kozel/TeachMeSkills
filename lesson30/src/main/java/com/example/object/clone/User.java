package com.example.object.clone;

public class User implements Cloneable {

  private String name;
  private int age;
  private boolean male;

  public User(String name, int age, boolean male) {
    this.name = name;
    this.age = age;
    this.male = male;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean isMale() {
    return male;
  }

  public void setMale(boolean male) {
    this.male = male;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", male=" + male +
      '}';
  }
}
