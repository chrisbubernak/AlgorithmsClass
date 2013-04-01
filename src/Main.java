
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lattice l = new Lattice(10);
		System.out.println(l.score());
		l.neighbors(10);
		Annealer a = new Annealer(l, 1, 1);
		a.accept(4, 3, .01);
	}

}
