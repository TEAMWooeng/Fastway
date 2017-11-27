package fastway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


//In this class, we have to parse data and make LinkedList.
public final class Parsing {
	
	public static void parse(LinkedList[] speed, LinkedList[] time){
		
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
