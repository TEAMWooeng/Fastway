package fastway;

public class Sampleclass1 {
	
	
	public static void main(String[] args) {
		LinkedList[] speed = new LinkedList[Graph.numOfNode];
		LinkedList[] time  = new LinkedList[Graph.numOfNode];
		for(int i = 0; i<=Graph.numOfNode;i++) {
			speed[i] = new LinkedList();
			time[i] = new LinkedList();
		}
		
		try {
			Parsing.parse(speed, time);
		}catch(Exception e) {
			System.out.println("Error!");
			return;
		}
		
		speed[0].print();
		time[0].print();
		
		speed[1].print();
		time[1].print();
		
		
	}
	
	/*
	public static void main(String[] args) {
		
		
		//make linkedList cost;
		LinkedList[] cost= new LinkedList[Graph.numOfNode+1];
		for(int i = 1; i<= Graph.numOfNode; i++) {
			cost[i] = new LinkedList();
		}
		
		setList("A","C",6, cost);
		setList("B","A",3, cost);
		setList("A","D",3, cost);
		setList("D","B",1, cost);
		setList("C","D",2, cost);
		setList("D","C",1, cost);
		setList("E","B",4, cost);
		setList("E","D",2, cost);
		
		
		PriorityQueue pq = new PriorityQueue();
		Pair tmpPair = new Pair();
		pq.PEnqueue(new Pair(Graph.nodearr.get(4),0));
		
		tmpPair = pq.PDequeue();
		
		pq.PEnqueue(new Pair(Graph.nodearr.get(1), 4));
		pq.PEnqueue(new Pair(Graph.nodearr.get(3), 2));
		tmpPair = pq.PDequeue();
		pq.PEnqueue(new Pair(Graph.nodearr.get(1),3));
		pq.PEnqueue(new Pair(Graph.nodearr.get(2),3));
		
		tmpPair = pq.PDequeue();
		tmpPair = pq.PDequeue();
		pq.PEnqueue(new Pair(Graph.nodearr.get(0),6));
		
		pq.showQueue();
		
		
		
		Graph g = new Graph(cost);
		g.shortestway("E", "A");
	
		System.out.println("Program finish");
	}
	
	*/
	//sample
	
	

}
