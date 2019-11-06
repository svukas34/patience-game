package PackagePremier;

import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame{

	PanelTest panT = new PanelTest();	
	Panneau panS = new Panneau();
	PanFreecell panF = new PanFreecell();
	
	public Fenetre(){
		setTitle("lol");
		setSize(1200,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setContentPane(pan);
	}
}
