
public class HuffmanEncoder {

	/**
	 * Encodes a string using a HuffmanEncoder
	 * @param  input	the string to encode (with symbols separated by spaces)
	 * @return      HOutput object containing the encoded string and the Huffman Tree 
	 */
	static public HOutput encode(String input) {
		//create counts for each char in string
		PriorityQueue <HNode>pq = new PriorityQueue<HNode>();
		pq.push(2,new HNode(2,"A"));
		pq.push(3, new HNode(3,"B"));
		pq.push(1, new HNode(1, "C"));
		pq.push(2, new HNode(2, "D"));
		pq.push(4, new HNode(4, "E"));
		pq.push(1, new HNode(1, "G"));

		
		while (pq.size() > 1){
			HNode hn1 = pq.pop();
			HNode hn2 = pq.pop();
			int f = hn1.getFrequency()+hn2.getFrequency();
			String s = hn1.getSymbol()+hn2.getSymbol();
			HNode hn3 = new HNode(f, s);
			hn3.setLeft(hn1);
			hn3.setRight(hn2);
			pq.push(f, hn3);
		}
		HNode huffmanTree = pq.pop();
		
		String encodedString = "";
		String[] inputChars = input.split("");

		//split produces a first element that is blank
		//so we can ignore it
		for (int i =1; i< inputChars.length; i++) {
			HNode cur = huffmanTree;
			while (!cur.getSymbol().equals(inputChars[i])) {
				if (cur.getLeft().getSymbol().contains(inputChars[i])) {
					cur = cur.getLeft();
					encodedString += "0";
				}
				else {
					cur = cur.getRight();
					encodedString += "1";
				}
			}
		}
		
		return new HOutput(huffmanTree, encodedString);
	}
	
	/**
	 * Decodes a Huffman encoded string
	 * @param  huffmanOutput	the HOutput object containing the encoded string and the Huffman Tree
	 * @return      String representing the decoded string
	 */
	static public String decode(HOutput huffmanOutput) {
		String encodedString = huffmanOutput.getEncodedString();
		HNode huffmanTree = huffmanOutput.getHuffmanTree();
		String decodedString = "";
		String [] encodedChars = encodedString.split("");
		
		//split produces a first element that is blank
		//so we can ignore it
		int i = 1;
		while( i< encodedChars.length) {
			HNode cur = huffmanTree;
			while (cur.getLeft()!= null) {
				if (encodedChars[i].equals("0")) {
					cur = cur.getLeft();
				}
				else {
					cur = cur.getRight();
				}
				i++;
			}
			decodedString += cur.getSymbol();
		}
		return decodedString;
	}
}
