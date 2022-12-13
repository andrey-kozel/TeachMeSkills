package com.exmaple.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.exmaple.security.client")
public class ApiGatewayApplication {

  public static void main(final String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }

}
