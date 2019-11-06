package PackagePremier;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class Game {

	int pEcartY = 30;

	int positionPilesY = 25;
	int positionColonneY = 200;

	int pos1 = 25;
	int pos2 = 128;
	int pos3 = 238;
	int pos4 = 355;
	int pos5 = 469;
	int pos6 = 586;
	int pos7 = 705;

	public TasDeCartes defausse = new TasDeCartes("defausse",
			new ArrayList<Carte>(), pos1, positionPilesY);
	public TasDeCartes poubelle = new TasDeCartes("poubelle",
			new ArrayList<Carte>(), pos2, positionPilesY);
	public TasDeCartes c1 = new TasDeCartes("colonne 1",
			new ArrayList<Carte>(), pos1, positionColonneY);
	public TasDeCartes c2 = new TasDeCartes("colonne 2",
			new ArrayList<Carte>(), pos2, positionColonneY);
	public TasDeCartes c3 = new TasDeCartes("colonne 3",
			new ArrayList<Carte>(), pos3, positionColonneY);
	public TasDeCartes c4 = new TasDeCartes("colonne 4",
			new ArrayList<Carte>(), pos4, positionColonneY);
	public TasDeCartes c5 = new TasDeCartes("colonne 5",
			new ArrayList<Carte>(), pos5, positionColonneY);
	public TasDeCartes c6 = new TasDeCartes("colonne 6",
			new ArrayList<Carte>(), pos6, positionColonneY);
	public TasDeCartes c7 = new TasDeCartes("colonne 7",
			new ArrayList<Carte>(), pos7, positionColonneY);
	public TasDeCartes p1 = new TasDeCartes("pile 1", new ArrayList<Carte>(),
			pos4, positionPilesY);
	public TasDeCartes p2 = new TasDeCartes("pile 2", new ArrayList<Carte>(),
			pos5, positionPilesY);
	public TasDeCartes p3 = new TasDeCartes("pile 3", new ArrayList<Carte>(),
			pos6, positionPilesY);
	public TasDeCartes p4 = new TasDeCartes("pile 4", new ArrayList<Carte>(),
			pos7, positionPilesY);

	// créer un paquet de 52 cartes
	public Game() {
	/*	for (Carte.Couleur coul : Carte.Couleur.values())
			for (int i = 1; i <= 13; i++)
				defausse.listeDeCartes.add(new Carte(new ImageIcon("Cartes/"
						+ i + coul.toString() + ".jpg"), defausse.posX,
						defausse.posY, coul, i));*/

	//	Collections.shuffle(defausse.listeDeCartes);
		defausse.listeDeCartes.get(0).ret = true;
		defausse.listeDeCartes.get(2).ret = true;
		defausse.listeDeCartes.get(5).ret = true;
		defausse.listeDeCartes.get(9).ret = true;
		defausse.listeDeCartes.get(14).ret = true;
		defausse.listeDeCartes.get(20).ret = true;
		defausse.listeDeCartes.get(27).ret = true;

		c1.listeDeCartes.add(defausse.listeDeCartes.get(0));
		c1.listeDeCartes.get(0).posX = c1.posX;
		c1.listeDeCartes.get(0).posY = c1.posY;

		for (int i = 1; i < 3; i++) {
			Carte Carte = defausse.listeDeCartes.get(i);
			Carte.posX = c2.posX;
			Carte.posY = c2.posY;
			c2.listeDeCartes.add(Carte);
		}
		for (int i = 3; i < 6; i++) {
			Carte Carte = defausse.listeDeCartes.get(i);
			Carte.posX = c3.posX;
			Carte.posY = c3.posY;
			c3.listeDeCartes.add(Carte);
		}
		for (int i = 6; i < 10; i++) {
			Carte Carte = defausse.listeDeCartes.get(i);
			Carte.posX = c4.posX;
			Carte.posY = c4.posY;
			c4.listeDeCartes.add(Carte);
		}
		for (int i = 10; i < 15; i++) {
			Carte Carte = defausse.listeDeCartes.get(i);
			Carte.posX = c5.posX;
			Carte.posY = c5.posY;
			c5.listeDeCartes.add(Carte);
		}
		for (int i = 15; i < 21; i++) {
			Carte Carte = defausse.listeDeCartes.get(i);
			Carte.posX = c6.posX;
			Carte.posY = c6.posY;
			c6.listeDeCartes.add(Carte);
		}
		for (int i = 21; i < 28; i++) {
			Carte Carte = defausse.listeDeCartes.get(i);
			Carte.posX = c7.posX;
			Carte.posY = c7.posY;
			c7.listeDeCartes.add(Carte);
		}

		defausse.listeDeCartes.removeAll(c1.listeDeCartes);
		defausse.listeDeCartes.removeAll(c2.listeDeCartes);
		defausse.listeDeCartes.removeAll(c3.listeDeCartes);
		defausse.listeDeCartes.removeAll(c4.listeDeCartes);
		defausse.listeDeCartes.removeAll(c5.listeDeCartes);
		defausse.listeDeCartes.removeAll(c6.listeDeCartes);
		defausse.listeDeCartes.removeAll(c7.listeDeCartes);

		InitColonne(c1);
		InitColonne(c2);
		InitColonne(c3);
		InitColonne(c4);
		InitColonne(c5);
		InitColonne(c6);
		InitColonne(c7);

		// ceci sert a voir la position des piles, qui sont absente en début de
		// jeu.
		/*
		 * p1.listeDeCartes.add(defausse.listeDeCartes.get(0));
		 * p1.listeDeCartes.get(0).posX = p1.posX; p1.listeDeCartes.get(0).posY
		 * = p1.posY; p2.listeDeCartes.add(defausse.listeDeCartes.get(1));
		 * p2.listeDeCartes.get(0).posX = p2.posX; p2.listeDeCartes.get(0).posY
		 * = p2.posY; p3.listeDeCartes.add(defausse.listeDeCartes.get(2));
		 * p3.listeDeCartes.get(0).posX = p3.posX; p3.listeDeCartes.get(0).posY
		 * = p3.posY; p4.listeDeCartes.add(defausse.listeDeCartes.get(3));
		 * p4.listeDeCartes.get(0).posX = p4.posX; p4.listeDeCartes.get(0).posY
		 * = p4.posY;
		 */

	}

/*TCHEKER
 * 	public void InitColonne(TasDeCartes c) {
		for (int i = 1; i < c.listeDeCartes.size(); i++) {
			Carte carte = c.listeDeCartes.get(i);
			carte.posY = c.posY + i * 30;
		}
	}*/

	public boolean Win() {
		return (c1.listeDeCartes.isEmpty() && c2.listeDeCartes.isEmpty()
				&& c3.listeDeCartes.isEmpty() && c4.listeDeCartes.isEmpty()
				&& c5.listeDeCartes.isEmpty() && c6.listeDeCartes.isEmpty()
				&& c7.listeDeCartes.isEmpty()
				&& defausse.listeDeCartes.isEmpty() && poubelle.listeDeCartes
					.isEmpty());
	}

/*TCHEKER
 * 	public void ajouterCartePoubelle() {
		if (!defausse.listeDeCartes.isEmpty()) {
			Carte LastCarte = defausse.listeDeCartes.get(defausse.listeDeCartes
					.size() - 1);

			LastCarte.posX = poubelle.posX;
			LastCarte.ret = true;

			poubelle.listeDeCartes.add(LastCarte);
			defausse.listeDeCartes.remove(LastCarte);

		} else
			for (int i = poubelle.listeDeCartes.size() - 1; i >= 0; i--) {
				Carte LastCarte = poubelle.listeDeCartes.get(i);

				LastCarte.posX = defausse.posX;
				LastCarte.ret = false;

				defausse.listeDeCartes.add(LastCarte);
				poubelle.listeDeCartes.remove(LastCarte);
			}
	}*/

/*TCHEKER
 * 	public boolean ajouterListeColonnePossible(ArrayList<Carte> l, TasDeCartes colonne) {
		if (l.size() != 0) {
			if (colonne.listeDeCartes.isEmpty()) {
				return (l.get(0).valeur == 13);
			} else {
				Carte LastCarte = colonne.listeDeCartes
						.get(colonne.listeDeCartes.size() - 1);
				if ((l.get(0).memeCouleur(LastCarte) == false)
						&& ((LastCarte.valeur) == l.get(0).valeur + 1)) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}*/

/*TCHEKER
 * 	public void ajouterListeColonne(ArrayList<Carte> l, TasDeCartes colonne, TasDeCartes colonneOrigine) {
 *
		if (ajouterListeColonnePossible(l, colonne) == true) {
			if (colonne.listeDeCartes.isEmpty()) {
				if (l.get(0).valeur == 13) {
					for (int i = 0; i < l.size(); i++) {
						l.get(i).posX = colonne.posX;
						l.get(i).posY = colonne.posY + pEcartY * i;
					}
					colonne.listeDeCartes.addAll(l);
					colonneOrigine.listeDeCartes.removeAll(l);
				}
			} else {
				Carte LastCarte = colonne.listeDeCartes
						.get(colonne.listeDeCartes.size() - 1);
				for (int i = 0; i < l.size(); i++) {
					l.get(i).posX = LastCarte.posX;
					l.get(i).posY = LastCarte.posY + pEcartY * (i+1);
				}
				colonne.listeDeCartes.addAll(l);
				colonneOrigine.listeDeCartes.removeAll(l);
			}
		}
	}*/

/*TCHEKER
 * 	public boolean ajouterCartePilePossible(ArrayList<Carte> l, TasDeCartes pile) {
		if (l.size() == 1) {
			if (pile.listeDeCartes.isEmpty() == true) {
				if (l.get(0).valeur == 1)
					return true;
				else {
					return false;
				}
			} else {
				Carte LastCarte = pile.listeDeCartes.get(pile.listeDeCartes
						.size() - 1);
				if ((l.get(0).valeur == ((LastCarte.valeur) + 1))
						&& (l.get(0).couleur.equals(LastCarte.couleur))) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}*/

/*TCHEKER
 * 	public void ajouterCartePile(ArrayList<Carte> l, TasDeCartes pile,
			TasDeCartes colonneOrigine) {
		if (ajouterCartePilePossible(l, pile) == true) {
			l.get(0).posX = pile.posX;
			l.get(0).posY = pile.posY;
			pile.listeDeCartes.addAll(l);
			colonneOrigine.listeDeCartes.removeAll(l);
		}
	}*/
	public lol(){
		
	}
}
