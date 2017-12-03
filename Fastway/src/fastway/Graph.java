package fastway;

import java.util.Arrays;

public class Graph {
	
	//They have different PriorityQueue
	public enum MODE{SPEED, TIME};
	public static final int numOfNode = 39; 	//#of node that will be used.
	
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
			{"������","37.511206","127.02172799999994"},
			{"�е���","37.5139949","127.03082979999999"},
			{"���＼��","37.518375","127.03440980000005"},
			{"����Ÿ����Ÿ�","37.5044599","127.02449449999994"},
			{"������","37.5068632","127.03368780000005"},
			{"�溹����Ʈ","37.5095151","127.03902070000004"},
			{"�︪����","37.5101817","127.04265929999997"}, 
			{"��������Ʈ","37.512265","127.05179720000001"}, 
			{"�ڿ���","7.5130619","127.05864429999997"},
			{"������","37.49794199999999","127.02762099999995"},
			{"�������","37.5019603","127.03024400000004"},
			{"���￪","37.4999072","127.0373932"},
			{"���׻�ȣ��","37.503121","127.04153700000006"}, 
			{"������","37.504479","127.04894100000001"}, 
			{"�����ڻ�Ÿ�","37.5068213","127.05665799999997"},
			{"�Ｚ��"," 37.5139848","127.05652069999996"},
			{"����������","37.5094352","127.06695779999995"},
			{"�������������","37.5084665","127.06742600000007"},
			{"�켺����Ʈ","37.5216804","127.04682520000006"},
			{"�����ʱ�","37.4927011","127.03275039999994"},
			{"�����＼����","37.4982941","127.03007750000006"},
			{"����������Ʈ","37.5010995","127.04410380000001"},
			{"�����ʱ�","37.5011444","127.04905050000002"},
			{"��ġ��Ÿ�","37.503044","127.05860239999992"}, 
			{"�ֹ���","37.5051272","127.06215750000001"},
			{"����Ÿ�","37.490173","127.03280819999997"}, 
			{"�θ��������Ա�","37.49794199999999","127.02762099999995"},
			{"����1���ֹμ���","37.4882675","127.03893549999998"},
			{"�����������","37.4927454","127.04631519999998"},
			{"��Ƽ��","37.496208","127.05288300000006"}, 
			{"���̾���Ʈ�Ա�","37.4988224","127.06085229999996"},
			{"��ġ���켺����Ʈ","37.5002668","127.06926810000004"},
			{"���翪","37.484102","127.03436899999997"},
			{"������ȭ��","37.485659","127.04074200000002"},
			{"�ź���","37.4898434","127.04381360000002"},
			{"�ź��ͳ�","37.49071199999999","127.04849260000003"},
			{"���","37.4936746","127.05074420000005"},
			{"��ġ��","37.494569","127.063446"},
			{"�п��￪","37.496683","127.07054900000003"}
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
