import java.net.URI;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import javax.websocket.Session;
import java.util.Scanner;
import javax.websocket.Endpoint; 
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;

public class WebSocketClient extends Endpoint{
  private static boolean sfarsit=false;
  private static String SERVER = "ws://localhost:8080/CmmdcWebSocketAD/cmmdc";
  
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong();
    CmmdcBean obj=new CmmdcBean();
    obj.setM(m);
    obj.setN(n); 
    int tip=1;
    do{
      System.out.println("Encoder Type");
      System.out.println("1: JSON");
      System.out.println("2: XML");
      tip=scanner.nextInt();
    }  
    while((tip!=1) &&  (tip!=2));
    
    WebSocketContainer container = ContainerProvider.getWebSocketContainer(); 
    String request=null;
    try {
      if(tip==1){
        CmmdcBeanJSONEncoder encoderJSON=new CmmdcBeanJSONEncoder();
        request=encoderJSON.encode(obj); 
      }
      else{
        CmmdcBeanXMLEncoder encoderXML=new CmmdcBeanXMLEncoder();
        request=encoderXML.encode(obj);
      }  
      System.out.println(request);
      Session session=
        container.connectToServer(WebSocketClient.class, null, 
          new URI(SERVER));
      session.getBasicRemote().sendText(request); 
      //session.getBasicRemote().sendObject(obj);
      while(! sfarsit){;};
    } 
    catch(Exception ex){
       System.out.println("LocalEndPoint Exception : "+ex.getMessage());
    } 
  }
  
  public void onOpen(Session session, EndpointConfig config) {
    session.addMessageHandler(new MessageHandler.Whole<String>() {
       public void onMessage(String text){
         System.out.println("Cmmdc : "+text);
         sfarsit=true;
         System.exit(0);
       }  
    });
  }
}
