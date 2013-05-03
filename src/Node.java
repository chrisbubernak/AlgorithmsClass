
public class Node <T extends Comparable<T>>{
	private T value;
	private Node <T> parent;
	private Node <T> left;
	private Node <T> right;
	public int leftHeight = 0;
	public int rightHeight = 0;
	
	public int getBalanceFactor(){
		AVLTree.opCount+=5;
		int leftHeight = 0;
		int rightHeight = 0;
		if (this.left != null){
			leftHeight = this.left.getHeight()+1;
		}
		if (this.right != null){
			rightHeight = this.right.getHeight()+1;
		}
		return leftHeight - rightHeight;
	}
	
	
	public int getHeight(){
		AVLTree.opCount++;
		return Math.max(rightHeight, leftHeight);
	}
	
	public Node (T value) {
		AVLTree.opCount++;
		this.value = value;
	}
	
	public T getValue() {
		AVLTree.opCount++;
		return this.value;
	}
	
	public Node <T> getRight(){
		AVLTree.opCount++;
		return this.right;
	}
	
	public Node <T> getLeft(){
		AVLTree.opCount++;
		return this.left;
	}
	
	public Node <T> getParent(){
		AVLTree.opCount++;
		return this.parent;
	}
	
	public void setParent(Node <T> parent){
		AVLTree.opCount++;
		this.parent = parent;
	}
	
	public void setLeft(Node <T> left){
		AVLTree.opCount+=3;
		this.left = left;
		
		//is this right?
		if (left == null) {
			this.leftHeight = 0;
		}
		else {
			this.leftHeight = Math.max(left.leftHeight, left.rightHeight) +1;
		}
	}
	
	public void setRight(Node <T> right) {
		AVLTree.opCount+=3;
		this.right = right;
		
		if (right == null) {
			this.rightHeight = 0;
		}
		else {
			this.rightHeight = Math.max(right.leftHeight, right.rightHeight) +1;
		}
	}
	
	public void setValue(T value) {
		AVLTree.opCount++;
		this.value = value;
	}
	
	public boolean isRightChild(){
		AVLTree.opCount++;
		return this == this.getParent().getRight();
	}
	
	public boolean isLeftChild(){
		AVLTree.opCount++;
		return this == this.getParent().getLeft();
	}
}
