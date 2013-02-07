/**
 * MinHeap capable of storing INTS from MIN int to MAX int
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
   private MinHeapNode head;
	
	/**
	 * Prints the MinHeap
	 * @param  
	 * @return       
	 */
	public void print(){
	  printRecursion(this.head, 0);	
	  System.out.print("\n");
	}
	private void printRecursion(MinHeapNode cur, int level){
		System.out.print(cur.getValue() + "(");
		MinHeapNode tmp = cur;
		while (tmp.getParent()!=null){
			tmp = tmp.getParent();
			System.out.print(tmp.getValue() + " ");
		}
		System.out.print(") ");
		if (cur.getLeft() != null){
		  printRecursion(cur.getLeft(), level+1);
		}
		if (cur.getRight() != null){
		  printRecursion(cur.getRight(), level+1);
		}
	}
	
	/**
	 * Inserts a new value into the MinHeap
	 * Returns true if the insert is successful
	 * @param  value  the value to insert
	 * @return      boolean indicating whether or not the insert was successful 
	 */
	boolean push(int value){
		boolean success = false;
		MinHeapNode newNode = new MinHeapNode(value);
		
		if (this.head == null) {
			this.head = newNode;
			this.head.setNumOfDesc(0);
			success = true;
		}
		else {
			MinHeapNode cur = head;
			MinHeapNode left = cur.getLeft();
			MinHeapNode right = cur.getRight();
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
				newNode = newNode.getParent();
			}
			
			success = true;
		}
		return success;
	}
	
	/**
	 * Returns the min MinHeap
	 * @param  
	 * @return		int representing the minimum value       
	 */
	public int top(){
		return this.head.getValue();
	}
}
