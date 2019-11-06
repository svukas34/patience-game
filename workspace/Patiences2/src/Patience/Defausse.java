package Patience;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Defausse extends TasDeCartes{

	public Defausse(String name, ArrayList<Carte> liste, int posx, int posy){
		super(name, liste, posx, posy);
	}
	
	public boolean positionEstDessus(Position p){
		return(p.surElement(posX, posY, super.getLargeur(), super.getHauteur()));
	}
	
	public void peindre(Graphics g, ImageIcon face, JPanel pan){
		if (!liste.isEmpty())
			g.drawImage(face.getImage(), posX, posY, super.getLargeur(), super.getHauteur(), pan);
	}
}
