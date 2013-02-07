/*
 * Skiplist capable of storing INTS from MIN int to MAX int
 * Insert: log(n)
 * Find: log(n)
 * Delete: log(n)
 */

import java.util.Random;

public class SkipList {
    static int max = java.lang.Integer.MAX_VALUE;
    static int min = java.lang.Integer.MIN_VALUE;
	private Node head;
	private Node tail;
	private int height;
	private static Random rand = new Random();

	/**
	 * Creates a skiplist.
	 * @return      boolean indicating whether or not the value was found 
	 */
	SkipList() {
	  head = new Node(min);
	  tail = new Node(max);
	  head.setNext(tail);
	  height = 1;
	}
	
	/**
	 * Searches the SkipList for a specified value. 
	 * Returns true if it is found and false if it is not.
	 * @param  value  the value to find
	 * @return      boolean indicating whether or not the value was found 
	 */
	public boolean find(int value) {
	  Node cur = this.head;
	  while (cur != null && cur.getNext()!= null) {	
		if (value == cur.getNext().getValue()) {
		  return true;
		}
		else if (value > cur.getNext().getValue()) {
		  cur = cur.getNext();
		}
		else {
		  cur = cur.getDown();
		}
	  }
	  return false;
	}
	
	/**
	 * Deletes a specified value from the SkipList. 
	 * Returns true if it is deleted and false if it is not.
	 * @param  value  the value to delete
	 * @return      boolean indicating whether or not the value was deleted 
	 */
	public boolean delete(int value) {
	  Node cur = this.head;
	  boolean success = false;
	  while (cur != null && cur.getNext()!=null) {
		if (value == cur.getNext().getValue()) {
		  cur.setNext(cur.getNext().getNext());
		  cur = cur.getDown();
		  success = true;
		}
		else if (value > cur.getNext().getValue()) {
		  cur = cur.getNext();
		}
		else {
		  cur = cur.getDown();
		}
	  }
	  return success;
	}
	
	/**
	 * Inserts a specified value into the SkipList. 
	 * Returns true if it is inserted and false if it is not.
	 * @param  value  the value to insert
	 * @return      boolean indicating whether or not the value was inserted 
	 */
	public boolean insert(int value) {
	  boolean success = false;
	  int levels = 1;
	  while(rand.nextInt(2) == 1) {
		levels++;
	  }
				
	  Node newNode = new Node(value);
	  Node tmp = newNode;
	  for(int i=0; i<levels; i++){
		tmp.setDown(new Node(value));
		tmp = tmp.getDown();
	  }
		
	  //the amount the head and tail list need to be resized
	  while (levels > this.height) {
		Node newHead = new Node(min);
		Node newTail = new Node(max);
		newHead.setDown(head);
		newHead.setNext(newTail);
		newTail.setDown(tail);
		head = newHead;
		tail = newTail;
		height++;
	  }
				
	  Node cur = head;
	  int heightLeft = height;
		
	  while (cur!= null && cur.getNext() !=null) {			
		if (value == cur.getNext().getValue()) {				
		  return false;
		}
		else if (value < cur.getNext().getValue() && levels >= heightLeft) {
		  Node tmp2 = cur.getNext();
		  cur.setNext(newNode);
		  newNode.setNext(tmp2);
		  cur = cur.getDown();
		  newNode = newNode.getDown();
		  heightLeft--;
		  success = true;
		}
		else if (value <cur.getNext().getValue()){
		  heightLeft--;
		  cur = cur.getDown();
		}
		else if (value > cur.getNext().getValue()){
		  cur = cur.getNext();
		}
	  }
	  return success;
	}

	/**
	 * Prints the SkipList. 
	 * @param  	
	 * @return      
	 */
	public void print() {
		Node cur = this.head;
		while (cur!=null) {
			Node cur2 = cur;
			while (cur2!=null) {
				System.out.print(cur2.getValue() + " -> ");
				cur2 = cur2.getNext();
			}
			System.out.print("\n");
			cur = cur.getDown();
		}
	}
}
