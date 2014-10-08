
public class Node {
	private Node next;
	private Node prev;
	private int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public Node getPrev(){
		return this.prev;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
