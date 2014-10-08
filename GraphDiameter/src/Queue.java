//FIFO Queue with an underlying doubley linked list implementation
public class Queue {
	private Node head;
	private Node tail;
	private int size = 0;
	
	public boolean isEmpty(){
		if (head == null) {
			return true;
		}
		return false;
	}
	
	public void push(int val){
		this.size++;
		Node node = new Node(val);
		if (this.head == null) {
			this.head = node;
			this.tail = node;
			return;
		}
		node.setNext(this.head);
		this.head.setPrev(node);
		this.head = node;
	}
	
	public int size(){
		return this.size;
	}
	
	public int pop() {
		this.size--;

		Node oldTail = tail;
		Node newTail = tail.getPrev();
		if (newTail != null) {
			newTail.setNext(null);
		}
		else {
			this.head = null;
		}
		this.tail = newTail;
		return oldTail.getValue();
	}
}
