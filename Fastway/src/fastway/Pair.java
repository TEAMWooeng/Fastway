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

