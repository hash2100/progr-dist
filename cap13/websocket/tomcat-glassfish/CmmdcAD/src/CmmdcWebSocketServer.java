package websocket.cmmdc;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;  
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import javax.websocket.RemoteEndpoint;

@ServerEndpoint(value="/cmmdc")
public class CmmdcWebSocketServer{
  interface CmmdcService {
      long cmmdc(long m, long n);
  }

  static CmmdcService cmmdcService=(long m, long n) -> 
    { 
      long r,c;
      do{
         c=n;
         r=m%n;
         m=n;
         n=r;
         }
      while(r!=0);
      return c;
    };   
    
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public void myTask(String msg,Session session) throws IOException,EncodeException{
    String[] elem=msg.split(":");
    long m=Long.parseLong(elem[0]);
    long n=Long.parseLong(elem[1]);
    System.out.println(m+" : "+n);
    long r=cmmdcService.cmmdc(m,n);
    String rez=new Long(r).toString();
    //System.out.println(m+" : "+n+" : "+r);       
    sessions.stream()
      .filter(s->s.equals(session))
      .forEach(s->{
        RemoteEndpoint.Basic endpoint=s.getBasicRemote();
        try{
          endpoint.sendText(rez);
        }
        catch(IOException e){};
     }); 
  }
  
  
  @OnOpen
  public void onOpen(Session session){
    sessions.add(session);
  }
     
  @OnClose
  public void onClose(Session session){
    sessions.remove(session);
  }
}
