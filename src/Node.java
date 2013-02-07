
public class Node {
	private Node left;
	private Node right;
	private Node parent;
	private int value;
	
	//used to figure out where to insert in heaps
	private int numOfDesc; 
	
	public int getNumOfDesc(){
		return this.numOfDesc;
	}
	
	public void setNumOfDesc(int numberOfDesc){
		this.numOfDesc = numberOfDesc;
	}
	
	
	Node(int value) {
		this.value = value;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
		//everytime we add a node make sure every node 
		//above it in its path updates the num of children
		this.numOfDesc = 0;
		Node cur = this;
		while (cur.getParent() != null){
			cur = cur.getParent();
			cur.setNumOfDesc(cur.getNumOfDesc()+1);
		}
	}

	public Node getParent() {
		return this.parent;
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
