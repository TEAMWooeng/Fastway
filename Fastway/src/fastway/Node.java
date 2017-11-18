package fastway;

public class Node {
	
	static final int numOfNode = 10;	//setting #of Nodes(const variable)
	private int idxnum;	//idx in array
	private String location_name;
	private String address;
	public Node() {} //default constructor
	
	public Node(int n ){ //constructor
		this.idxnum = n;
		this.location_name = "location : "+this.idxnum;
		this.address = "address : "+this.idxnum;
	}
	
	public Node(int n, String lname, String address) {//constructor
		this.idxnum = n;
		this.location_name = lname;
		this.address = address;
	}

	public void showNInfo() { //showing information of node.
		System.out.println("location name: "+this.location_name);
		System.out.println("Address: "+ this.address);
	}
	
	public String getLName() {//get location name
		return this.location_name;
	}
	public int getIdx() {//get index in array
		return this.idxnum;
	}
	public String getAddress() {
		return this.address;
	}
	
	public static void setting(Node[] arr) { //make nodes
		
		for(int i = 1; i<numOfNode+1; i++) {
		arr[i] = new  Node(i);
		}
		
	}
}


