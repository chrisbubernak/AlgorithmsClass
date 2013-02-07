
public class MinHeapNode extends Node{
  private MinHeapNode parent;
	
  //used to store the minimum number of descendents over all paths 
  //from a node to all leafs beneath it
  //used to figure out where to insert in heap
  private int numOfDesc; 
	
  MinHeapNode(int value){
	  super(value);
  }
	public int getNumOfDesc(){
		return this.numOfDesc;
	}
	
	public void setNumOfDesc(int numberOfDesc){
		this.numOfDesc = numberOfDesc;
	}

	public void setParent(MinHeapNode parent) {
		this.parent = parent;
		//everytime we add a node make sure every node 
		//above it in its path updates the num of children
		this.numOfDesc = 0;
		MinHeapNode cur = this;
		while (cur.getParent() != null){
			//MinHeapNode parent = cur.getParent();
			//parent.setNumOfDesc(Math.min(a, b));
			cur = cur.getParent();
			if (cur.getRight() == null) {
				cur.setNumOfDesc(0);
			}
			else {
				cur.setNumOfDesc(Math.min(cur.getLeft().getNumOfDesc()+1, cur.getLeft().getNumOfDesc()+1 ));
			}
		}
	}

	public MinHeapNode getParent() {
		return this.parent;
	}
	
	public void setLeft(MinHeapNode left) {
		this.left = left;
	}
	
	public void setRight(MinHeapNode right) {
		this.right = right;
	}
	
	public MinHeapNode getLeft() {
		return (MinHeapNode) this.left;
	}
	
	public MinHeapNode getRight() {
		return (MinHeapNode) this.right;
	}
}
