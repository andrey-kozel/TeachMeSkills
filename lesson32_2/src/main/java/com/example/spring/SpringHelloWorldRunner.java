package com.example.spring;

import com.example.spring.config.SpringHelloWoldConfig;
import com.example.spring.model.SpringHelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringHelloWorldRunner {

  public static void main(String[] args) {
    try (
      final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        SpringHelloWoldConfig.class)
    ) {
      final SpringHelloWorld helloWorld = context.getBean("springHelloWorld", SpringHelloWorld.class);
      System.out.println(helloWorld.getHelloMessage());
    }
  }

}
