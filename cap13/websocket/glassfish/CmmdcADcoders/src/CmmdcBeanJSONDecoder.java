package websocket.cmmdc; 
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import javax.websocket.DecodeException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.json.JsonObject;
import javax.json.JsonNumber;
import javax.json.JsonReader;
import java.util.Iterator;
import java.util.Map;
import java.io.StringReader;

public class CmmdcBeanJSONDecoder implements Decoder.Text<CmmdcBean>{
   @Override
   public void init(EndpointConfig ec) { }
   
   @Override
   public void destroy() { }
   
   @Override
   public CmmdcBean decode(String string) throws DecodeException{
     StringReader sr=new StringReader(string);   
     JsonReader jsonReader = Json.createReader(sr);
     JsonArray jsonArray=jsonReader.readArray();
     jsonReader.close();
   
     Iterator<JsonValue> iterator=jsonArray.iterator();
     long m=0,n=0;
     int k=0;
     while(iterator.hasNext()){
       JsonValue value=(JsonValue)iterator.next();
       if(value instanceof JsonObject){
         System.out.println(value.toString());
         JsonObject obj=(JsonObject)value;
         Map<String,JsonValue> object=(Map)obj;
         //Set<String> keys=object.keySet();
         if(k==0){
           k++;
           JsonValue vm=(JsonValue)object.get("m");
           m=((JsonNumber)vm).longValue();
           System.out.println("m="+m);
         }
         else{
           JsonValue vm=(JsonValue)object.get("n");
           n=((JsonNumber)vm).longValue();
           System.out.println("n="+n);
         }         
       }
     }
     CmmdcBean bean=new CmmdcBean();
     bean.setM(m);
     bean.setN(n);
     return bean;
   }
   
   @Override
   public boolean willDecode(String string) {
     return true;
   }
}