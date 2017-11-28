package fastway;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


//In this class, we have to parse data and make LinkedList.
public final class Parsing {
	
	//before calling dijkstra method, have to be called 
	public static LinkedList[] parse(Graph.MODE M) {
		
		LinkedList[] speed = new LinkedList[Graph.numOfNode];
		LinkedList[] time = new LinkedList[Graph.numOfNode];
		
		//Initialize LinkedList
		if(M == Graph.MODE.SPEED) {
			for(int i = 0; i<Graph.numOfNode; i++)
				speed[i] = new LinkedList();
			time = null;
		}else if(M == Graph.MODE.TIME) {
			for(int i = 0; i<Graph.numOfNode; i++)
				time[i] = new LinkedList();
			speed = null;
		}else {
			//When an error exists
			System.out.println("Such a mode does not exist");
			System.exit(1);
		}
		
	    String[][] Name = new String[5][18];
	    int arr[]= {5100,5200,4300,4400,2900,3000,6300,6400,4500,4600,2100,2200,2000,1900,3100,3200,3300,3400};         
	    
	    
	    //start parsing
	    try {
	    	
	    	for(int i=0;i<18;i++) {
	    
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
	    	 
	    			//if you want to print 
	    			//System.out.println(Name[1][i]);
	    			//System.out.println(Name[2][i]);
	    			//System.out.println(linkId);
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
	    
	    
		}catch(Exception e) {
			System.out.println("An error occurred during parsing");
			System.exit(1);
		}
	    
	    //set List
	    if(M == Graph.MODE.SPEED) {
	    	for(int i = 0; i<18; i++)
	    		setList(Name[1][i],Name[2][i],Double.parseDouble(Name[3][i]),speed);
	    	return speed;
	    }else if(M == Graph.MODE.TIME) {
	    	for(int i = 0; i<18; i++) 
	    		setList(Name[1][i],Name[2][i],Double.parseDouble(Name[4][i]),time);
	    	return time;
	    }else {
	    	System.out.println("Such a mode does not exist");
			return null;
	    }
	    
	}
	
	
	
	
	//will be used in parse method
	private static void setList(String start, String end, double weight, LinkedList[] list) {
		
		int sidx = Graph.findNodeIdx(start);
		int eidx = Graph.findNodeIdx(end);
		
		if(sidx == -1 || eidx == -1) {
			System.out.println("there is no node info");
			return ;
		}
		
		list[sidx].Insert(new Pair(end, weight));
		
	}
	
}
