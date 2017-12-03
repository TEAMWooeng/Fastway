package fastway;

import java.util.Arrays;

public class Graph {
	
	//They have different PriorityQueue
	public enum MODE{SPEED, TIME};
	public static final int numOfNode = 39; 	//#of node that will be used.
	
	// node example --> never changed.
	public static final java.util.LinkedList<String> Nodearr 
								= new java.util.LinkedList<String>() {{
									
									 add("논현역");
							         add("학동역");
							         add("서울세관");
							         add("교보타워사거리");
							         add("차병원");
							         add("경복아파트");
							         add("삼릉공원");
							         add("차관아파트");
							         add("코엑스");
							         add("강남역");
							         add("국기원앞");
							         add("역삼역");
							         add("르네상스호텔");
							         add("선릉역");
							         add("포스코사거리");
							         add("삼성역");
							         add("강남경찰서");
							         add("강남면허시험장");
							         add("우성아파트");
							         add("역삼초교");
							         add("구역삼세무서");
							         add("개나리아파트");
							         add("도성초교");
							         add("대치사거리");
							         add("휘문고교");
							         add("뱅뱅사거리");
							         add("싸리고개공원입구");
							         add("도곡1동주민센터");
							         add("영동세브란스");
							         add("한티역");
							         add("은마아파트입구");
							         add("대치동우성아파트");
							         add("양재역");
							         add("양재전화국");
							         add("매봉역");
							         add("매봉터널");
							         add("도곡역");
							         add("대치역");
							         add("학여울역");
			
	}};
	
	
	public static final String[][] Latlong = {
			//please input Latlong here
			{"논현역","37.511206","127.02172799999994"},
			{"학동역","37.5139949","127.03082979999999"},
			{"서울세관","37.518375","127.03440980000005"},
			{"교보타워사거리","37.5044599","127.02449449999994"},
			{"차병원","37.5068632","127.03368780000005"},
			{"경복아파트","37.5095151","127.03902070000004"},
			{"삼릉공원","37.5101817","127.04265929999997"}, 
			{"차관아파트","37.512265","127.05179720000001"}, 
			{"코엑스","7.5130619","127.05864429999997"},
			{"강남역","37.49794199999999","127.02762099999995"},
			{"국기원앞","37.5019603","127.03024400000004"},
			{"역삼역","37.4999072","127.0373932"},
			{"르네상스호텔","37.503121","127.04153700000006"}, 
			{"선릉역","37.504479","127.04894100000001"}, 
			{"포스코사거리","37.5068213","127.05665799999997"},
			{"삼성역"," 37.5139848","127.05652069999996"},
			{"강남경찰서","37.5094352","127.06695779999995"},
			{"강남면허시험장","37.5084665","127.06742600000007"},
			{"우성아파트","37.5216804","127.04682520000006"},
			{"역삼초교","37.4927011","127.03275039999994"},
			{"구역삼세무서","37.4982941","127.03007750000006"},
			{"개나리아파트","37.5010995","127.04410380000001"},
			{"도성초교","37.5011444","127.04905050000002"},
			{"대치사거리","37.503044","127.05860239999992"}, 
			{"휘문고교","37.5051272","127.06215750000001"},
			{"뱅뱅사거리","37.490173","127.03280819999997"}, 
			{"싸리고개공원입구","37.49794199999999","127.02762099999995"},
			{"도곡1동주민센터","37.4882675","127.03893549999998"},
			{"영동세브란스","37.4927454","127.04631519999998"},
			{"한티역","37.496208","127.05288300000006"}, 
			{"은미아파트입구","37.4988224","127.06085229999996"},
			{"대치동우성아파트","37.5002668","127.06926810000004"},
			{"양재역","37.484102","127.03436899999997"},
			{"양재전화국","37.485659","127.04074200000002"},
			{"매봉역","37.4898434","127.04381360000002"},
			{"매봉터널","37.49071199999999","127.04849260000003"},
			{"도곡역","37.4936746","127.05074420000005"},
			{"대치역","37.494569","127.063446"},
			{"학여울역","37.496683","127.07054900000003"}
	};
									
	public static LinkedList[] cost;	//store final weight 
	private static double[] distance;   //store the distance(find fastest way)
	private static String[] previous;
	
	//constructor
	public Graph() {
		cost = null; //initialize when call shortestway method	
		distance = new double[numOfNode];
		Arrays.fill(distance, 999999);	//initialize distance to infinite
		previous = new String[numOfNode];
		//initialize
		for(int i =0; i<numOfNode; i++) {
			previous[i] = null;
		}
	}
	

	
	//dijkstra algorithm
	public String[][] shortestway(MODE m, String s, String e) {
		//initialize cost variable in graph
		this.setCost(Parsing.parse(m));
		PriorityQueue pq = new PriorityQueue(m);
		
		
		int sidx = Graph.findNodeIdx(s);
		int eidx = Graph.findNodeIdx(e);
		
		//Staring node initialize
		distance[sidx] = 0;
		previous[sidx] = ""; 
		pq.PEnqueue(new Pair(s,0));
		
		//Start dijkstra algorithm
		while(!pq.HIsEmpty()) {
			Pair upperPair = pq.PDequeue();
			int upperidx = Graph.findNodeIdx(upperPair.getNode());
			
			cost[upperidx].searchInitiallize();
			Pair tmpPair = new Pair();
			while(cost[upperidx].search(tmpPair)) {
				
				int tmpidx = Graph.findNodeIdx(tmpPair.getNode());
				
				if(distance[tmpidx]>distance[upperidx]+tmpPair.getWeigth()) {
					distance[tmpidx] = distance[upperidx]+tmpPair.getWeigth();
					previous[tmpidx] = upperPair.getNode();
					pq.PEnqueue(new Pair(tmpPair.getNode(), distance[tmpidx]));	
				}
			}
			
		}
		
		String[][] latlong = showShortestPath(sidx, eidx, previous);
		System.out.println();
		return latlong;
	}
	

	private static String[][] showShortestPath(int sidx, int eidx, String[] previous) {
		String[][] latlong = new String[previous.length][3];
		
		
		//store info at latlong
		int idx = eidx;
		int cnt = 0;		
		while(true) {
			latlong[cnt][0] = Latlong[idx][0];
			latlong[cnt][1] = Latlong[idx][1];
			latlong[cnt][2] = Latlong[idx][2];
			
			System.out.println(latlong[cnt][0]);
			if(previous[idx].equals(""))
				break;
			cnt++;
			idx = findNodeIdx(previous[idx]);
		}
		
		//print path
		if(sidx == eidx && previous[sidx].equals("")) {
			System.out.print(Nodearr.get(sidx));
			
			return latlong;
		}else {
			showShortestPath(sidx, Graph.findNodeIdx(previous[eidx]), previous);
			System.out.print("-"+Nodearr.get(eidx));
		}
		
		return latlong;
	}
	
	private void setCost(LinkedList[] list) {
		cost = list;
	}
	
	//if there is same node in node array, return index of that node. else, return -1
	public static int findNodeIdx(String str) {
		int num = 0;
		while(Nodearr.size()>num) {
			if(Nodearr.get(num).equals(str)) {
				return num;
			}
			num++;
		}
		return -1;
	}
}
