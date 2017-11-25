package fastway;
import java.util.*;

public class LinkedList {
	private Node head;
	private int size;
	public java.util.LinkedList<Pair> linkedlist = new java.util.LinkedList<Pair>();
	
	//initialize
	public LinkedList() { 	//default constructor
		head = null;
		size = 0;
	}
	
	public LinkedList(Node start) { //constructor with start node
		head  = start;
		size = 1;
	}
	
	public void Insert(Node n, int weight) {
		Pair newPair = new Pair(n, weight);
		linkedlist.add(newPair);
		size++;
	}
	
	public void delete(Pair x) {	//will not be used
		linkedlist.remove();
	}

	public void print() {  //print all element of list
		head.showNInfo();
		System.out.print(":");
		for(int i = 0; i<linkedlist.size(); i++) {
			linkedlist.get(i).showPair();
		}
	}
	
	public boolean search(Pair p) { //search node
		//if there is element in the list, put to p , and return true
		//else, return false
		
		return true;
	}
}
