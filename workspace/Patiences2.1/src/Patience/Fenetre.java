package Patience;

import javax.swing.JFrame;



public class Fenetre extends JFrame{

	
	PanSolitaire panS = new PanSolitaire();
	
	public Fenetre(){
		setTitle("solitaire");
		setSize(1200,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panS);
	}
}