package com.teachmeskills.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/annotated-test")
public class AnnotationConfiguredHelloWorld extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (PrintWriter writer = resp.getWriter()) {
      writer.write("Hello world from annotated servlet 3.0");
      writer.write(System.getenv("HELLO"));
      writer.write(req.getPathInfo());
    };
  }
}
