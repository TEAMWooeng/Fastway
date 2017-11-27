package fastway;


class Pair{   
   
   private String location;
   private int weight;
   
   public Pair() {
	   location = "empty";
	   weight = 0;
   } //default constructor
   
   public Pair(String lname, int weigth) {
	   location = lname;
	   this.weight = weigth;
   }
   
   public int getWeigth() {
      return this.weight;
   }
   
   public String getNode() {
	   return location;
   }
   public void showPair() {
      System.out.println("location: "+location+" , weight : "+weight);
   }
   
   public void setPair(String lname , int weight) {
	   location = lname;
	   this.weight = weight;
   }
}








/* remove node class
class Node {
   
   //static final int numOfNode = 10;   //setting #of Nodes(const variable) --> move to main class
   private int idxnum;   //index in array
   //private Node next;
   private String location_name;
   
   public Node() {} //default constructor
   
   public Node(int idxnum){ //constructor
      this.idxnum = idxnum;
      this.location_name = "location : "+this.idxnum;
   }
   
   public Node(int n, String lname) {//constructor
      this.idxnum = n;
      this.location_name = lname;
   }

   public void showNInfo() { //showing information of node.
      System.out.println("location name: "+ this.location_name);
   }
   
   public String getLName() {//get location name
      return this.location_name;
   }
   
   public void setLname(String location_name) {
	   this.location_name = location_name;
   }
   
   public int getIdx() {//get index in array
      return this.idxnum;
   }
   
   public void setIdx(int idxnum) {
	   this.idxnum = idxnum;
   }
   public void setNode(int idxnum, String lname) {
	   this.idxnum = idxnum;
	   this.location_name = lname;
			  
   }
}	


*/