package fastway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


//In this class, we have to parse data and make LinkedList.
public final class Parsing {
	
	public static void parse(LinkedList[] speed, LinkedList[] time) throws Exception {
	
		String name;
	    String[][] Name = new String[5][7];
	    int arr[]= {600,700,800,1300,1400,1500,1600};         
	    for(int i=0;i<7;i++) {
	  
	     String st,ed,dist,cd,x,y;
	     //start, end, distance,
	    
	    
	     int linkId=1190000000+arr[i];
	     
	     String url = "http://openapi.seoul.go.kr:8088/6a7356574a6c6967363348764e726f/xml/LinkInfo/1/5/";
	     String totalUrl=url+linkId;
	     
	     String target = totalUrl;
	     HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
	     BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
	     String temp;
	     
	     while((temp = br.readLine()) !=null) {
	        
	      Name[0][i] = temp.split("road_name>")[1].split("<")[0];
	      Name[1][i] = temp.split("st_node_nm>")[1].split("<")[0];
	      Name[2][i] = temp.split("ed_node_nm>")[1].split("<")[0];
	     
	     }
	     
	     
	     con.disconnect();
	     br.close();
	     //Location End
	      
	      
	     linkId=1190000000+arr[i];
	      
	     url = "http://openapi.seoul.go.kr:8088/6b6e676670666c753434736d6f7076/xml/TrafficInfo/1/5/";
	     totalUrl=url+linkId;
	      
	     String target1 = totalUrl;
	     HttpURLConnection con1 = (HttpURLConnection) new URL(target1).openConnection();
	     BufferedReader br1 = new BufferedReader(new InputStreamReader(con1.getInputStream(), "UTF-8"));
	     String temp1;
	     
	     while((temp1 = br1.readLine()) !=null) {
	         
	    	 Name[3][i] = temp1.split("<prcs_spd>")[1].split("<")[0];
	    	 Name[4][i] = temp1.split("<prcs_trv_time>")[1].split("<")[0];
	          
	     }
	     con.disconnect();
	     br.close(); 
	     //Speed and time
	     
	   }//for구문 끝나는부분
	    //store Name
	    
	    
	    for(int i=1;i<2;i++) {
	       /*
	    System.out.println(Name[0][i]);
	    System.out.println(Name[1][i]);
	    System.out.println(Name[2][i]);
	    System.out.println(Name[3][i]);
	    System.out.println(Name[4][i]);
	    */
	     
	    	setList(Name[1][i],Name[2][i],Integer.parseInt(Name[3][i]),speed);
	    	setList(Name[1][i],Name[2][i],Integer.parseInt(Name[4][i]),time);
	    	
	   }
		
	}


	
	//will be used in parse method
	private static void setList(String start, String end, int weight, LinkedList[] list) {
		
		int sidx = Graph.findNodeIdx(start);
		int eidx = -1;
		int num =0;
		while(Graph.nodearr.size()>num+1) {
			
			if(Graph.nodearr.get(num).getLName().equals(end)) {
				eidx = num;
				break;
			}
			num++;
		}
		
		if(sidx == -1 || eidx == -1) {
			System.out.println("Error!");
			return ;
		}
		
		list[sidx].Insert(Graph.nodearr.get(eidx), weight);
		
	}
	
}
