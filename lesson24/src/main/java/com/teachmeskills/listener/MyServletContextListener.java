package com.teachmeskills.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("(Context listener) Start. Caller IP address is " + sce.getServletContext().getServerInfo());
    String dbName = "jdbc:postgresql://demo-postgres:5432/postgres";
    String dbDriver = "org.postgresql.Driver";
    String userName = "postgres";
    String password = "postgres";

    try {
      Class.forName(dbDriver);
      Connection con = DriverManager.getConnection(dbName, userName, password);
      sce.getServletContext().setAttribute("connection", con);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("(Context listener) Finish. Caller IP address is " + sce.getServletContext().getServerInfo());

  }
}
