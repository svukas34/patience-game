package Patience;

import java.util.ArrayList;


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
	
	
	
	public PaquetDeCartes pdc = new PaquetDeCartes(1);
	
	
	public Solitaire(){
		
		
		listeDeColonnes.add(c1);
		listeDeColonnes.add(c2);
		listeDeColonnes.add(c3);
		listeDeColonnes.add(c4);
		listeDeColonnes.add(c5);
		listeDeColonnes.add(c6);
		listeDeColonnes.add(c7);
		
		listeDePiles.add(p1);
		listeDePiles.add(p2);
		listeDePiles.add(p3);
		listeDePiles.add(p4);
		
		/*int cst = 0;
		for ( int i = 0; i < listeDeColonnes.size() ; i++){
			for ( int j = cst; j < cst + i + 1; j++){
				pdc.retourner(cst);
				Carte carte = pdc.listeDeCartes.get(i);
				carte.posX = listeDeColonnes.get(i).posX;
				listeDeColonnes.get(i).liste.add(carte);
				if ( j == cst + i )
					cst = j + 1;
			}
			listeDeColonnes.get(i).Initialiser();
		}*/
		
		pdc.listeDeCartes.get(0).ret = true;
		pdc.listeDeCartes.get(2).ret = true;
		pdc.listeDeCartes.get(5).ret = true;
		pdc.listeDeCartes.get(9).ret = true;
		pdc.listeDeCartes.get(14).ret = true;
		pdc.listeDeCartes.get(20).ret = true;
		pdc.listeDeCartes.get(27).ret = true;

		c1.liste.add(pdc.listeDeCartes.get(0));
		c1.liste.get(0).posX = c1.posX;
		c1.liste.get(0).posY = c1.posY;

		for (int i = 1; i < 3; i++) {
			Carte Carte = pdc.listeDeCartes.get(i);
			Carte.posX = c2.posX;
			Carte.posY = c2.posY;
			c2.liste.add(Carte);
		}
		for (int i = 3; i < 6; i++) {
			Carte Carte = pdc.listeDeCartes.get(i);
			Carte.posX = c3.posX;
			Carte.posY = c3.posY;
			c3.liste.add(Carte);
		}
		for (int i = 6; i < 10; i++) {
			Carte Carte = pdc.listeDeCartes.get(i);
			Carte.posX = c4.posX;
			Carte.posY = c4.posY;
			c4.liste.add(Carte);
		}
		for (int i = 10; i < 15; i++) {
			Carte Carte = pdc.listeDeCartes.get(i);
			Carte.posX = c5.posX;
			Carte.posY = c5.posY;
			c5.liste.add(Carte);
		}
		for (int i = 15; i < 21; i++) {
			Carte Carte = pdc.listeDeCartes.get(i);
			Carte.posX = c6.posX;
			Carte.posY = c6.posY;
			c6.liste.add(Carte);
		}
		for (int i = 21; i < 28; i++) {
			Carte Carte = pdc.listeDeCartes.get(i);
			Carte.posX = c7.posX;
			Carte.posY = c7.posY;
			c7.liste.add(Carte);
		}
		
		
		
		
		for (int i = 28; i < 52 + 1; i++) {
		//for (int i = cst; i < pdc.listeDeCartes.size() + 1; i++) {
			Carte carte = pdc.listeDeCartes.get(i);
			carte.posX = defausse.posX;
			carte.posY = defausse.posY;
			defausse.liste.add(carte);
		}
	}


	public boolean Win() {
		return (c1.liste.isEmpty() && c2.liste.isEmpty()
				&& c3.liste.isEmpty() && c4.liste.isEmpty()
				&& c5.liste.isEmpty() && c6.liste.isEmpty()
				&& c7.liste.isEmpty()
				&& defausse.liste.isEmpty() && talon.liste
					.isEmpty());
	}
	
}