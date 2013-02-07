
public class Node {
	protected Node left;
	protected Node right;
	protected int value;

	Node(int value) {
		this.value = value;
	}
	
	public void setNext(Node next) {
		this.left = next;
	}
	
	public void setDown(Node down){
		this.right = down;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public Node getNext() {
		return this.left;
	}
	
	public Node getDown() {
		return this.right;
	}

	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
}
