import java.util.Random;

public class Test {

	static Random rand = new Random();
	
	public static void main(String[] args) {
		test(100, 10);
		test(100, 50);
		test(100, 100);
		test(100, 500);
		test(100, 1000);
		test(100, 5000);
		test(100, 10000);
		test(100, 50000);
		AVLTree<Integer>a = new AVLTree<Integer>();
		/*a.insert(10);
		a.print();

		a.insert(13);
		a.print();

		a.insert(14);
		a.insert(11);
		a.insert(17);
		a.insert(9);
		a.insert(20);
		a.insert(19);
		a.insert(21);
		a.insert(15);
		a.insert(8);
		a.delete(17);
		a.delete(14);
		a.delete(13);
		a.print();*/
	}
	
	public static void test(int trials, int n) {
		int count = 0;
		//insert tests
		for (int i = 0; i<trials; i++) {
			AVLTree<Integer> a = createTree(n);
			AVLTree.opCount = 0;
			a.insert(rand.nextInt(Integer.MAX_VALUE));
			count += AVLTree.opCount;
		}
		
		System.out.println("Insert Test n=" + n + " count=" + count/trials);
		
		//delete tests
		for (int i = 0; i<trials; i++) {
			AVLTree<Integer> a = createTree(n);

		}
		
		//search tests
		for (int i = 0; i<trials; i++) {
			AVLTree<Integer> a = createTree(n);

		}
	}
	
	public static AVLTree <Integer> createTree(int n) {
		AVLTree<Integer> a = new AVLTree<Integer>();
		for (int i = 0; i<n; i++) {
			a.insert(rand.nextInt(Integer.MAX_VALUE));
		}
		return a;
	}

}
