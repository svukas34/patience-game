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
	
}
