package Patience;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class Solitaire extends Jeu{

	int positionPilesY = 25;
	int positionColonneY = 200;
	
	int pos1 = 40;
	int pos2 = pos1 + Largeur + 35;
	int pos3 = pos2 + Largeur + 35;
	int pos4 = pos3 + Largeur + 35;
	int pos5 = pos4 + Largeur + 35;
	int pos6 = pos5 + Largeur + 35;
	int pos7 = pos6 + Largeur + 35;
	
	public Defausse defausse = new Defausse("defausse",
			new ArrayList<Carte>(), pos1, positionPilesY);
	public Talon talon = new Talon("poubelle",
			new ArrayList<Carte>(), pos2, positionPilesY);
	public Colonne c1 = new Colonne("colonne 1",
			new ArrayList<Carte>(), pos1, positionColonneY);
	public Colonne c2 = new Colonne("colonne 2",
			new ArrayList<Carte>(), pos2, positionColonneY);
	public Colonne c3 = new Colonne("colonne 3",
			new ArrayList<Carte>(), pos3, positionColonneY);
	public Colonne c4 = new Colonne("colonne 4",
			new ArrayList<Carte>(), pos4, positionColonneY);
	public Colonne c5 = new Colonne("colonne 5",
			new ArrayList<Carte>(), pos5, positionColonneY);
	public Colonne c6 = new Colonne("colonne 6",
			new ArrayList<Carte>(), pos6, positionColonneY);
	public Colonne c7 = new Colonne("colonne 7",
			new ArrayList<Carte>(), pos7, positionColonneY);
	public Pile p1 = new Pile("pile 1", new ArrayList<Carte>(),
			pos4, positionPilesY);
	public Pile p2 = new Pile("pile 2", new ArrayList<Carte>(),
			pos5, positionPilesY);
	public Pile p3 = new Pile("pile 3", new ArrayList<Carte>(),
			pos6, positionPilesY);
	public Pile p4 = new Pile("pile 4", new ArrayList<Carte>(),
			pos7, positionPilesY);

	// créer un paquet de 52 cartes
	public Solitaire() {
		for (Carte.Couleur coul : Carte.Couleur.values())
			for (int i = 1; i <= 13; i++)
				defausse.liste.add(new Carte(new ImageIcon("Cartes/"
						+ i + coul.toString() + ".jpg"), defausse.posX,
						defausse.posY, coul, i));

		Collections.shuffle(defausse.liste);
		defausse.liste.get(0).ret = true;
		defausse.liste.get(2).ret = true;
		defausse.liste.get(5).ret = true;
		defausse.liste.get(9).ret = true;
		defausse.liste.get(14).ret = true;
		defausse.liste.get(20).ret = true;
		defausse.liste.get(27).ret = true;

		c1.liste.add(defausse.liste.get(0));
		c1.liste.get(0).posX = c1.posX;
		c1.liste.get(0).posY = c1.posY;

		for (int i = 1; i < 3; i++) {
			Carte Carte = defausse.liste.get(i);
			Carte.posX = c2.posX;
			Carte.posY = c2.posY;
			c2.liste.add(Carte);
		}
		for (int i = 3; i < 6; i++) {
			Carte Carte = defausse.liste.get(i);
			Carte.posX = c3.posX;
			Carte.posY = c3.posY;
			c3.liste.add(Carte);
		}
		for (int i = 6; i < 10; i++) {
			Carte Carte = defausse.liste.get(i);
			Carte.posX = c4.posX;
			Carte.posY = c4.posY;
			c4.liste.add(Carte);
		}
		for (int i = 10; i < 15; i++) {
			Carte Carte = defausse.liste.get(i);
			Carte.posX = c5.posX;
			Carte.posY = c5.posY;
			c5.liste.add(Carte);
		}
		for (int i = 15; i < 21; i++) {
			Carte Carte = defausse.liste.get(i);
			Carte.posX = c6.posX;
			Carte.posY = c6.posY;
			c6.liste.add(Carte);
		}
		for (int i = 21; i < 28; i++) {
			Carte Carte = defausse.liste.get(i);
			Carte.posX = c7.posX;
			Carte.posY = c7.posY;
			c7.liste.add(Carte);
		}

		defausse.liste.removeAll(c1.liste);
		defausse.liste.removeAll(c2.liste);
		defausse.liste.removeAll(c3.liste);
		defausse.liste.removeAll(c4.liste);
		defausse.liste.removeAll(c5.liste);
		defausse.liste.removeAll(c6.liste);
		defausse.liste.removeAll(c7.liste);

		c1.Initialiser();
		c2.Initialiser();
		c3.Initialiser();
		c4.Initialiser();
		c5.Initialiser();
		c6.Initialiser();
		c7.Initialiser();

	}

	public boolean Win() {
		return (c1.liste.isEmpty() && c2.liste.isEmpty()
				&& c3.liste.isEmpty() && c4.liste.isEmpty()
				&& c5.liste.isEmpty() && c6.liste.isEmpty()
				&& c7.liste.isEmpty()
				&& defausse.liste.isEmpty() && talon.liste.isEmpty());
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
	
}
