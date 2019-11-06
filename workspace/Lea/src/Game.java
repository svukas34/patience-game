import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class Game {

	public Colonne defausse = new Colonne(new ArrayList<Carte>(), 10, 25);
	public Colonne defausse1 = new Colonne(new ArrayList<Carte>(), 85, 25);
	public Colonne C1 = new Colonne(new ArrayList<Carte>(), 25, 190);
	public Colonne C2 = new Colonne(new ArrayList<Carte>(), 100, 190);
	public Colonne C3 = new Colonne(new ArrayList<Carte>(), 175, 190);
	public Colonne C4 = new Colonne(new ArrayList<Carte>(), 250, 190);
	public Colonne C5 = new Colonne(new ArrayList<Carte>(), 325, 190);
	public Colonne C6 = new Colonne(new ArrayList<Carte>(), 400, 190);
	public Colonne C7 = new Colonne(new ArrayList<Carte>(), 475, 190);
	public Colonne R1 = new Colonne(new ArrayList<Carte>(), 250, 25);
	public Colonne R2 = new Colonne(new ArrayList<Carte>(), 325, 25);
	public Colonne R3 = new Colonne(new ArrayList<Carte>(), 400, 25);
	public Colonne R4 = new Colonne(new ArrayList<Carte>(), 475, 25);

	// créer un paquet de 52 cartes
	public Game() {
		for (Carte.Couleur coul : Carte.Couleur.values())
			for (int i = 1; i <= 13; i++)
				defausse.Pile.add(new Carte(new ImageIcon(coul.toString() + i), defausse.posx, defausse.posy, coul, i));

		Collections.shuffle(defausse.Pile);
		defausse.Pile.get(0).ret = true;
		defausse.Pile.get(2).ret = true;
		defausse.Pile.get(5).ret = true;
		defausse.Pile.get(9).ret = true;
		defausse.Pile.get(14).ret = true;
		defausse.Pile.get(20).ret = true;
		defausse.Pile.get(27).ret = true;

		C1.Pile.add(defausse.Pile.get(0));
		C1.Pile.get(0).pox = C1.posx;
		C1.Pile.get(0).poy = C1.posy;

		for (int i = 1; i < 3; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C2.posx;
			Carte.poy = C2.posy;
			C2.Pile.add(Carte);
		}
		for (int i = 3; i < 6; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C3.posx;
			Carte.poy = C3.posy;
			C3.Pile.add(Carte);
		}
		for (int i = 6; i < 10; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C4.posx;
			Carte.poy = C4.posy;
			C4.Pile.add(Carte);
		}
		for (int i = 10; i < 15; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C5.posx;
			Carte.poy = C5.posy;
			C5.Pile.add(Carte);
		}
		for (int i = 15; i < 21; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C6.posx;
			Carte.poy = C6.posy;
			C6.Pile.add(Carte);
		}
		for (int i = 21; i < 28; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C7.posx;
			Carte.poy = C7.posy;
			C7.Pile.add(Carte);
		}

		defausse.Pile.removeAll(C1.Pile);
		defausse.Pile.removeAll(C2.Pile);
		defausse.Pile.removeAll(C3.Pile);
		defausse.Pile.removeAll(C4.Pile);
		defausse.Pile.removeAll(C5.Pile);
		defausse.Pile.removeAll(C6.Pile);
		defausse.Pile.removeAll(C7.Pile);

		InitColonne(C1);
		InitColonne(C2);
		InitColonne(C3);
		InitColonne(C4);
		InitColonne(C5);
		InitColonne(C6);
		InitColonne(C7);
	}

	public void InitColonne(Colonne c) {
		for (int i = 1; i < c.Pile.size(); i++) {
			Carte carte = c.Pile.get(i);
			carte.poy = c.posy + i * 10;
		}
	}

	public boolean Win() {
		return (C1.Pile.isEmpty() && C2.Pile.isEmpty() && C3.Pile.isEmpty()
				&& C4.Pile.isEmpty() && C5.Pile.isEmpty() && C6.Pile.isEmpty()
				&& C7.Pile.isEmpty() && defausse.Pile.isEmpty() && defausse1.Pile
					.isEmpty());
	}

	/*
	 * ? public void ajouterCarteDefausse(Carte Carte) { if
	 * (!defausse.Pile.isEmpty()) { Carte LastCarte =
	 * defausse.Pile.get(defausse.Pile.size() - 1);
	 * 
	 * //?? LastCarte.poy = defausse1.posy; LastCarte.pox = defausse1.posx;
	 * 
	 * defausse.Pile.add(LastCarte); defausse1.Pile.remove(LastCarte); } }
	 */

	public void ajouterCarteC(Carte carte, Colonne colonne, Colonne colonneOrigine) {
		//?? Carte LastCarte = colonne.Pile.get(colonne.Pile.size());

		// ?? if (carte.couleur.equals(Carte.Couleur.P)) // si couleur opposée :
		// OK else NOK
		if (carte.memeCouleur(colonne.Pile.get(colonne.Pile.size())) == false) {
			carte.pox = colonne.posx;

			if (colonne.Pile.isEmpty())
				carte.poy = colonne.posy;
			else {
				carte.poy = colonne.Pile.get(colonne.Pile.size() - 1).poy + 10;
			}
			colonne.Pile.add(carte);

			colonneOrigine.Pile.remove(carte);
		}
	}

	public void ajouterCarteR(Carte carte, Colonne colonne, Colonne colonneOrigine) {
		Carte LastCarte = colonne.Pile.get(colonne.Pile.size());

		// switch par couleur
		if (carte.couleur.equals(LastCarte.couleur)) {
			carte.pox = colonne.posx;
			carte.poy = colonne.posy;
			colonne.Pile.add(carte);
			colonneOrigine.Pile.remove(carte);
		}
	}

}
