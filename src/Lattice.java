
public class Lattice {
	private int []s;
	private int j[][];
	private int size;
	
	public Lattice(int size){
		this.size = size;
		this.s = new int[size*size];
		this.j = new int[size][size];
	}
	
	public int size(){
		return this.size;
	}
	
	public void neighbors(int index){
		int x = index%size;
		int y = index/size;
		System.out.println("Neighbors for " + x + " " + y + ":");
		
		//above
		System.out.println("x: " + x + " " + "y: " + (y-1+size)%size);
		
		//below
		System.out.println("x: " + x + " " + "y: " + (y+1+size)%size);
		
		//left
		System.out.println("x: " + (x-1+size)%this.size + " " + "y: " + y);
				
		//right
		System.out.println("x: " + (x+1+size)%this.size + " " + "y: " +y);
	}
	
	public int score(){
		int score = 0;

		for (int i =0; i<this.size; i++){
			for (int j =0; j<this.size; j++){
				if (i!=j){
					score = score + this.s[i]*this.s[j]*this.j[i][j];
				}
			}
		}
		return -score;
	}
	
}
