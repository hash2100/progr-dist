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

@ServerEndpoint(value="/cmmdc",
  decoders={CmmdcBeanXMLDecoder.class,CmmdcBeanJSONDecoder.class})
public class CmmdcWebSocketServer{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public void myTask(Session session,CmmdcBean obj) throws IOException,EncodeException{
    long m=obj.getM();
    long n=obj.getN();
    long r=cmmdc(m,n);
    System.out.println(m+" : "+n+" : "+r);       
    for (Session peer : sessions) {
      if(peer.equals(session)){
        peer.getBasicRemote().sendText(new Long(r).toString());
      }
    }       
  }
  
  public long cmmdc(long m,long n){
    long r,c;
    do{
       c=n;
       r=m%n;
       m=n;
       n=r;
       }
    while(r!=0);
    return c;
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
