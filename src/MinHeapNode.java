
public class MinHeapNode extends Node{
  private MinHeapNode parent;
	
  //used to store the minimum number of descendents over all paths 
  //from a node to all leafs beneath it
  //used to figure out where to insert in heap
  private int minNumOfDesc; 
 
  //used to store the minimum number of descendents over all paths 
  //from a node to all leafs beneath it
  //used to figure out where to delete in heap
  private int maxNumOfDesc; 
  
	
  MinHeapNode(int value){
	  super(value);
  }
	public int getMinNumOfDesc(){
		return this.minNumOfDesc;
	}

	void setMinNumOfDesc(int numberOfDesc){
		this.minNumOfDesc = numberOfDesc;
	}

	public int getMaxNumOfDesc(){
		return this.maxNumOfDesc;
	}

	void setMaxNumOfDesc(int numberOfDesc){
		this.maxNumOfDesc = numberOfDesc;
	}

	
	public void setParent(MinHeapNode parent) {
		this.parent = parent;

		this.setMaxNumOfDesc(0);
		this.setMinNumOfDesc(0);
		MinHeapNode cur = this;
		while (cur.getParent() != null){
			//MinHeapNode parent = cur.getParent();
			//parent.setNumOfDesc(Math.min(a, b));
			cur = cur.getParent();
			if (cur.getRight() == null) {
				cur.setMaxNumOfDesc(cur.getLeft().getMaxNumOfDesc()+1);
				cur.setMinNumOfDesc(0);
			}
			else {
				cur.setMinNumOfDesc(Math.min(cur.getLeft().getMinNumOfDesc()+1, cur.getLeft().getMinNumOfDesc()+1 ));
				cur.setMinNumOfDesc(Math.max(cur.getLeft().getMinNumOfDesc()+1, cur.getLeft().getMinNumOfDesc()+1 ));
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
