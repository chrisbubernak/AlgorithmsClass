
public class PQNode<T>{
  private PQNode<T> parent;
  private int key;
  private T value;
  
  //position in the tree (used for push/pop)
  private int position;
  
  //used for the Queue
  private PQNode <T>left;
  private PQNode <T>right;
  
  public String toString(){
	  return "\nkey: " + this.key + " value: (" + this.value + ") pos: " + this.position;
  }

  PQNode(PQNode<T> old){
	  this.key = old.getKey();
	  this.value = old.getValue();
  }
	
  PQNode(int key,  T value){
	  this.value = value;
	  this.key = key;
  }
  
  public void setPosition(int pos){
	  this.position = pos;
  }
  
  public int getPosition(){
	  return this.position;
  }
  
  public void setValue(T value){
	  this.value = value;
  }
  
  public T getValue(){
	  return this.value;
  }
  
  public int getKey(){
	  return this.key;  
  }

  public void setKey(int key){
	  this.key = key;
  }

	public void setParent(PQNode<T> parent) {
		this.parent = parent;
	}

	public PQNode<T> getParent() {
		return this.parent;
	}

	
	public void setLeft(PQNode<T> left) {
		this.left = left;
	}
	
	public void setRight(PQNode<T> right) {
		this.right = right;
	}
	
	public PQNode<T> getLeft() {
		return this.left;
	}
	
	public PQNode<T> getRight() {
		return this.right;
	}
	
}
