
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
	
	private void balance(Node<T> node){
		/*
		 * The balance factor is calculated as follows: balanceFactor = height(left-subtree) - height(right-subtree). 
		 * For each node checked, if the balance factor remains −1, 0, or +1 then no rotations are necessary. 
		 * However, if balance factor becomes less than -1 or greater than +1, the subtree rooted at this node is unbalanced. 
		 * If insertions are performed serially, after each insertion, at most one of the following cases needs to be resolved 
		 * to restore the entire tree to the rules of AVL.
		 */
		if(node != null){
			int balance = node.getBalanceFactor();
			if(balance == -2) {
				//if the balance factor of P is -2 then the right subtree outweighs the left subtree of the given node, 
				//and the balance factor of the right child (R) must be checked. 
				//The left rotation with P as the root is necessary.
				int rightChildBalance = node.getRight().getBalanceFactor();
				if (rightChildBalance == -1) {
					//If the balance factor of R is -1 (or in case of deletion also 0), 
					//a single left rotation (with P as the root) is needed (Right-Right case).
					leftRotate(node);
				}
				else if (rightChildBalance == 1) {
					//If the balance factor of R is +1, two different rotations are needed. 
					//The first rotation is a right rotation with R as the root. 
					//The second is a left rotation with P as the root (Right-Left case).
					rightRotate(node.getRight());
					leftRotate(node);
				}
				else if (rightChildBalance == 0) {
					//In addition to the balancing described above for insertions, 
					//if the balance factor for the tree is 2 and that of the left subtree is 0, 
					//a right rotation must be performed on P. The mirror of this case is also necessary.
					rightRotate(node);
				}
			}
			else if(balance == 2) {
				//If the balance factor of P is 2, then the left subtree outweighs the right subtree of the given node, 
				//and the balance factor of the left child (L) must be checked. 
				//The right rotation with P as the root is necessary.
				int leftChildBalance = node.getLeft().getBalanceFactor();
				if (leftChildBalance == -1) {
					//If the balance factor of L is -1, two different rotations are needed. 
					//The first rotation is a left rotation with L as the root. 
					//The second is a right rotation with P as the root (Left-Right case).
					leftRotate(node.getLeft());
					rightRotate(node);
				}
				else if (leftChildBalance == 1) {
					//If the balance factor of L is +1 (or in case of deletion also 0), 
					//a single right rotation (with P as the root) is needed (Left-Left case).
					rightRotate(node);
				}
				else if (leftChildBalance == 0) {
					//In addition to the balancing described above for insertions, 
					//if the balance factor for the tree is 2 and that of the left subtree is 0, 
					//a right rotation must be performed on P. The mirror of this case is also necessary.
					System.out.println("fda");
					leftRotate(node.getLeft());
				}
			}
			balance(node.getParent());
		}
	}
	
	private void rightRotate(Node <T> root){
		//left child = > root
		//root = > right child
		//left, left child = > left child
		//left, right child => right, left child

		
		if (root == this.head) {
			this.head = root.getLeft();
			this.head.setParent(null);
			this.head.setRight(root);
			root.setParent(this.head);
		}
		else if (root.isLeftChild()) {
			root.getParent().setLeft(root.getLeft());
			root.getLeft().setParent(root.getParent());
			root.getLeft().setRight(root);
			root.setParent(root.getLeft());
		}
		else {
			root.getParent().setRight(root.getLeft());
			root.getLeft().setParent(root.getParent());
			root.getLeft().setRight(root);
			root.setParent(root.getLeft());
		}

		root.setRight(null);
		root.setLeft(null);
	}
	
	private void leftRotate(Node <T> root){
		//right child = > root
		//root = > left child
		//right, right child = > right child
		//right, left child => left, right child
		
		if (root == this.head) {
			this.head = root.getRight();
			this.head.setParent(null);
			this.head.setLeft(root);
			root.setParent(this.head);
		}
		else if (root.isRightChild()) {
			root.getParent().setRight(root.getRight());
			root.getRight().setParent(root.getParent());
			root.getRight().setLeft(root);
			root.setParent(root.getRight());
		}
		else {
			root.getParent().setLeft(root.getRight());
			root.getRight().setParent(root.getParent());
			root.getRight().setLeft(root);
			root.setParent(root.getRight());
		}
		root.setLeft(null);
		root.setRight(null);
	}

	
	/**
	 * deletes a value from the tree
	 * takes O(log(n))
	 * @param value to delete
	 */
	public void delete(T value) {
		if (this.head != null) {
			deleteRecurse(value, head);
		}
		return;
	}
	
	private void deleteRecurse(T value, Node<T> cur){
		int c = value.compareTo(cur.getValue());
		if (c == 0){
			Node<T> parent = cur.getParent();

			//If the node is a leaf or has only one child, remove it. 
			if (cur.getLeft()== null && cur.getRight() == null) {
				if(this.head == cur) {
					this.head = null;
				}
				else if (cur.isLeftChild()) {
					parent.setLeft(null);
				}
				else {
					parent.setRight(null);
				}
			}
			else if (cur.getLeft() == null){
				if(this.head == cur) {
					this.head = cur.getRight();
				}
				else if (cur.isLeftChild()) {
					parent.setLeft(cur.getRight());
				}
				else {
					parent.setRight(cur.getRight());
				}
			}
			else if (cur.getRight() == null){
				if(this.head == cur) {
					this.head = cur.getLeft();
				}
				else if (cur.isLeftChild()) {
					parent.setLeft(cur.getLeft());
				}
				else {
					parent.setRight(cur.getLeft());
				}
			}
			else {
				//Otherwise, replace it with either the largest in its left sub tree (in order predecessor) 
				//or the smallest in its right sub tree (in order successor), and remove that node. 
				Node<T> temp = cur.getLeft();
				while (temp.getRight()!=null) {
					temp = temp.getRight();
				}
				//swap the value
				System.out.println(temp.getValue());
				cur.setValue(temp.getValue());
				//delete the old node
				temp.getParent().setRight(null);
				
				
				//The node that was found as a replacement has at most one sub tree. 
				//After deletion, retrace the path back up the tree (parent of the replacement) to the root, adjusting the balance factors as needed.
			}
			balance(cur);
			return;
		}
		else if(c < 0) {
			cur = cur.getLeft();
		}
		else {
			cur = cur.getRight();
		}
		
		if(cur != null){
			deleteRecurse(value, cur);
		}
	}
	
	
	
	/**
	 * prints the tree out
	 * takes O(n)
	 */
	public void print() {
		printHelper(this.head, 0);
	}
	
	private void printHelper(Node<T> cur, int depth){
		System.out.println("value: " + cur.getValue() +" balance: " + cur.getBalanceFactor()+" depth: " + depth);
		if(cur.getLeft()!=null){
			printHelper(cur.getLeft(), depth+1);
		}
		if(cur.getRight()!=null){
			printHelper(cur.getRight(), depth+1);
		}
	}
}
