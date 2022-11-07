package com.example.spring.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class SpringHelloWorld {

  private final String helloMessage;

  @Autowired
  public SpringHelloWorld(final String helloMessage) {
    this.helloMessage = helloMessage;
  }
}
