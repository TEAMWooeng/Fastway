package fastway;

public class Main {
	
	
	public static void main(String[] args) {
		
		Graph g = new Graph();
		g.shortestway(Graph.MODE.SPEED, "노들역", "상도역");
		
	}

	

	private static void setList(String start, String end, int weight, LinkedList[] list) {
		
		int sidx = Graph.findNodeIdx(start);
		int eidx = Graph.findNodeIdx(end);
		
		if(sidx == -1 || eidx == -1) {
			System.out.println("Error~!");
			return ;
		}
		
		list[sidx].Insert(new Pair(end, weight));
		
	}
}
