package Patience;

import java.awt.*;
import javax.swing.*;

public class FenetreBis extends JFrame{

	PanFreecell panF = new PanFreecell();
	
	public FenetreBis(){
		setTitle("Freecell");
		setSize(870,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panF);
	}
}
