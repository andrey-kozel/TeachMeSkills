package com.exmaple.aspect;

import java.lang.reflect.Proxy;

public class Main2 {

  public static void main(String[] args) {
    MyObject myObject = new MyObject();
    Aspect aspect = new Aspect(myObject);
    myObject.test();
    aspect.test();

    MyObject myObject2 = (MyObject) Proxy.newProxyInstance(MyObject.class.getClassLoader(), new Class[] { MyObject.class },
      (proxy, method, methodArgs) -> {
        if (method.getName().equals("test")) {
          try {
            System.out.println("before");
            method.invoke(proxy, methodArgs);
            System.out.println("after");
          } catch(Exception ex) {
            System.out.println("exception");
          }

        } else {
          method.invoke(proxy, methodArgs);
        }
        return proxy;
      });
  }

  public static class MyObject {

    public void test() {
      System.out.println("test");
    }

  }

  public static class Aspect extends MyObject {

    private MyObject myObject;

    public Aspect(MyObject myObject) {
      this.myObject = myObject;
    }

    @Override
    public void test() {
      before();
      super.test();
      after();
    }

    public void before() {
      System.out.println("before");
    }

    public void after() {
      System.out.println("after");
    }

  }

}
