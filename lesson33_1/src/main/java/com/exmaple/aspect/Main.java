package com.exmaple.aspect;

import com.exmaple.aspect.repository.UserRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
    final UserRepository repository = (UserRepository) context.getBean("userRepository");

    System.out.println(repository.getUser(1));
    System.out.println(repository.getUser(1));
    System.out.println(repository.getUser(1));
    System.out.println(repository.getUser(1));
  }

}
