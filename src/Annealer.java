import java.util.Random;

public class Annealer {
	private Random rand = new Random();
	private double alpha;
	private double temp0;
	private State state0;
	private int update; 
	
	public Annealer(State s, double temp, double alpha){
		this.alpha = alpha;
		this.temp0 = temp;
		this.state0 = s;
	}
	
	public State run(){
		State s = state0;
		double temp = temp0;
		int accept = 0;
		//run till convergance...
		while ((accept<s.getN()*s.getN()) && ((s.percentOn()<.8)&&(s.percentOn()>.2))){
			State s_new = this.neighbors(s);
			if (accept(s.getScore(), s_new.getScore(), temp)){
					s = s_new;
					accept =0;
					if (update == 1){
						s.turnOn();
					}
					else{
						s.turnOff();
					}
			}
			else {
				accept++;
			}
			temp = decreaseTemperature(temp);
		}
		System.out.println(accept + "/" + s.getN()*s.getN());
		System.out.println(s.score());
		System.out.println(s.percentOn());
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
		State newState = new State(s);
		int n = s.getN();
		int index = rand.nextInt(n*n);
		int []lattice = newState.getLattice();
				
		
		int d = (index-n+lattice.length)%lattice.length;		
		int l = (index-1+n)%n+n*(index/n);
		int r = (index+1)%n+n*(index/n);
		int u = (index+n)%lattice.length;
				
		int oldScore = -1*(cellScore(lattice, d, n)+cellScore(lattice, l, n)+cellScore(lattice, r, n)+cellScore(lattice, u, n));				
		lattice[index] = lattice[index]*-1;
		
		if(lattice[index]==1){
			update = 1;
		}
		else {
			update = 0;
		}
		
		int newScore = -1*(cellScore(lattice, d, n)+cellScore(lattice, l, n)+cellScore(lattice, r, n)+cellScore(lattice, u, n));
	
		
		newState.setLattice(lattice);
		newState.setScore(s.getScore()-(oldScore-newScore));
		return newState;
	}
	
	//the score at a specific cell
	private int cellScore(int [] lattice, int index, int n){	
	
		int d = lattice[(index-n+lattice.length)%lattice.length];
		int l = lattice[(index-1+n)%n+n*(index/n)];
		int r = lattice[(index+1)%n+n*(index/n)];
		int u = lattice[(index+n)%lattice.length];

		return lattice[index]*(d+u+r+l);
	}
	
	//a function that takes a real valued parameter t and
	//returns another real-valued t' < t. the monotonic 
	//structure of decreaseTemperature() is caled the
	//"cooling" or "annealing" schedule
	public double decreaseTemperature(double temp){
		return temp*alpha;
	}	

}
