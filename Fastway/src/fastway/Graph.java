package fastway;

import java.util.Arrays;

public class Graph {
	
	//They have different PriorityQueue
	public enum MODE{SPEED, TIME};
	public static final int numOfNode = 39; 	//#of node that will be used.
	private static int numofstage;
	// node example --> never changed.
	public static final java.util.LinkedList<String> Nodearr 
								= new java.util.LinkedList<String>() {{
									
									 add("������");
							         add("�е���");
							         add("���＼��");
							         add("����Ÿ����Ÿ�");
							         add("������");
							         add("�溹����Ʈ");
							         add("�︪����");
							         add("��������Ʈ");
							         add("�ڿ���");
							         add("������");
							         add("�������");
							         add("���￪");
							         add("���׻�ȣ��");
							         add("������");
							         add("�����ڻ�Ÿ�");
							         add("�Ｚ��");
							         add("����������");
							         add("�������������");
							         add("�켺����Ʈ");
							         add("�����ʱ�");
							         add("�����＼����");
							         add("����������Ʈ");
							         add("�����ʱ�");
							         add("��ġ��Ÿ�");
							         add("�ֹ���");
							         add("����Ÿ�");
							         add("�θ��������Ա�");
							         add("����1���ֹμ���");
							         add("�����������");
							         add("��Ƽ��");
							         add("��������Ʈ�Ա�");
							         add("��ġ���켺����Ʈ");
							         add("���翪");
							         add("������ȭ��");
							         add("�ź���");
							         add("�ź��ͳ�");
							         add("���");
							         add("��ġ��");
							         add("�п��￪");
			
	}};
	
	
	public static final String[][] Latlong = {
			//please input Latlong here
			{"������","37.511069","127.021361"},
			{"�е���","37.513935","127.030729"},
			{"���＼��","37.515358","127.035354"},
			{"����Ÿ����Ÿ�","37.504439","127.024511"},
			{"������","37.507273","127.033868"},
			{"�溹����Ʈ","37.508666","127.038516"},
			{"�︪����","37.510252","127.043863"}, 
			{"��������Ʈ","37.513003","127.053263"}, 
			{"�ڿ���","37.514211","127.060213"},
			{"������","37.497930","127.027617"},
			{"�������","37.498969","127.031021"},
			{"���￪","37.500759","127.036904"},
			{"���׻�ȣ��","37.502605","127.042758"}, 
			{"������","37.504477","127.049011"}, 
			{"�����ڻ�Ÿ�","37.506847","127.056626"},
			{"�Ｚ��","37.508875","127.063146"},
			{"����������","37.509940","127.067372"},
			{"�������������","37.507082","127.067512"},
			{"�켺����Ʈ","37.492981","127.029952"},
			{"�����ʱ�","37.494045","127.033410"},
			{"�����＼����","37.495830","127.039234"},
			{"����������Ʈ","37.498458","127.044679"},
			{"�����ʱ�","37.500531","127.050840"},
			{"��ġ��Ÿ�","37.503282","127.058600"}, 
			{"�ֹ���","37.505212","127.065065"},
			{"����Ÿ�","37.489539","127.031611"}, 
			{"�θ��������Ա�","37.491110","127.036746"},
			{"����1���ֹμ���","37.492340","127.040883"},
			{"�����������","37.494187","127.046703"},
			{"��Ƽ��","37.496353","127.052869"}, 
			{"���̾���Ʈ�Ա�","37.498908","127.060881"},
			{"��ġ���켺����Ʈ","37.500989","127.067439"},
			{"���翪","37.484522","127.034060"},
			{"������ȭ��","37.485563","127.041351"},
			{"�ź���","37.486980","127.046848"},
			{"�ź��ͳ�","37.488371","127.049855"},
			{"���","37.490877","127.055378"},
			{"��ġ��","37.494463","127.063190"},
			{"�п��￪","37.496495","127.069863"}
	};
									
	public static LinkedList[] cost;	//store final weight 
	private static double[] distance;   //store the distance(find fastest way)
	private static String[] previous;
	
	//constructor
	public Graph() {
		numofstage = 0;
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
	public void shortestway(MODE m, String s, String e) {
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
		
		numofstage = 0; //store # of stage
		showShortestPath(sidx, eidx, previous);	//show the root on console
		
		String[][] latlong = new String[numofstage][3];	// make string -> html argument
		
		int cnt = 0;
		int idx = eidx;
		
		while(true) {
			
			latlong[cnt][0] = "'"+Latlong[idx][0]+"'";
			latlong[cnt][1] = Latlong[idx][1];
			latlong[cnt][2] = Latlong[idx][2];
		
			if(previous[idx].equals(""))
				break;
			cnt++;
			idx = findNodeIdx(previous[idx]);
		}
		
		System.out.println();
		
		ShowMap.showload(latlong);
	}
	
	//show the root
	private static void showShortestPath(int sidx, int eidx, String[] previous) {
		
		//print path
		if(sidx == eidx && previous[sidx].equals("")) {
			System.out.print(Nodearr.get(sidx));
			numofstage++;
			return;
		}else {
			showShortestPath(sidx, Graph.findNodeIdx(previous[eidx]), previous);
			System.out.print("-"+Nodearr.get(eidx));
			numofstage++;
		}
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
