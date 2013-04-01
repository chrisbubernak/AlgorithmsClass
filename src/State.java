import java.util.Random;

public class State {
	private int []lattice;
	private int n;
	private Random rand = new Random();
	
	public State(int n){
		this.n = n;
		this.lattice = new int[n*n];
		for (int i =0; i<n*n; i++){
			if (rand.nextDouble()>.5){
				this.lattice[i] = 1;
			}
			else{
				this.lattice[i] = -1;
			}
		}
	}
	
	public void print(){
		for (int i =0; i<n*n; i++){
			if (i%n==0){
				System.out.print("\n");
			}
			if (this.lattice[i] == -1){
				System.out.print("["+this.lattice[i] + "] ");
			}
			else {
				System.out.print("[ "+this.lattice[i] +"] ");
			}
		}
	}
	
	public State(State s) {
		this.setN(s.getN());
		this.setLattice(s.getLattice());
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
	
	public void neighbors(int index){
		int x = index%n;
		int y = index/n;
		System.out.println("Neighbors for " + x + " " + y + ":");
		
		//above
		System.out.println("x: " + x + " " + "y: " + (y-1+n)%n);
		
		//below
		System.out.println("x: " + x + " " + "y: " + (y+1+n)%n);
		
		//left
		System.out.println("x: " + (x-1+n)%this.n + " " + "y: " + y);
				
		//right
		System.out.println("x: " + (x+1+n)%this.n + " " + "y: " +y);
	}
}
