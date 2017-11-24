package fastway;
import java.util.*;
public class maintain {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Link> linkedlist = new LinkedList<Link>();

		Node a = new Node(0,"대전");
		Node b= new Node(1,"서울");
		Node c= new Node(2,"incheon");
		Node d= new Node(3,"busan");
		
		Link alink = new Link(a);
		linkedlist.add(alink);
		alink.Insert(b,10);
		   for(int i = 0; i<linkedlist.size();i++) {
			   linkedlist.get(i).print();
		   }
	}

}
