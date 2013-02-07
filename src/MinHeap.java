/**
 * PriorityQueue capable of storing INTS from MIN int to MAX int
 * Insert: O(log(n))
 * GetMin: O(1)
 * Delete: O(log(n))
 * 
 * Push: O(log(n))
 * Top: O(1)
 * Pop: O(1)
 * Size: O(1)
 * Empty: O(1)
 */

public class MinHeap {
   private Node head;
   static private int printCounter = 0;
   
	MinHeap() {
		
	}

	
	/**
	 * Prints the PriorityQueue
	 * @param  
	 * @return       
	 */
	void print2(){
		Node cur = head;
		Node left = cur.getLeft();
		Node right = cur.getRight();
		System.out.print(cur.getValue());
		int maxLevel = 1;
		for (int i =0; i<maxLevel; i++){
		  int level = 0;
		  System.out.print("\n");
		  while(level < i && (left != null || right != null)) {
		    if (left.getNumOfDesc() > right.getNumOfDesc()) {
		  	    cur = cur.getRight();
		    }
		    else {
			    cur = cur.getLeft();
		    }
		    System.out.print(cur.getValue() + " ");
		    left = cur.getLeft();
		    right = cur.getRight();
		    level++;
		  }		
		}
	}
	
	void print(){
	  p(this.head, 0);	
	  System.out.print("\n");
	}
	
	void p(Node cur, int level){
		System.out.print(cur.getValue() + "(" + level + ") ");
		if (cur.getLeft() != null){
		  p(cur.getLeft(), level+1);
		}
		if (cur.getRight() != null){
		  p(cur.getRight(), level+1);
		}
	}
	
	/**
	 * Inserts a new value into the PriorityQueue
	 * Returns true if the insert is successful
	 * @param  value  the value to insert
	 * @return      boolean indicating whether or not the insert was successful 
	 */
	boolean push(int value){
		boolean success = false;
		Node newNode = new Node(value);
		
		if (this.head == null) {
			this.head = newNode;
			this.head.setNumOfDesc(0);
			success = true;
		}
		else {
			Node cur = head;
			Node left = cur.getLeft();
			Node right = cur.getRight();
			while(left != null && right != null ) {
			  if (left.getNumOfDesc() > right.getNumOfDesc()) {
				  cur = cur.getRight();
			  }
			  else {
				  cur = cur.getLeft();
			  }
			  left = cur.getLeft();
			  right = cur.getRight();
			}
			if (left == null) {
			  cur.setLeft(newNode);
			}
			else {
			  cur.setRight(newNode);	
			}
			newNode.setParent(cur);
			//bubble up the min value
			while(newNode.getParent() != null && newNode.getValue() < newNode.getParent().getValue()) {
				int tmp = newNode.getValue();
				newNode.setValue(newNode.getParent().getValue());
				newNode.getParent().setValue(tmp);
			}
			
			success = true;
		}
		return success;
	}
	


}
