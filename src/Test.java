//example class to show how to use the AVL tree
public class Test {
	public static void main(String[] args) {		
		AVLTree<Integer>a = new AVLTree<Integer>();
		a.insert(10);
		a.insert(13);
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
	

}
