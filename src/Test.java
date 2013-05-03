import java.util.Random;

public class Test {

	static Random rand = new Random();
	static int targetValue; 
	
	public static void main(String[] args) {
		insertTest(100, 10);
		insertTest(100, 50);
		insertTest(100, 100);
		insertTest(100, 500);
		insertTest(100, 1000);
		insertTest(100, 5000);
		insertTest(100, 10000);
		insertTest(100, 50000);
		
		searchTest(100, 10);
		searchTest(100, 50);
		searchTest(100, 100);
		searchTest(100, 500);
		searchTest(100, 1000);
		searchTest(100, 5000);
		searchTest(100, 10000);
		searchTest(100, 50000);
		
		deleteTest(100, 10);
		deleteTest(100, 50);
		deleteTest(100, 100);
		deleteTest(100, 500);
		deleteTest(100, 1000);
		deleteTest(100, 5000);
		deleteTest(100, 10000);
		deleteTest(100, 50000);
		
		AVLTree<Integer>a = new AVLTree<Integer>();
		a.insert(10);
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
		a.print();
	}
	
	public static void insertTest(int trials, int n) {
		int count = 0;
		//insert tests
		for (int i = 0; i<trials; i++) {
			AVLTree<Integer> a = createTree(n);
			AVLTree.opCount = 0;
			a.insert(rand.nextInt(Integer.MAX_VALUE));
			count += AVLTree.opCount;
		}
		
		System.out.println("Insert Test n=" + n + " count=" + count/trials);

	}
	
	public static void deleteTest(int trials, int n) {
		int count = 0;
		
		for (int i = 0; i<trials; i++) {
			AVLTree<Integer> a = createTree(n);
			AVLTree.opCount = 0;
			a.delete(targetValue);
			count += AVLTree.opCount;
		}
		
		System.out.println("Delete Test n=" + n + " count=" + count/trials);
	}
	
	public static void searchTest(int trials, int n) {
		int count = 0;
		//search tests
		for (int i = 0; i<trials; i++) {
			AVLTree<Integer> a = createTree(n);
			AVLTree.opCount = 0;
			a.search(targetValue);
			count += AVLTree.opCount;
		}
		
		System.out.println("Search Test n=" + n + " count=" + count/trials);
	}
	
	public static AVLTree <Integer> createTree(int n) {
		AVLTree<Integer> a = new AVLTree<Integer>();
		for (int i = 0; i<n; i++) {
			int val = rand.nextInt(Integer.MAX_VALUE);
			if (i == 0) {
				targetValue = val;
			}
			a.insert(val);
		}
		return a;
	}

}
