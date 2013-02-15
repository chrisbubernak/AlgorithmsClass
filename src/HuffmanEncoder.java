
public class HuffmanEncoder {

	/**
	 * @param args
	 */
	static public Node encode(String input) {
		//create counts for each char in string
		PriorityQueue <HNode>pq = new PriorityQueue<HNode>();
		pq.push(new PQNode(2,new HNode(2,"A")));
		pq.push(new PQNode(3, new HNode(3,"B")));
		pq.push(new PQNode(1, new HNode(1, "C")));
		pq.push(new PQNode(2, new HNode(2, "D")));
		pq.push(new PQNode(4, new HNode(4, "E")));
		pq.push(new PQNode(1, new HNode(1, "G")));
		//put symbols/counts in priority queue PQ
		//while PQ.size > 1
		while (pq.size() > 1){
			pq.print();
			HNode hn1 = pq.pop();
			HNode hn2 = pq.pop();
			int f = hn1.getFrequency()+hn2.getFrequency();
			String s = hn1.getSymbol()+hn2.getSymbol();
			HNode hn3 = new HNode(f, s);
			hn3.setLeft(hn1);
			hn3.setRight(hn2);
			pq.push(new PQNode(f, hn3));
		}
		pq.print();
		//System.out.println(pq.pop());
		return null;
	}
}
