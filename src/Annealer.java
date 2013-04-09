import java.util.Random;

public class Annealer {
	private Random rand = new Random();
	private double alpha;
	private double temp0;
	private int update; 
	
	private int n;
	private int [] lattice;
	private int score;
	private int on = 0;
	private int count = 0;
	
	public Annealer(int n, double temp, double alpha){
		this.alpha = alpha;
		this.temp0 = temp;
		this.n = n;
		makeLattice();
	}
	
	public double percentOn(){
		return (double)this.on/(this.n*this.n);
	}
	
	public int [] run(){
		double temp = temp0;
		int accept = 0;
		//run till convergance...
		while ((accept<n*n) && percentOn() < .8){
			count++;
			//choose a random point to propose a flip on
			int index = rand.nextInt(n*n);
			if(accept(index, temp)){
					accept =0;
					if (update == 1){
						this.on++;
					}
					else{
						this.on--;
					}
			}
			else {
				//flip the bit back if we reject
				lattice[index] = lattice[index]*-1;
				accept++;
			}
			temp = decreaseTemperature(temp);
		}
		System.out.println(accept + "/" + n*n);
		System.out.println("Score: " + score);
		System.out.println("Temp:" + temp);
		System.out.println("Percent On: " + percentOn());
		return this.lattice;
	}
	
	
	//a function that takes as input the scores of two
	//states and a temperature and makes a probabilistic 
	//decision about whether nor not to accept the proposed
	//move (i.e, to replace s with s')
	public boolean accept(int index, double temp){		
		int d = (index-n+lattice.length)%lattice.length;		
		int l = (index-1+n)%n+n*(index/n);
		int r = (index+1)%n+n*(index/n);
		int u = (index+n)%lattice.length;
				
		int oldScore = -1*(cellScore(d)+cellScore(l)+cellScore(r)+cellScore(u)+cellScore(index));				
		lattice[index] = lattice[index]*-1;
		
		if(lattice[index]==1){
			update = 1;
		}
		else {
			update = 0;
		}
		
		int newScore = -1*(cellScore(d)+cellScore(l)+cellScore(r)+cellScore(u)+cellScore(index));
		
		
		
		//Pr(accept|score2 < score1)  = 1
		//prefer score decreses!
		if (newScore < oldScore) {
			score = score - (oldScore - newScore);
			return true;
		}
		
		//Pr(accept|score2>score1,t) = e^-(abs(score2-score1)/t)		
		double p = Math.exp(-Math.abs(oldScore-newScore)/temp);

		if (rand.nextDouble()<=p){
			score = score - (oldScore - newScore);
			return true;
		}
	
		return false;
		
	}
	
	//the score at a specific cell
	private int cellScore(int index){	
	
		int d = this.lattice[(index-this.n+this.lattice.length)%this.lattice.length];
		int l = this.lattice[(index-1+this.n)%this.n+this.n*(index/this.n)];
		int r = this.lattice[(index+1)%this.n+this.n*(index/this.n)];
		int u = this.lattice[(index+this.n)%this.lattice.length];

		return this.lattice[index]*(d+u+r+l);
	}
	
	//a function that takes a real valued parameter t and
	//returns another real-valued t' < t. the monotonic 
	//structure of decreaseTemperature() is caled the
	//"cooling" or "annealing" schedule
	private double decreaseTemperature(double temp){
		return temp*alpha;
	}
	
	
	
	private void makeLattice(){
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
		for (int i =0; i<lattice.length; i++){
			this.score+=cellScore(i);
		}
	}
}
