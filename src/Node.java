
public class Node <T extends Comparable<T>>{
	private T value;
	private Node <T> parent;
	private Node <T> left;
	private Node <T> right;
	private int leftHeight;
	private int rightHeight;
	
	public int getLeftHeight(){
		return this.leftHeight;
	}
	
	public int getRightHeight(){
		return this.rightHeight;
	}
	
	public void setLeftHeight(int height){
		this.leftHeight = height;
	}
	
	public void setRightHeight(int height){
		this.rightHeight = height;
	}
	
	public Node (T value) {
		this.value = value;
		this.leftHeight = 0;
		this.rightHeight = 0;
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
