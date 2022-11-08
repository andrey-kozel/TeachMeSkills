package com.teachmeskills.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.teachmeskills.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class DependencyInitializationContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(final ServletContextEvent sce) {
    final ApplicationContext context = new ClassPathXmlApplicationContext("lesson26.xml");
    final UserService userService = context.getBean(UserService.class);
    sce.getServletContext().setAttribute("userService", userService);
  }
}
