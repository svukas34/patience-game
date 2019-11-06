package Patience;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Pile extends TasDeCartes{

	public Pile(String name, ArrayList<Carte> liste, int posx, int posy) {
		super(name, liste, posx, posy);
	}
		
	
	public boolean positionEstAutour(Position pos, Position PremierClique){
		pos.convertirPositionCentreCarte(posX, posY, super.getLargeur(), super.getHauteur(), PremierClique);
			return (pos.surElement(posX, posY, super.getLargeur(), super.getHauteur()));	
	}

	
	public boolean ajouterCartePossible(ArrayList<Carte> l) {
		if (l.size() == 1) {
			if (liste.isEmpty() == true) {
				return (l.get(0).valeur == 1);
			} else {
				Carte LastCarte = l.get(l.size() - 1) ;
				if ((l.get(0).valeur == ((LastCarte.valeur) + 1)) && (l.get(0).couleur.equals(LastCarte.couleur))) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	public void ajouterCarte(ArrayList<Carte> l, TasDeCartes colonneOrigine) {
		if (this.ajouterCartePossible(l) == true) {
			l.get(0).posX = this.posX;
			l.get(0).posY = this.posY;
			this.liste.addAll(l);
			colonneOrigine.liste.removeAll(l);
		}
	}
}
