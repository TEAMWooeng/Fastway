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
		
		showShortestPath(sidx, eidx, previous);
		System.out.println();
	}
	

	private static void showShortestPath(int sidx, int eidx, String[] previous) {
		
		if(sidx == eidx && previous[sidx].equals("")) {
			System.out.print(Nodearr.get(sidx));
			return;
		}else {
			showShortestPath(sidx, Graph.findNodeIdx(previous[eidx]), previous);
			System.out.print("-"+Nodearr.get(eidx));
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
