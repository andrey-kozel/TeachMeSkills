package com.teachmeskills.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class HelloWorldServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req,
                       HttpServletResponse resp) throws IOException {
    try (PrintWriter writer = resp.getWriter()) {
      Connection connection = (Connection) getServletContext().getAttribute("connection");
      Statement statement = connection.createStatement();
      String sql = "select name from users";
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.getString("name"));
      }
      writer.write("<h2>Hello world from servlet 3.0</h2>");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
