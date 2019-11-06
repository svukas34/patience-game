package premier;

import java.awt.*;
import javax.swing.*;

public class Panneau extends JPanel{
	Carte c1;

	public Panneau(){
		this.c1 = new Carte (2,'K');
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(c1.img.getImage(),15,15,this);
		System.out.println("paint");
	}
}
