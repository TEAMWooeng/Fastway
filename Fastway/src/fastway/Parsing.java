package fastway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


//In this class, we have to parse data and make LinkedList.
public final class Parsing {
	
	private static void parse(){
		final String target = "http://openapi.seoul.go.kr:8088/6b6e676670666c753434736d6f7076/xml/TrafficInfo/1/5/1220003800";
	    try { 
	    	HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
	    	BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
	    	String temp;
	    	while((temp = br.readLine()) !=null) {
	         
	        System.out.println(temp.split("prcs_spd")[1].split("\";")[0]);
	        System.out.println(temp.split("prcs_trv_time")[1].split("\";")[0]);
	    	}
	    	con.disconnect();
	    	br.close();
	    }catch(Exception e) {
	    	System.out.println("Error!");
	    }
	}
	
	
	
	private static LinkedList realTimeList() {
		LinkedList list = new LinkedList();
		
		//make list 
		
		return list;
	}
	
	
	private static LinkedList distanceList() { 
		LinkedList list = new LinkedList();
		
		//make distance list
		return list;
	}
	
	
	public static LinkedList final_list() {
		
		LinkedList real_List = realTimeList();
		LinkedList dist_List = distanceList();
		
		LinkedList final_list = new LinkedList();
		
		//merge realTime_List and distance_list
		return final_list;
	}

}
