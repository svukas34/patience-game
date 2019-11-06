package PackagePremier;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panneau extends JPanel {

	//ecart verticale entre 2 carte dans une colone	
		int pEcartY = 30;
			
	//taille de la carte	
		int dx = 75;
		int dy = 100;
		
	//distance entre 2 TasDeCartes
		int dpx = 39;
		int dpy = 75;
			
	//position de la souris lors du 1er clique avant mouvX / mouvY
		Position preC = new Position();
		
	//position de la carte lors du 1er clique	
		Position card = new Position();
		
	//position de la carte lors du "dernier clique"	
		Position derC = new Position();
		
	TasDeCartes ColonneOrigine = new TasDeCartes();
	ArrayList<Carte> listeDeplacement = new ArrayList<Carte>();
	
	public void peindreP(Graphics g, ArrayList<Carte> l){
		if (l.isEmpty() == false)
			g.drawImage(l.get(l.size()-1).img.getImage(),l.get(0).posX, l.get(0).posY, 75,100, this);
	}
	
	public void peindreC(Graphics g, ArrayList<Carte> l) {
		for (int i = 0; i < l.size(); i++)
			if (l.get(i).ret)
				g.drawImage(l.get(i).img.getImage(), l.get(i).posX, l.get(i).posY, 75, 100, this);
			else
				g.drawImage(new ImageIcon("Cartes/0.jpg").getImage(),l.get(i).posX, l.get(i).posY, 75, 100, this);
	}
	
	//retourne vrai si la souris est sur la colonne c
	public boolean sourisSurColonne(Position e, TasDeCartes c) {
		if (c.listeDeCartes.isEmpty() == true) {
			return false;
		} else {
			return (positionSurElement(c.posX, c.posY, dx, ((c.listeDeCartes.size() - 1)*pEcartY)+dy, e.getX(), e.getY()) == true);
		}

	}
	
	//retourne 0 si position y sur la premiere carte, size-1 si sur derneire
	public int sourisSurQuelleRangDeCarte(int y, TasDeCartes c){
		for (int i = 0; i<c.listeDeCartes.size()-1; i++){
			if (y < i*pEcartY + pEcartY+c.posY)
				return i;
		} return c.listeDeCartes.size()-1;
	}
	
	public ArrayList<Carte> quelleListeDeplacer(TasDeCartes c, int x, int y){
		int rang = sourisSurQuelleRangDeCarte(y, c);
		ArrayList<Carte> liste = new ArrayList<Carte>(c.listeDeCartes.size() - rang);
		for (int i = rang; i< c.listeDeCartes.size(); i++){
			liste.add(c.listeDeCartes.get(i));
		}
		return liste;
	}

	public void deplaceListe(int x, int y, ArrayList<Carte> l){
		int cst = 0;
		for (int i = 0; i< l.size(); i++){
			l.get(i).posX = x-preC.getX() + card.getX();
			l.get(i).posY = y-preC.getY() + card.getY() + pEcartY*cst;
			cst++;
		}
	} 

	public boolean draggable(ArrayList<Carte> l){
		if (listeDeplacement.size() != 0){
			return(l.get(0).ret);
		} else { return false; }
	}

	//retourne vrai si x € {Ex,Ex+dx} et y € {Ey,Ey+dy}
	public boolean positionSurElement(int Ex, int Ey, int dEx, int dEy, int x, int y){
		return (((x>Ex) && (x<(Ex + dEx))) && (((y>Ey) && (y<(Ey+dEy)))));
	}
		
	//retourne vrai si x € {Ex,Ex+dx} +/- (dpx/2)   et  y € {Ey,Ey+dy} +/- (dpy/2)
	public boolean positionAutourElement(int Ex, int Ey, int dEx, int dEy, int x, int y){
		return (((x>(Ex-(dpx/2))) && (x<(Ex + dEx+(dpx/2)))) && (((y>(Ey-(dpy/2)) && (y<(Ey+dEy+(dpy/2)))))));
	}
	
	//retourne VRAI si le cecntre de la carte est sur la derniere carte de la colone c
	public boolean carteAutourColonne(Position pos, TasDeCartes c) {
		if (c.listeDeCartes.isEmpty() == true)
			return ((positionAutourElement(c.posX, c.posY, dx, dy, pos.getX(), pos.getY())) == true);
		else{
			Carte LastCarte = c.listeDeCartes.get(c.listeDeCartes.size()-1);
			return ((positionAutourElement(LastCarte.posX, LastCarte.posY, dx, dy, pos.getX(), pos.getY())) == true);
		}
	}
		
}
