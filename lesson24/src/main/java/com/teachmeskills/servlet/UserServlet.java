package com.teachmeskills.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teachmeskills.model.User;
import com.teachmeskills.service.UserService;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

  private UserService userService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    userService = (UserService) config.getServletContext().getAttribute("userService");
  }

  @Override
  protected void doGet(
    HttpServletRequest req,
    HttpServletResponse resp
  ) throws IOException, ServletException {
    final List<User> users = userService.findUsers();
    req.setAttribute("users", users);
    getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
  }
}
