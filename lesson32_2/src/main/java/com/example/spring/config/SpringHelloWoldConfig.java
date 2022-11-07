package com.example.spring.config;

import com.example.spring.model.SpringHelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringHelloWoldConfig {

  @Bean
  public SpringHelloWorld springHelloWorld(final String message) {
    return new SpringHelloWorld(message);
  }

  @Bean
  public String message() {
    return "Hello TMS teams!";
  }

}
