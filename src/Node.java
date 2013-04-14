
public class Node <T extends Comparable<T>>{
	private T value;
	private Node <T> parent;
	private Node <T> left;
	private Node <T> right;

	
	public int getBalanceFactor(){
		int leftHeight = 0;
		int rightHeight = 0;
		if (this.left != null){
			leftHeight = this.left.getHeight();
		}
		if (this.right != null){
			rightHeight = this.right.getHeight();
		}
		return leftHeight - rightHeight;
	}
	
	
	public int getHeight(){
		int leftHeight = 0;
	    int rightHeight = 0;
	    if (this.left != null){
	    	leftHeight = this.left.getHeight()+1;
	    }
	    if (this.right != null){
	    	rightHeight = this.right.getHeight()+1;
	    }
		return Math.max(rightHeight, leftHeight);
	}
	
	public Node (T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public Node <T> getRight(){
		return this.right;
	}
	
	public Node <T> getLeft(){
		return this.left;
	}
	
	public Node <T> getParent(){
		return this.parent;
	}
	
	public void setParent(Node <T> parent){
		this.parent = parent;
	}
	
	public void setLeft(Node <T> left){
		this.left = left;
	}
	
	public void setRight(Node <T> right) {
		this.right = right;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}
