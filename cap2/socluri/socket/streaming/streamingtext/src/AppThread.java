package streamingtext;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class AppThread extends Thread{
  Socket socket=null;

  public AppThread(Socket socket){
    this.socket=socket;
  }

  public void run(){
    String path="../resources/text/";
    try(DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out=new DataOutputStream(socket.getOutputStream())){
      int noFile=in.readInt();
      System.out.println(noFile);
      
      String fileName="";
      if(noFile==1)
        fileName="capitol.txt";
      else
        fileName="junit.tex";     
      File inputFile=new File(path+fileName);
      FileReader fr=new FileReader(inputFile);
      BufferedReader br= new BufferedReader(fr);
      
      String s; 
      while((s=br.readLine())!=null) out.writeUTF(s);   
      out.writeUTF("endOFfile");      
      out.flush();
      br.close();
      fr.close();
      System.out.println("Activity Finished !");
      socket.close();
    }
    catch(IOException e){
       System.err.println("Server comunication error : "+e.getMessage());
    }  
  }
}
