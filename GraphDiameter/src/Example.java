/*
 * Example code showing how to use graph class to calculate diameter.
 */
public class Example {
	public static void main(String[] args) {
		int size = 100;
		int c = 2;
		Graph g = new Graph(size, c);
		System.out.println(g.diameter());
	}
	
}
