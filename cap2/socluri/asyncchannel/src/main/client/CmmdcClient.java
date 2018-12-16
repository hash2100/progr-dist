package client;
import java.net.UnknownHostException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.ByteBuffer;
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.Future;

public class CmmdcClient {
  public static void main(String[] args) {
    String host="localhost";
    int port=7999;
    if (args.length>0)
      host=args[0];
    if (args.length>1)
      port=Integer.parseInt(args[1]);
    AsynchronousSocketChannel asc=null;  
    //Future<Void> connectFuture=null; 
    try{      
      InetSocketAddress isa=new InetSocketAddress(host,port); 
      asc=AsynchronousSocketChannel.open();
      //connectFuture=
      asc.connect(isa);
    }
    catch (UnknownHostException e) {
      System.err.println("Server necunoscut: "+host+" "+e.getMessage());
      System.exit(1);
    }
    catch (IOException e) {
      System.err.println("Conectare imposibila la: "+
                host+" pe portul "+port+" "+e.getMessage());
      System.exit(1);
    }
    /*
    if (!connectFuture.isDone()) {
      connectFuture.cancel(true);
      System.out.println("Most");
      System.exit(0);
    }
    */    
   // while(!connectFuture.isDone());
    //else{
      Scanner scanner=new Scanner(System.in);
      long m,n,r;
      System.out.println("m=");
      m=scanner.nextLong();
      System.out.println("n=");
      n=scanner.nextLong();
          
      ByteBuffer bb=ByteBuffer.allocate(16);
      // Varianta 1
      bb.putLong(0,m).putLong(8,n);
      // Varianta 2
      // LongBuffer lb=bb.asLongBuffer();
      // lb.put(0,m).put(1,n);
      try{
        Future<Integer> fw=asc.write(bb);
        while(!fw.isDone());
        bb.clear();
        Future<Integer> fr=asc.read(bb);
        while(!fr.isDone());
        // Varianta 1
        r=bb.getLong(0);
        // Varianta 2
        // r=lb.get(0);
        System.out.println("Cmmdc : "+r);
        asc.close();
      }
      catch(Exception e){
        System.err.println("Eroare de comunicatie"+e.getMessage());
      }
    //}  
  }
}


