package teachmeskills.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/annotated-test")
public class AnnotationConfiguredHelloWorld extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (PrintWriter writer = resp.getWriter()) {
      writer.write("Hello world from annotated servlet 3.0");
    }
  }
}
