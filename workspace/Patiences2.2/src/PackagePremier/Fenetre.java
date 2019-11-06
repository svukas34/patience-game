package PackagePremier;

import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame{

	PanelTest panT = new PanelTest();	
	PanSolitaire panS = new PanSolitaire();
	PanFreecell panF = new PanFreecell();
	
	public Fenetre(){
		setTitle("lol");
		setSize(1200,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setContentPane(pan);
	}
}
