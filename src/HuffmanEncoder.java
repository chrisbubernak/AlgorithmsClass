public class HuffmanEncoder {

	/**
	 * Encodes a string using a HuffmanEncoder
	 * @param  input	the string to encode (with symbols separated by spaces)
	 * @return      HOutput object containing the encoded string and the Huffman Tree 
	 */
	static public HOutput encode(String input) {
		//create counts for each char in string
		String [] symbols = new String[input.length()];
		int [] counts = new int[input.length()];
		int count = 0;
		
		String [] inputSymbols = input.split(" "); 
			
		for (int i =0; i<inputSymbols.length; i++) {
			int index = indexOf(inputSymbols[i], symbols);
			if (index == -1){
				symbols[count] = inputSymbols[i];
				counts[count] = 1;
				count++;
			}
			else {
				symbols[index] = inputSymbols[i];
				counts[index] = counts[index]+ 1;				
			}
		}

		
		PriorityQueue <HNode>pq = new PriorityQueue<HNode>();
		
		for (int i = 0; i<count; i++) {
			System.out.println(counts[i] + " " + symbols[i]);
			pq.push(counts[i], new HNode(counts[i], symbols[i]));
		}

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

		for (int i =0; i< inputSymbols.length; i++) {
			HNode cur = huffmanTree;
			while (!cur.getSymbol().equals(inputSymbols[i])) {
				if (cur.getLeft().getSymbol().contains(inputSymbols[i])) {
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
			decodedString += cur.getSymbol() + " ";
		}
		//remove the trailing whitespace
		return decodedString.trim();
	}
	
	private static int indexOf(String target, String [] array) {
		int i =0;
		while(array[i] != null){
			if (array[i].equals(target)) {
				return i;
			}
			i++;
		}
		return -1;
	}
}
