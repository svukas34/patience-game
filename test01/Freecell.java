
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class Freecell {
	int pEcartY = 30;

	int positionPilesY = 25;
	int positionColonneY = 200;

	int pos1 = 25;
	int pos2 = 125;
	int pos3 = 225;
	int pos4 = 325;
	int pos5 = 425;
	int pos6 = 525;
	int pos7 = 625;
	int pos8 = 725;

	public TasDeCartes defausse = new TasDeCartes("defausse",
			new ArrayList<Carte>(), pos1, positionPilesY);
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
	public TasDeCartes c8 = new TasDeCartes("colonne 8",
			new ArrayList<Carte>(), pos8, positionColonneY);
	public TasDeCartes p1 = new TasDeCartes("case 1", new ArrayList<Carte>(1),
			pos1, positionPilesY);
	public TasDeCartes p2 = new TasDeCartes("case 2", new ArrayList<Carte>(1),
			pos2, positionPilesY);
	public TasDeCartes p3 = new TasDeCartes("case 3", new ArrayList<Carte>(1),
			pos3, positionPilesY);
	public TasDeCartes p4 = new TasDeCartes("case 4", new ArrayList<Carte>(1),
			pos4, positionPilesY);
	public TasDeCartes p5 = new TasDeCartes("pile 1", new ArrayList<Carte>(),
			pos5, positionPilesY);
	public TasDeCartes p6 = new TasDeCartes("pile 2", new ArrayList<Carte>(),
			pos6, positionPilesY);
	public TasDeCartes p7 = new TasDeCartes("pile 3", new ArrayList<Carte>(),
			pos7, positionPilesY);
	public TasDeCartes p8 = new TasDeCartes("pile 4", new ArrayList<Carte>(),
			pos8, positionPilesY);

	// creer un paquet de 52 cartes
	public Freecell() {
		for (Carte.Couleur coul : Carte.Couleur.values())
			for (int i = 1; i <= 13; i++) {
				defausse.listeDeCartes.add(new Carte(new ImageIcon("Cartes/"
						+ i + coul.toString() + ".jpg"), defausse.posX,
						defausse.posY, coul, i, true));
			}

		Collections.shuffle(defausse.listeDeCartes);

		for (int i = 1; i < 8; i++) {
			Carte Carte = defausse.listeDeCartes.get(i - 1);
			Carte.posX = c1.posX;
			Carte.posY = c1.posY;
			c1.listeDeCartes.add(Carte);
		}
		for (int i = 8; i < 15; i++) {
			Carte Carte = defausse.listeDeCartes.get(i - 1);
			Carte.posX = c2.posX;
			Carte.posY = c2.posY;
			c2.listeDeCartes.add(Carte);
		}
		for (int i = 15; i < 22; i++) {
			Carte Carte = defausse.listeDeCartes.get(i - 1);
			Carte.posX = c3.posX;
			Carte.posY = c3.posY;
			c3.listeDeCartes.add(Carte);
		}
		for (int i = 22; i < 29; i++) {
			Carte Carte = defausse.listeDeCartes.get(i - 1);
			Carte.posX = c4.posX;
			Carte.posY = c4.posY;
			c4.listeDeCartes.add(Carte);
		}
		for (int i = 29; i < 35; i++) {
			Carte Carte = defausse.listeDeCartes.get(i - 1);
			Carte.posX = c5.posX;
			Carte.posY = c5.posY;
			c5.listeDeCartes.add(Carte);
		}
		for (int i = 35; i < 41; i++) {
			Carte Carte = defausse.listeDeCartes.get(i - 1);
			Carte.posX = c6.posX;
			Carte.posY = c6.posY;
			c6.listeDeCartes.add(Carte);
		}
		for (int i = 41; i < 47; i++) {
			Carte Carte = defausse.listeDeCartes.get(i - 1);
			Carte.posX = c7.posX;
			Carte.posY = c7.posY;
			c7.listeDeCartes.add(Carte);
		}
		for (int i = 47; i < 53; i++) {
			Carte Carte = defausse.listeDeCartes.get(i - 1);
			Carte.posX = c8.posX;
			Carte.posY = c8.posY;
			c8.listeDeCartes.add(Carte);
		}

		defausse.listeDeCartes.removeAll(c1.listeDeCartes);
		defausse.listeDeCartes.removeAll(c2.listeDeCartes);
		defausse.listeDeCartes.removeAll(c3.listeDeCartes);
		defausse.listeDeCartes.removeAll(c4.listeDeCartes);
		defausse.listeDeCartes.removeAll(c5.listeDeCartes);
		defausse.listeDeCartes.removeAll(c6.listeDeCartes);
		defausse.listeDeCartes.removeAll(c7.listeDeCartes);
		defausse.listeDeCartes.removeAll(c8.listeDeCartes);

		InitColonne(c1);
		InitColonne(c2);
		InitColonne(c3);
		InitColonne(c4);
		InitColonne(c5);
		InitColonne(c6);
		InitColonne(c7);
		InitColonne(c8);

	}

	public void InitColonne(TasDeCartes c) {
		for (int i = 1; i < c.listeDeCartes.size(); i++) {
			Carte carte = c.listeDeCartes.get(i);
			carte.posY = c.posY + i * 30;
		}
	}

	public boolean Win() {
		return (c1.listeDeCartes.isEmpty() && c2.listeDeCartes.isEmpty()
				&& c3.listeDeCartes.isEmpty() && c4.listeDeCartes.isEmpty()
				&& c5.listeDeCartes.isEmpty() && c6.listeDeCartes.isEmpty()
				&& c7.listeDeCartes.isEmpty() && c8.listeDeCartes.isEmpty()
				&& p1.listeDeCartes.isEmpty() && p2.listeDeCartes.isEmpty()
				&& p3.listeDeCartes.isEmpty() && p4.listeDeCartes.isEmpty());
	}

	public boolean ajouterListeColonnePossible(ArrayList<Carte> l,
			TasDeCartes colonne) {
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
	}

	public void ajouterListeColonne(ArrayList<Carte> l, TasDeCartes colonne,
			TasDeCartes colonneOrigine) {
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
				Carte LastCarte = colonne.listeDeCartes.get(colonne.listeDeCartes.size() - 1);
				for (int i = 0; i < l.size(); i++) {
					l.get(i).posX = LastCarte.posX;
					l.get(i).posY = LastCarte.posY + pEcartY * (i+1);
				}
				colonne.listeDeCartes.addAll(l);
				colonneOrigine.listeDeCartes.removeAll(l);
			}
		}
	}

	public boolean ajouterCartePilePossible(ArrayList<Carte> l, TasDeCartes pile) {
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
	}

	public void ajouterCartePile(ArrayList<Carte> l, TasDeCartes pile,
			TasDeCartes colonneOrigine) {
		if (ajouterCartePilePossible(l, pile) == true) {
			l.get(0).posX = pile.posX;
			l.get(0).posY = pile.posY;
			pile.listeDeCartes.addAll(l);
			colonneOrigine.listeDeCartes.removeAll(l);
		}
	}

	public boolean ajouterCarteCasePossible(ArrayList<Carte> l, TasDeCartes Case) {
		if (l.size() == 1) {
			if (Case.listeDeCartes.isEmpty())
				return true;
			else
				return false;
		} else
			return false;
	}

	public void ajouterCarteCase(ArrayList<Carte> l, TasDeCartes Case,
			TasDeCartes colonneOrigine) {
		if (ajouterCarteCasePossible(l, Case) == true) {
			l.get(0).posX = Case.posX;
			l.get(0).posY = Case.posY;
			Case.listeDeCartes.addAll(l);
			colonneOrigine.listeDeCartes.removeAll(l);
		}
	}
}
