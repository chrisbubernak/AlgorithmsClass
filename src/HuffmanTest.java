import java.util.Random;

public class HuffmanTest {

	static Random rand = new Random();
	
	public static void main(String[] args) {
		System.out.println("N = 10: " + test(5,1));
		/*System.out.println("N = 50: " + test(50,10));
		System.out.println("N = 100: " + test(100,10));
		System.out.println("N = 500: " + test(500,10));
		System.out.println("N = 1000: " + test(1000,10));
		System.out.println("N = 5000: " + test(5000,10));
		System.out.println("N = 10000: " + test(10000,10));
		System.out.println("N = 50000: " + test(50000,10));*/

	}
	
	//run a a given number of tests on an alphabet of size n
	//return the average number of operations
	public static int test(int n, int trials){
		int operations = 0;
		String [] alphabet = new String [n];
		String symbol = "";
		for (int i =0; i<n; i++){
			symbol = symbol + "a";
			alphabet[i] = symbol;
		}
		
		for (int i = 0; i < trials; i++){
			String input = "";
			for (int j = 0; j<alphabet.length; j++) {
				input = input + alphabet[j] + " ";
				while (rand.nextInt(2) != 1){
					input = input + alphabet[j] + " ";
				}
			}
			System.out.println(input);
			HOutput ho = HuffmanEncoder.encode(input.trim());
			//HOutput ho = HuffmanEncoder.encode("A A B B B C D D E E E E G");
			System.out.println(ho.getEncodedString());
			System.out.println(HuffmanEncoder.decode(ho));
			
		}
		
		return operations/trials;
	}
}
