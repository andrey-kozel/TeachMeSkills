package com.example.path;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Hasher;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

  private static final String SECRET = "SECRET";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    final String password = req.getParameter("password");
    final Hasher hasher = BCrypt.with(new SecureRandom(SECRET.getBytes(StandardCharsets.UTF_8)));
    final String hashedPassword = hasher.hashToString(12, password.toCharArray());
    final Result verify = BCrypt.verifyer()
      .verify(password.getBytes(StandardCharsets.UTF_8), hashedPassword.getBytes(StandardCharsets.UTF_8));

    System.out.println(password);
    System.out.println(hashedPassword);
    System.out.println(verify.verified);
    try (PrintWriter writer = resp.getWriter()) {
      writer.println("Hello world!");
    }
  }
}
