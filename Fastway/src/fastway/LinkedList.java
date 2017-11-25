package fastway;
import java.util.*;

public class LinkedList {
	private Node head;
	private int size;
	private java.util.LinkedList<Pair> linkedlist = new java.util.LinkedList<Pair>();
	
	public LinkedList() { 	//default constructor
		head = null;
		size = 0;
	}
	
	public LinkedList(Node start) {
		head  = start;
		size = 0;
	}
	
	public void Insert(Node n, int weight) {
		Pair newPair = new Pair(n, weight);
		linkedlist.add(newPair);
		size++;
	}
	
	public void delete(Pair x) {	//will not be used
		linkedlist.remove();
	}

	public void print() { //print all element of list
		head.showNInfo();
		System.out.print(":");
		for(int i = 0; i<linkedlist.size(); i++) {
			linkedlist.get(i).showPair();
		}
	}
}
