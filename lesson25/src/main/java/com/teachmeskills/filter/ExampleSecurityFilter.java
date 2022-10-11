package com.teachmeskills.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(value = "/examples.jsp")
public class ExampleSecurityFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
    final HttpServletRequest httpRequest = (HttpServletRequest) request;
//    final Boolean loggedIn = (Boolean) httpRequest.getSession().getAttribute("loggedIn");
//    if (loggedIn == null || !loggedIn) {
//      request.getServletContext().getRequestDispatcher("/accessDenied.jsp").forward(request, response);
//      return;
//    }
    chain.doFilter(request, response);
  }
}
