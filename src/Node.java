
public class Node {
	protected Node next;
	protected Node down;
	protected int value;

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

	public void setValue(int value) {
		this.value = value;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getDown() {
		return this.down;
	}
}
