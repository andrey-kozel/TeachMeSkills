package teachmeskills.listener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("(Context listener) Start. Caller IP address is " + sce.getServletContext().getServerInfo());
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("(Context listener) Finish. Caller IP address is " + sce.getServletContext().getServerInfo());

  }
}
