import java.util.Arrays;
import java.util.Random;

public class HuffmanTest {

	static Random rand = new Random();
	
	public static void main(String[] args) {
		robertFrostTest();
	}
	
	public static void robertFrostTest() {
	String input =
		"the road not taken by robert frost " +
		"two roads diverged in a yellow wood, " +
		"and sorry i could not travel both " +
		"and be one traveler, long i stood " +
		"and looked down one as far as i could " +
		"to where it bent in the undergrowth; " +
		"then took the other, as just as fair, " +
		"and having perhaps the better claim, " +
		"because it was grassy and wanted wear; " +
		"though as for that the passing there " +
		"had worn them really about the same, " +
		"and both that morning equally lay " +
		"in leaves no step had trodden black. " +
		"oh, i kept the first for another day! " +
		"yet knowing how way leads on to way, " +
		"i doubted if i should ever come back. " +
		"i shall be telling this with a sigh " +
		"somewhere ages and ages hence: " +
		"two roads diverged in a wood, and i- " +
		"i took the one less traveled by, " +
		"and that has made all the difference.";
	String [] tmp = input.split("");
	//first element of this tmp array is just blank so fix it
	String [] chars = Arrays.copyOfRange(tmp, 1, tmp.length);
	HOutput ho = HuffmanEncoder.encode(input);
	System.out.print(HuffmanEncoder.decode(ho));
	}
	
}
