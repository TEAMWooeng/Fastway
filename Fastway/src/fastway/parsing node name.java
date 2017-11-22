import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class parsing node name {
   public static void main(String[] args) throws Exception {
   String name,st,ed,dist,cd; 
   String target = "http://openapi.seoul.go.kr:8088/6a7356574a6c6967363348764e726f/xml/LinkInfo/1/5/1190000600";   
   HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();     
   BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));      
   String temp;     
   while((temp = br.readLine()) !=null) { 
   name = temp.split("road_name")[1].split("\";")[0]; 
   st = temp.split("st_node_nm")[1].split("\";")[0]; 
   ed = temp.split("ed_node_nm")[1].split("\";")[0]; 
   dist = temp.split("map_dist")[1].split("\";")[0];
   cd = temp.split("reg_cd")[1].split("\";")[0];    
   System.out.println(name);     
   System.out.println(st);     
   System.out.println(ed);  
   System.out.println(dist);   
   System.out.println(cd);      }     
   con.disconnect();    
   br.close();   }
}
