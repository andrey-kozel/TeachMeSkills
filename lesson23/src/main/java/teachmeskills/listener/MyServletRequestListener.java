package teachmeskills.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("(Request listener) Start. Caller IP address is " + sre.getServletRequest().getLocalAddr());
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    System.out.println("(Request listener) Finish. Caller IP address is " + sre.getServletRequest().getLocalAddr());
  }
}
