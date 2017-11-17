package fastway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Parsing {
	public static void parse_(){
		String target = "http://openapi.seoul.go.kr:8088/6b6e676670666c753434736d6f7076/xml/TrafficInfo/1/5/1220003800";
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
}
