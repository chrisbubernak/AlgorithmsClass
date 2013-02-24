import java.util.Random;

/**
 * Priority Queue 
 * Push: O(log(n))
 * Top: O(1)
 * Pop: O(log(n))
 * Size: O(1)
 * Empty: O(1)
 */

public class PriorityQueue <T>{
   private PQNode<T> head;
   private int size = 0;
   private Random rand = new Random();
	/**
	 * Prints the PriorityQueue
	 * @param  
	 * @return       
	 */
	public void print(){
	  printRecursion(this.head);	
	  System.out.print("\n");
	  HuffmanEncoder.counter+=2;
	}
	private void printRecursion(PQNode<T> cur){
		System.out.print(cur);
		PQNode<T> tmp = cur.getParent();
		
		HuffmanEncoder.counter+=2;

		while (tmp!=null){
			System.out.print("[" +tmp.getValue() +", " + tmp.getKey()+"]");
			tmp = tmp.getParent();
			HuffmanEncoder.counter+=3;
		}
		if (cur.getLeft() != null){
		  printRecursion(cur.getLeft());
		  HuffmanEncoder.counter++;

		}
		if (cur.getRight() != null){
		  printRecursion(cur.getRight());
		  HuffmanEncoder.counter++;

		}
		HuffmanEncoder.counter+=2;

	}

	/**
	 * Inserts a new value into the Queue
	 * Returns true if the insert is successful
	 * @param  value  the priority of the letter 
	 * @param  letter  the letter to store
	 * @return      boolean indicating whether or not the insert was successful 
	 */
	public void push(int newKey, T newValue){
		PQNode<T> newNode = new PQNode<T>(newKey, newValue);
		this.size++;
		newNode.setPosition(this.size);
		HuffmanEncoder.counter+=3;

		if (this.head == null){
			this.head = newNode;
			HuffmanEncoder.counter++;

		}
		else {
			int depth = (int) Math.floor(Math.log(this.size)/Math.log(2));
			int [] path = new int[depth];
			int tmp = this.size;
			HuffmanEncoder.counter+=3;
			for (int i =path.length -1; i>-1; i--){
				tmp = (int)Math.floor(tmp/2);
				path[i] = tmp;
				HuffmanEncoder.counter+=2;
			}

			PQNode<T> cur = this.head;
			HuffmanEncoder.counter++;
			for (int i=1; i<depth; i++){
				PQNode<T> left = cur.getLeft();
				PQNode<T> right = cur.getRight();
				
				if (left.getPosition() == path[i]){
					cur = left;
					HuffmanEncoder.counter++;
				}
				else {
					cur = right;
					HuffmanEncoder.counter++;
				}
				HuffmanEncoder.counter+=3;
			}
			newNode.setParent(cur);
			HuffmanEncoder.counter++;

			if (cur.getLeft()== null){
				cur.setLeft(newNode);
				cur = cur.getLeft();
			}
			else {
				cur.setRight(newNode);
				cur = cur.getRight();
			}
			HuffmanEncoder.counter+=4;
			bubbleUp(cur);
		}
	}
	
	private void bubbleUp(PQNode<T> cur){
		while (cur.getParent()!= null){
			PQNode<T> parent = cur.getParent();
			if (cur.getKey() > parent.getKey()) {
				return;
			}
			//if there is a tie flip a coin
			else if (cur.getKey() == parent.getKey()) {
				if(rand.nextInt(2) == 1) {
					return;
				}
				HuffmanEncoder.counter++;
			}
			
			int tmpKey = cur.getKey();
			T tmpValue = cur.getValue();
			cur.setValue(parent.getValue());
			cur.setKey(parent.getKey());
			parent.setValue(tmpValue);
			parent.setKey(tmpKey);
			cur = parent;
			HuffmanEncoder.counter+=10;

		}
		return;
	}
	
	private void bubbleDown(PQNode<T> cur){
		while (cur.getLeft() != null){
			PQNode<T> left = cur.getLeft();
			PQNode<T> right = cur.getRight();
			HuffmanEncoder.counter+=2;

			if (right != null){
				if (cur.getKey() < right.getKey() && cur.getKey() < left.getKey()) {
					return;
				}
				//if there is a tie flip a coin
				else if (cur.getKey() == right.getKey() || cur.getKey() == left.getKey()) {
					if(rand.nextInt(2) == 1) {
						return;
					}
					HuffmanEncoder.counter++;

				}
				HuffmanEncoder.counter+=3;

				if (left.getKey() < cur.getKey() && left.getKey() < right.getKey()) {
					int tmpKey = cur.getKey();
					T tmpValue = cur.getValue();
					cur.setValue(left.getValue());
					cur.setKey(left.getKey());
					left.setValue(tmpValue);
					left.setKey(tmpKey);
					cur = left;
					HuffmanEncoder.counter+=7;
				}
				else {
					int tmpKey = cur.getKey();
					T tmpValue = cur.getValue();
					cur.setValue(right.getValue());
					cur.setKey(right.getKey());
					right.setValue(tmpValue);
					right.setKey(tmpKey);
					cur = right;			
					HuffmanEncoder.counter+=7;

				}
				HuffmanEncoder.counter+=2;

			}
			else{
				if (cur.getKey() < left.getKey()) {
					return;
				}
				//if there is a tie flip a coin
				else if (cur.getKey() == left.getKey()) {
					if(rand.nextInt(2) == 1) {
						return;
					}
					HuffmanEncoder.counter++;

				}
				int tmpKey = cur.getKey();
				T tmpValue = cur.getValue();
				cur.setValue(left.getValue());
				cur.setKey(left.getKey());
				left.setValue(tmpValue);
				left.setKey(tmpKey);
				cur = left;
			}
			HuffmanEncoder.counter+=9;
		}
	}
	/**
	 * Returns the min value and removes it from queue
	 * @param  
	 * @return		int representing the minimum value       
	 */
	public T pop(){
		if (this.head == null){
			return null;
		}
		PQNode <T>returnNode = new PQNode<T>(this.head);
		T returnValue = returnNode.getValue();
		
		HuffmanEncoder.counter+=3;
		HuffmanEncoder.counter++;

		if (this.size == 1){
			HuffmanEncoder.counter++;
			this.head = null;
		}
		else {
			int depth = (int) Math.floor(Math.log(this.size)/Math.log(2));
			int [] path = new int[depth];
			int tmp = this.size;
			HuffmanEncoder.counter+=3;
			for (int i =path.length -1; i>-1; i--){
				tmp = (int)Math.floor(tmp/2);
				path[i] = tmp;
				HuffmanEncoder.counter+=2;
			}

			PQNode <T>cur = this.head;
			HuffmanEncoder.counter++;

			for (int i=1; i<depth; i++){
				PQNode <T>left = cur.getLeft();
				PQNode <T>right = cur.getRight();
				if (left.getPosition() == path[i]){
					cur = left;
				}
				else {
					cur = right;
				}
				HuffmanEncoder.counter+=5;

			}
			if (cur.getRight()== null){
				this.head.setKey(cur.getLeft().getKey());
				this.head.setValue(cur.getLeft().getValue());
				cur.setLeft(null);
			}
			else {
				this.head.setKey(cur.getRight().getKey());
				this.head.setValue(cur.getRight().getValue());
				cur.setRight(null);
			}
			HuffmanEncoder.counter+=4;

			bubbleDown(this.head);
		}
		this.size--;
		HuffmanEncoder.counter++;

		return returnValue;
	}
	
	

	
	/**
	 * Returns true if the queue is empty and false if it isn't
	 * @param  
	 * @return		true if empty, otherwise false       
	 */
	public boolean empty(){
		HuffmanEncoder.counter++;

		if (this.head == null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the size of the queue
	 * @return      integer indicating the number of elements in the queue
	 */
	public int size(){
		HuffmanEncoder.counter++;

		return this.size;
	}
	
	/**
	 * Returns the min value from the priority queue
	 * @param  
	 * @return		int representing the minimum value       
	 */
	public T top(){
		HuffmanEncoder.counter++;

		return this.head.getValue();
	}
}
