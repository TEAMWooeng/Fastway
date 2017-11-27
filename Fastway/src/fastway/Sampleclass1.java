package fastway;

public class Sampleclass1 {
	
	public static void main(String[] args) {
		//make linkedList cost;
		LinkedList[] cost= new LinkedList[Graph.numOfNode+1];
		for(int i = 1; i<= Graph.numOfNode; i++) {
			cost[i] = new LinkedList();
		}
		
		setList("A","C",6, cost);
		//setList("B","A",3, cost);
		//setList("A","D",3, cost);
		//setList("D","B",1, cost);
		//setList("C","D",2, cost);
		//setList("D","C",1, cost);
		//setList("E","B",4, cost);
		//setList("E","D",2, cost);
		
		//Graph g = new Graph(cost);
		//g.shortestway("A", "E");
	
		System.out.println("Program finish");
	}
	
	
	//sample
	
	private static void setList(String start, String end, int weight, LinkedList[] list) {
		System.out.println("1");
		int sidx = Graph.findNodeIdx(start);
		System.out.println(sidx);
		if(sidx == -1) return;
		
		int eidx = Graph.findNodeIdx(end);
		if(eidx == -1) return;
		System.out.println("2");
		list[sidx].Insert(Graph.nodearr.get(eidx), weight);
		System.out.println("3");
	}

}
