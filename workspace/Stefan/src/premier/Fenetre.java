package premier;

import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame{
	
	Panneau pan = new Panneau();
	
	public Fenetre(){
		setTitle("lol");
		setSize(1200,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(pan);
	}
}
