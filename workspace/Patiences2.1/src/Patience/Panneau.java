/*package Patience;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panneau extends JPanel {
	
	public ImageIcon fond;
	public ImageIcon win;
	public ImageIcon face;
	public int Ecart = 30;
	
	Jeu jeu = new Jeu();
	
	int Hauteur = 100;
	int Largeur = 75;
	
	public ArrayList<Colonne> listeDeColonnes;
	public ArrayList<Pile> listeDePiles;
	
	//position de la souris lors du 1er clique avant mouvX / mouvY
	Position preC = new Position();
	//position de la carte lors du 1er clique	
	int refX;
	int refY;
	//position de la carte lors du "dernier clique"	
	Position derC = new Position();
	
	TasDeCartes ColonneOrigine = new TasDeCartes();
	ArrayList<Carte> listeDeplacement = new ArrayList<Carte>();
	
	
	Colonne cA0 = new Colonne("Autour Aucune colonne", new ArrayList<Carte>(),-20,-20);	
	Colonne c0 = new Colonne("Sur Aucune colonne", new ArrayList<Carte>(),-20,-20);
	Pile p0 = new Pile("Autour aucune pile", new ArrayList<Carte>(),-20,-20);
	
	public Panneau() {
		this.listeDeColonnes = jeu.listeDeColonnes;
		this.listeDePiles = jeu.listeDePiles;
		setSize(815, 600);
		setBackground(Color.ORANGE);
		fond = new ImageIcon("Cartes/Fond1.jpg");
		win = new ImageIcon("Cartes/Je parle meme pas.jpg");
		face = new ImageIcon("Cartes/Back.jpg");
	}

	
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
	
	public void deplaceListe(int x, int y, ArrayList<Carte> l){
		int cst = 0;
		for (int i = 0; i< l.size(); i++){
			l.get(i).posX = x-preC.getX() + refX;
			l.get(i).posY = y-preC.getY() + refY + Ecart*cst;
			cst++;
		}
	}

	public ArrayList<Carte> quelleListeDeplacer(TasDeCartes c, Position p){
		int rang = c.positionSurQuelleRangDeCarte(p);
		ArrayList<Carte> liste = new ArrayList<Carte>(c.liste.size() - rang);
		for (int i = rang; i< c.liste.size(); i++){
			liste.add(c.liste.get(i));
		}
		return liste;
	}
	
	public boolean draggable(ArrayList<Carte> l){
		if (listeDeplacement.size() != 0){
			return(l.get(0).ret);
		} else { return false; }
	}

}*/
