
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		State s = new State(3);
		Annealer a = new Annealer(s, 10, .9);
		System.out.println(a.score(s));
		s.print();
		//State l = new State(50);
		//Annealer a = new Annealer(l, 1000, .9999);
	}

}
