package fastway;

import java.util.Arrays;

public class Graph {
	private int numOfVertex;
	private LinkedList cost;
	private Node start;
	private Node end;
	private int[] distance; //store the distance
	
	public Graph() {}	//default constructor
	public Graph(LinkedList list) {
		numOfVertex = Node.numOfNode;
		cost = list;	//does it need deep copy?
		
		//set Graph completely
		
	}
	
	public void shortestway(Node start, Node end) {
		
		if(distance != null) distance = null;
		distance = new int[Node.numOfNode];
		boolean Isvisit[] = new boolean[Node.numOfNode];
		Arrays.fill(Isvisit, false);	//initialize false
		
		Isvisit[start.getIdx()] = true;
		distance[start.getIdx()] = 0; //initialize starting point 
		
		
		
		
		
		
		
	}
}
