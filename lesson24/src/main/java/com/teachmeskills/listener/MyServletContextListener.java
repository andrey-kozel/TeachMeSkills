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
  public void contextInitialized(final ServletContextEvent sce) {
    final String dbDriver = "org.postgresql.Driver";
    final String username = sce.getServletContext().getInitParameter("db_user");
    final String password = sce.getServletContext().getInitParameter("db_password");
    final String dbUrl = sce.getServletContext().getInitParameter("db_url");

    try {
      Class.forName(dbDriver);
      final Connection con = DriverManager.getConnection(dbUrl, username, password);
      sce.getServletContext().setAttribute("connection", con);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    try {
      final Connection connection = (Connection) sce.getServletContext().getAttribute("connection");
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
