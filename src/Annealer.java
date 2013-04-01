import java.util.Random;

public class Annealer {
	private Random rand = new Random();
	private double alpha;
	private double temp0;
	private State state0;
	
	public Annealer(State s, double temp, double alpha){
		this.alpha = alpha;
		this.temp0 = temp;
		this.state0 = s;
	}
	
	public State run(){
		State s = state0;
		double temp = temp0;
		
		//run till convergance...right now im just doing 10
		for (int i =0; i<10; i++){
			State s_new = this.neighbors(s);
			if (accept(score(s), score(s_new), temp)){
					s = s_new;
			}
			temp = decreaseTemperature(temp);
		}
		return s;
	}
	
	
	//a function that takes as input the scores of two
	//states and a temperature and makes a probabilistic 
	//decision about whether nor not to accept the proposed
	//move (i.e, to replace s with s')
	public boolean accept(double score1, double score2, double temp){
		//Pr(accept|score2 < score1)  = 1
		//prefer score decreses!
		if (score2 < score1) {
			return true;
		}
		
		//Pr(accept|score2>score1,t) = e^-(abs(score2-score1)/t)		
		double p = Math.exp(-Math.abs(score2-score1)/temp);
		if (rand.nextDouble()<=p){
			return true;
		}
		
		
		return false;
		
	}
	
	//a function that takes as input some solution s 
	//and returns a "neighboring" solution4 s'
	public State neighbors(State s){
		return new State(0);
	}
	
	//a function that takes a real valued parameter t and
	//returns another real-valued t' < t. the monotonic 
	//structure of decreaseTemperature() is caled the
	//"cooling" or "annealing" schedule
	public double decreaseTemperature(double temp){
		return temp*alpha;
	}
	
	public int score(State s){
		int score = 0;
		int n = s.getN();
		int [] lattice = s.getLattice();
		
		for (int i =0; i<n; i++){
			for (int j =0; j<n; j++){
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
		if (y1 == y2 && (x2 == (x2-1+n)%n || x2 == (x1+1+n)%n)){
			return 1;
		}
		
		return 0;
	}
	

}
