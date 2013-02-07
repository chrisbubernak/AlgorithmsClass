
public class Node {
	private Node next;
	private Node down;
	private int value;
	
	Node(int value) {
		this.value = value;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setDown(Node down){
		this.down = down;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getDown() {
		return this.down;
	}
	
}
