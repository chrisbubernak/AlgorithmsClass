
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AVLTree<Integer>a = new AVLTree<Integer>();
		a.insert(10);
		a.insert(12);
		a.insert(11);
		a.insert(14);
		a.print();
		
		System.out.print(a.search(11));
	}

}
