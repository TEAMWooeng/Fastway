package fastway;

public class Sampleclass1 {
	
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
		
		/*
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
		
		*/
		Graph g = new Graph(cost);
		g.shortestway("E", "A");
	
		System.out.println("Program finish");
	}
	
	
	//sample
	
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
