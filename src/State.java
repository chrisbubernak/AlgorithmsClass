import java.util.Random;

public class State {
	private int on = 0;
	private int []lattice;
	private int n;
	private Random rand = new Random();
	private int score;
	
	public State(int n){
		this.n = n;
		this.lattice = new int[n*n];
		for (int i =0; i<n*n; i++){
			if (rand.nextDouble()>.5){
				this.lattice[i] = 1;
				this.on++;
			}
			else{
				this.lattice[i] = -1;
			}
		}
		this.score = this.score();
	}
	
	public void turnOn(){
		this.on++;
	}
	
	public void turnOff(){
		this.on--;
	}
	
	public double percentOn(){
		return (double)this.on/(this.n*this.n);
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public int score(){
		int score = 0;
		int n = this.getN();
		int [] lattice = this.getLattice();
		
		for (int i =0; i<n*n; i++){
			for (int j =0; j<n*n; j++){
				if (i!=j){
					score = score + lattice[i]*lattice[j]*coupled(i, j, n);
				}
			}
		}
		return -score;
	}
	
	public int coupled(int i, int j, int n){
		int x1 = i%n;
		int y1 = i/n;
		
		int x2 = j%n;
		int y2 = j/n;
		
		if (x1 == x2 && (y2 == (y1-1+n)%n || y2 == (y1+1+n)%n)) {
			return 1;
		}
		if (y1 == y2 && (x2 == (x1-1+n)%n || x2 == (x1+1+n)%n)){
			return 1;
		}
		
		return 0;
	}
	
	public void print(){
		for (int i =0; i<n*n; i++){
			if (i%n==0){
				System.out.print("\n");
			}
			if (this.lattice[i] == -1){
				//System.out.print("["+this.lattice[i] + "] ");
				System.out.print("0");
			}
			else {
				//System.out.print("[ "+this.lattice[i] +"] ");
				System.out.print("1");
			}
		}
	}
	
	public State(State s) {
		this.setN(s.getN());
		this.lattice = s.getLattice().clone();
		this.on = s.on;
	}
	
	public void setLattice(int [] lattice){
		this.lattice = lattice;
	}
	
	
	public int [] getLattice(){
		return lattice;
	}
	
	public void setN(int n){
		this.n = n;
	}
	
	public int getN(){
		return this.n;
	}
}
