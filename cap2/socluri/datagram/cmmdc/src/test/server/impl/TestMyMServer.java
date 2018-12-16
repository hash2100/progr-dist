package server.impl;
import server.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.net.DatagramSocket;
import iserver.IMyMServer;

public class TestMyMServer{
  private IMyMServer obj;
  
  @Before
  public void initializare(){
    obj=new MyMServer(); 
  }
  
  @Test 
  public void test(){ 
    int port=7999;  
    Object result=obj.getDatagramSocket(port);
    assertNotNull("Must not return a null response",result);
    assertEquals(DatagramSocket.class,result.getClass());
  }
  
  public static void main(String[] args){
    org.junit.runner.JUnitCore.main("server.impl.TestMyMServer");
  }
}