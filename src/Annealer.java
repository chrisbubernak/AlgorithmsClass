import java.util.Random;

public class Annealer {
	private Random rand = new Random();
	
	public Annealer(Lattice l, int temperature, int alpha){
		
	}
	
	
	//a function that takes as input the scores of two
	//states and a temperature and makes a probabilistic 
	//decision about whether nor not to accept the proposed
	//move (i.e, to replace s with s')
	public boolean accept(double score1, double score2, double temp){
		//Pr(accept|score2 > score2)  = 1
		if (score2 > score1) {
			return true;
		}
		
		//Pr(accept|score2<score1,t) = e^-(abs(score2-score1)/t)		
		double p = Math.exp(-Math.abs(score2-score1)/temp);
		if (rand.nextDouble()<=p){
			return true;
		}
		
		
		return false;
		
	}
	
	//a function that takes as input some solution s 
	//and returns a "neighboring" solution4 s'
	public void neighbors(){
		
	}
	
	//a function that takes a real valued parameter t and
	//returns another real-valued t' < t. the monotonic 
	//structure of decreaseTemperature() is caled the
	//"cooling" or "annealing" schedule
	public double decreaseTemperature(double temp){
		return temp/2;
	}
}
