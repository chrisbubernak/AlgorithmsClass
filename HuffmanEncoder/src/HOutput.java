
public class HOutput {
	private HNode huffmanTree;
	private String encodedString;
	
	HOutput(HNode huffmanTree, String encodedString){
		this.huffmanTree = huffmanTree;
		this.encodedString = encodedString;
	}
	
	public HNode getHuffmanTree(){
		return this.huffmanTree;
	}

	public String getEncodedString(){
		return this.encodedString;
	}
}
