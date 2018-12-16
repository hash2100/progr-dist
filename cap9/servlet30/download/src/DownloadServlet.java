import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet; 

@WebServlet(urlPatterns = "/download")

public class DownloadServlet extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    ServletOutputStream out=res.getOutputStream(); 
    String file=req.getParameter("file");
    System.out.println(file);
    String cale="../webapps/download/resources/";
    // vezi https://stackoverflow.com/questions/5856024/in-which-folder-is-fileinputstream-looking
    try{
      System.out.println(cale+file);
      FileInputStream fis = new FileInputStream(cale+file); 
      BufferedInputStream bis = new BufferedInputStream(fis);
      byte[] bytes = new byte[bis.available()]; 
      res.setContentType("Application/Octet-stream"); 
      res.addHeader("Content-Disposition", "attachment; filename="+ file);
      bis.read(bytes);
      out.write(bytes);
      bis.close();
      fis.close();
      out.close();
    }
    catch(Exception e){
      res.setContentType("text/plain"); 
      out.println("Folderul de unde se porneste: " + System.getProperty("user.dir"));
      out.println("Cererea d-voastra nu poate fi satisfacuta");
    }      
    out.close();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
    doGet(req,res);
  }
}
