import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class Main implements Runnable{
	private static State sFinal;
	private static int boxSize = 10;
	
	public void run(){
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int n = sFinal.getN();
		f.getContentPane().setPreferredSize(new Dimension(n*boxSize,n*boxSize));
		JPanel p = new JPanel(){
			public void paintComponent(Graphics g) {
				int n = sFinal.getN();

				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D)g;
				int [] lattice = sFinal.getLattice();
				for (int i = 0; i<lattice.length; i++){
					if (lattice[i] == 1) {
						g2.setColor(Color.black);

						g2.fillRect(boxSize*(i%n), boxSize*(i/n), boxSize, boxSize);
					}
				}
			}
		};
		f.add(p);
		f.pack();
		f.setVisible(true);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main m = new Main();
		State l = new State(50);
		Annealer a = new Annealer(l, 1000, .9999);
		sFinal = a.run();
		
		SwingUtilities.invokeLater(m);
		
	
		
	}

}
