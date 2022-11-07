package com.example.spring;

import com.example.spring.model.SpringHelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloWorldRunner {

  public static void main(String[] args) {
    try (
      final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-hello-bean.xml")
    ) {
      final SpringHelloWorld helloWorld = context.getBean("springHelloWorld", SpringHelloWorld.class);
      System.out.println(helloWorld.getHelloMessage());
    }
  }

}
