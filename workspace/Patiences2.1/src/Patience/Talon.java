package Patience;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Talon extends TasDeCartes {

	public Talon(String name, ArrayList<Carte> liste, int posx, int posy){
		super(name, liste, posx, posy);
	}
	
	public boolean positionEstDessus(Position p){
		return(p.surElement(posX, posY, super.getLargeur(), super.getHauteur()));
	}
	
	public void ajouterCarte(Defausse d) {
		if (!d.liste.isEmpty()) {
			Carte LastCarte = d.liste.get(d.liste.size() - 1) ;
			LastCarte.posX = this.posX;
			LastCarte.ret = true;

			this.liste.add(LastCarte);
			d.liste.remove(LastCarte);
		} else {
			for (int i = this.liste.size() - 1; i >= 0; i--) {
				Carte LastCarte = this.liste.get(i);

				LastCarte.posX = d.posX;
				LastCarte.ret = false;

				d.liste.add(LastCarte);
				this.liste.remove(LastCarte);
			}
		}
	}
}
