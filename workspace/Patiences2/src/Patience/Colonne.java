package Patience;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;





public class Colonne extends TasDeCartes{
	
	//l'Ecart est la distance qui sépare verticalement 2 cartes sur une colonne
	private static int Ecart = 30;
	

	public Colonne(String name, ArrayList<Carte> liste, int posx, int posy) {
		super(name, liste, posx, posy);
		this.initLastCarte();
		this.setEcart(30);
	}
	public Colonne(){ }
	
	public void peindre(Graphics g, ImageIcon face, JPanel pan) {
		for (int i = 0; i < liste.size(); i++)
			if (liste.get(i).ret)
				g.drawImage(liste.get(i).img.getImage(), liste.get(i).posX, liste.get(i).posY, super.getLargeur(), super.getHauteur(), pan);
			else
				g.drawImage(face.getImage(),liste.get(i).posX, liste.get(i).posY, super.getLargeur(), super.getHauteur(), pan);
	}

	public boolean positionEstDessus(Position pos) {
		if (liste.isEmpty() == true) {
			return false;
		} else {
			return (pos.surElement(posX, posY, super.getLargeur(), ((liste.size() - 1)*Ecart)+super.getHauteur()));
		}

	}
	
	public boolean positionEstAutour(Position pos, Position PremierClique){
		pos.convertirPositionCentreCarte(posX, posY, super.getLargeur(), super.getHauteur(), PremierClique);
		if (liste.isEmpty() == true)
			return (pos.surElement(posX, posY, super.getLargeur(), super.getHauteur()));
		else
			return (pos.surElement(LastCarte.posX, LastCarte.posY, super.getLargeur(), super.getHauteur()));	
	}
	
	public int positionSurQuelleRangDeCarte(Position pos){
		for (int i = 0; i<liste.size()-1; i++){
			if (pos.getY() < i*Ecart + Ecart+posY)
				return i;
		} return liste.size()-1;
	}
	
	public void Initialiser(){
		for (int i = 1; i < liste.size(); i++) {
			Carte carte = liste.get(i);
			carte.posY = this.posY + i * 30;
		}
	}

	
	
	public boolean ajouterListePossible(ArrayList<Carte> l) {
		if (l.size() != 0) {
			if (liste.isEmpty()) {
				return (l.get(0).valeur == 13);
			} else {
				if ((l.get(0).memeCouleur(LastCarte) == false) && ((LastCarte.valeur) == l.get(0).valeur + 1)) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	
	public void ajouterListe(ArrayList<Carte> l, TasDeCartes colonneOrigine) {
		if (this.ajouterListePossible(l) == true) {
			if (liste.isEmpty()) {
				for (int i = 0; i < l.size(); i++) {
					l.get(i).posX = this.posX;
					l.get(i).posY = this.posY + Ecart * i;
				}
			} else {
				for (int i = 0; i < l.size(); i++) {
					l.get(i).posX = LastCarte.posX;
					l.get(i).posY = LastCarte.posY + Ecart * (i+1);
				}
			}
			this.liste.addAll(l);
			colonneOrigine.liste.removeAll(l);
			this.initLastCarte();
			colonneOrigine.initLastCarte();
		}
	}
	
	
	public static int getEcart() {
		return Ecart;
	}

	public void setEcart(int ecart) {
		Ecart = ecart;
	}

}

