package Patience;

import java.util.ArrayList;




public class Jeu {
	public ArrayList<Colonne> listeDeColonnes = new ArrayList<Colonne>();
	public ArrayList<Pile> listeDePiles = new ArrayList<Pile>();
	
	int Ecart = 30;
	int Hauteur = 100;
	int Largeur = 75;
	
	ArrayList<Carte> listeDeplacement = new ArrayList<Carte>();
	
	Colonne cA0 = new Colonne("Autour Aucune colonne", new ArrayList<Carte>(),-20,-20);	
	Colonne c0 = new Colonne("Sur Aucune colonne", new ArrayList<Carte>(),-20,-20);
	Pile p0 = new Pile("Autour aucune pile", new ArrayList<Carte>(),-20,-20);
	
	
	
	public Colonne positionSurQuelleColonne(Position pos) {
		for (int i = 0; i < listeDeColonnes.size(); i++){
			if (listeDeColonnes.get(i).positionEstDessus(pos))
				return listeDeColonnes.get(i);
		}
		return c0;
	}	
	
	public Colonne positionAutourQuelleColonne(Position pos, Position PremierClique){
		for (int i = 0; i < listeDeColonnes.size(); i++){
			if (listeDeColonnes.get(i).positionEstAutour(pos, PremierClique))
				return listeDeColonnes.get(i);
		}
		return cA0;
	}
	
	public Pile positionAutourQuellePile(Position pos, Position PremierClique){	
		for (int i = 0; i < listeDePiles.size(); i++){
			if (listeDePiles.get(i).positionEstAutour(pos, PremierClique))
				return listeDePiles.get(i);
		}
		return p0;
	}
	
	public void deplaceListe(int x, int y, ArrayList<Carte> l, Position preC, int refX, int refY){
		int cst = 0;
		for (int i = 0; i< l.size(); i++){
			l.get(i).posX = x-preC.getX() + refX;
			l.get(i).posY = y-preC.getY() + refY + Ecart*cst;
			cst++;
		}
	}

	public ArrayList<Carte> quelleListeDeplacer(TasDeCartes c, Position p){
		if (!positionSurQuelleColonne(p).equals(c0)){
			int rang = c.positionSurQuelleRangDeCarte(p);
			ArrayList<Carte> l = new ArrayList<Carte>(c.liste.size() - rang);
			for (int i = rang; i< c.liste.size(); i++){
				l.add(c.liste.get(i));
			}
			return l;
		} else return new ArrayList<Carte>();
	}
	
	
	public boolean draggable(ArrayList<Carte> l){
		if (listeDeplacement.size() != 0){
			return(l.get(0).ret);
		} else { return false; }
	}

	

}
