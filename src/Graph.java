import java.util.Random;

public class Graph {
	private Node [] adjacencyList;
	private static Random rand = new Random();
	
	public Graph(int size, int c) {
		adjacencyList = new Node[size];
		double p = (double)c/(size-1);
		for (int i = 0; i<size; i++){
			for (int j =0; j<size; j++) {
				if (i != j){
					double r = rand.nextDouble();
					if (r <= p) {
						this.addEdge(i, j);
					}
				}
			}
		}
	}
	
	public int size(){
		return adjacencyList.length;
	}
	
	public void addEdge(int a, int b) {
		Node tmp = new Node(a);
		Node tmp2 = new Node(b);
		tmp.setNext(adjacencyList[b]);
		tmp2.setNext(adjacencyList[a]);
		adjacencyList[a] = tmp2;
		adjacencyList[b] = tmp;
	}
	
	public Node neighbors(int vertex){
		return adjacencyList[vertex];
	}
	
	public void print(){
		for (int i = 0; i< this.adjacencyList.length; i++){
			System.out.print("Vertex: " + i +" edges: ");
			Node cur = this.adjacencyList[i];
			while (cur != null){
				System.out.print(cur.getValue() + " ");
				cur = cur.getNext();
			}
			System.out.print("\n");
		}
	}
	
	public int diameter() {
		int diameter = 0;
		for (int i =0; i<this.size(); i++){
			int d = ModifiedBFS(i);

			if (d > diameter) {
				diameter = d;
			}
		}
		return diameter;
	}
	
	private int ModifiedBFS(int s) {
		int max = 0;
		int [] v = new int [this.size()];
		int [] d = new int [this.size()];
		
		Queue q = new Queue();

		for (int i = 1; i<v.length ;i++) {
			v[i] = 0; //mark each vertex is unvisited
			d[i] = -1; // distance from s to i
		}
		
		q.push(s);
		d[s] = 0;

		while (!q.isEmpty()){
			int x = q.pop();
			if (v[x]==0){ // if x unvisited
					Node cur = this.neighbors(x);
					while(cur!=null){
						int y = cur.getValue();
						if (v[y]==0) { // if y unvisited
							q.push(y); // add y to queue
							
							//if bfs hasn't seen this yet 
							if (d[y] == -1) {
								d[y] = d[x] + 1; //record distance to y
								if (d[y] > max) {
									max = d[y];
								}
							}
						}
						cur = cur.getNext();
					}
	
					v[x] = 1; //mark x as visited
			}
		}
		return max;
	}
}
