
public class HNode{
	private String symbol;
	private int frequency;
	private HNode left;
	private HNode right;
	
	public String toString(){
		return "sym: " + this.symbol + " freq: " + this.frequency;
	}
	
	HNode(int frequency, String symbol){
		this.frequency = frequency;
		this.symbol = symbol;
	}
	
	public HNode getLeft(){
		return this.left;
	}
	
	public void setLeft(HNode left){
		this.left = left;
	}
	
	public HNode getRight(){
		return this.right;
	}

	public void setRight(HNode right){
		this.right = right;
	}
	
	
	public int getFrequency() {
		return this.frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public String getSymbol(){
		return this.symbol;
	}
	
	public void setString(String symbol){
		this.symbol = symbol;
	}
}
