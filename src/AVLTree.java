
public class AVLTree <T extends Comparable<T>>{
	private Node<T> head;
	
	
	/**
	 * searches the tree for a value 
	 * takes O(log(n))
	 * @param target value to find
	 * @return boolean indicating whether the target was found
	 */
	public boolean search(T target) {
		Node<T> cur = head;
		while (cur != null){
			int c = target.compareTo(cur.getValue());
			if (c == 0){
				return true;
			}
			else if(c < 0) {
				cur = cur.getLeft();
			}
			else {
				cur = cur.getRight();
			}
		}
		return false;
	}
	
	/**
	 * inserts a value into the tree
	 * takes O(log(n))
	 * @param value
	 */
	public void insert(T value){
		if (this.head == null) {
			this.head = new Node<T>(value);
		}		
		insertRecurse(value, head);
	}
	
	private void insertRecurse(T value, Node<T> cur){
		int c = value.compareTo(cur.getValue());
		if (c == 0) {
			return;
		}
		if (c < 0) {
			if (cur.getLeft() == null) {
				Node<T>newNode = new Node<T>(value);
				newNode.setParent(cur);
				cur.setLeft(newNode);
				balance(cur);
			}
			else {
				insertRecurse(value, cur.getLeft());
			}
		}
		else if (c > 0) {
			if (cur.getRight() == null) {
				Node<T>newNode = new Node<T>(value);
				newNode.setParent(cur);
				cur.setRight(newNode);
				balance(cur);
			}
			else {
				insertRecurse(value, cur.getRight());
			}
		}
	}
	
	
	/*public void insert(T value) {
		if (this.head == null) {
			this.head = new Node<T>(value);
		}
		else {
			Node<T> cur = head;
			Node<T> prev = cur;
			String child = "left";
			while (cur != null){
				prev = cur;
				int c = value.compareTo(cur.getValue());
				if (c == 0){
					//don't want to insert the same value twice
					return;
				}
				else if(c < 0) {
					cur = cur.getLeft();
					child = "left";
				}
				else {
					cur = cur.getRight();
					child = "right";
				}
			}
			Node<T>newNode = new Node<T>(value);
			newNode.setParent(prev);
			if (child == "left") {
				prev.setLeft(newNode);
			}
			else {
				prev.setRight(newNode);
			}
			
			//after inserting we have to go through all of the new node's 
			//ancestors and make sure the AVL tree property is upheld
			balance(cur);
		}
	}*/
	
	public void balance(Node<T> node){
		/*
		 * The balance factor is calculated as follows: balanceFactor = height(left-subtree) - height(right-subtree). 
		 * For each node checked, if the balance factor remains −1, 0, or +1 then no rotations are necessary. 
		 * However, if balance factor becomes less than -1 or greater than +1, the subtree rooted at this node is unbalanced. 
		 * If insertions are performed serially, after each insertion, at most one of the following cases needs to be resolved 
		 * to restore the entire tree to the rules of AVL.
		 */
		if(node != null){
			System.out.println("Node Value: " + node.getValue() + " factor: "+ node.getBalanceFactor());
			balance(node.getParent());
		}
	}
	
	/**
	 * deletes a value from the tree
	 * takes O(log(n))
	 * @param value to delete
	 */
	public void delete(T value) {
	//If the node is a leaf or has only one child, remove it. 
	//Otherwise, replace it with either the largest in its left sub tree (in order predecessor) 
	//or the smallest in its right sub tree (in order successor), and remove that node. 
	//The node that was found as a replacement has at most one sub tree. 
	//After deletion, retrace the path back up the tree (parent of the replacement) to the root, adjusting the balance factors as needed.
	}
	
	
	
	/**
	 * prints the tree out
	 * takes O(n)
	 */
	public void print() {
		printHelper(this.head, 0);
	}
	
	private void printHelper(Node<T> cur, int depth){
		System.out.println("value: " + cur.getValue() + " depth: " + depth);
		if(cur.getLeft()!=null){
			printHelper(cur.getLeft(), depth+1);
		}
		if(cur.getRight()!=null){
			printHelper(cur.getRight(), depth+1);
		}
	}
}
