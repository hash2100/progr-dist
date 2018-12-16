import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class EmbeddedJetty{
  public static void main(String[] args) throws Exception{
    Server server = new Server(9080);
		
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new CmmdcServlet()),"/cmmdc/*");
    context.addServlet(new ServletHolder(new HelloServlet()),"/hello/*");
    
    server.start();
    server.join();
  }
}