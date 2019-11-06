package PackagePremier;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Panneau extends JPanel implements MouseMotionListener, MouseListener {
	public ImageIcon fond;
	public ImageIcon win;
	public Game jeu = new Game();

	//taille de la carte	
		int dx = 75;
		int dy = 100;
		
	//distance entre 2 TasDeCartes
		//int dpx = jeu.pos4-(jeu.pos5+dx);
		//int dpy = jeu.positionColonneY-(jeu.positionPilesY+dy);
		int dpx = 39;
		int dpy = 75;
		
	//position de la souris lors du 1er clique avant mouvX / mouvY
		Position preC = new Position();
	//position de la carte lors du 1er clique	
		int refX;
		int refY;
	//position de la carte lors du "dernier clique"	
		Position derC = new Position();
		
	//ecart entre 2 carte dans une colone	
		// int pEcartY = jeu.pEcartY
		int pEcartY = 30;
		
		TasDeCartes ColonneOrigine = new TasDeCartes();
		ArrayList<Carte> listeDeplacement = new ArrayList<Carte>();
	
	TasDeCartes cA0 = new TasDeCartes("Autour Aucune colonne", new ArrayList<Carte>(),-20,-20);	
	TasDeCartes c0 = new TasDeCartes("Sur ucune colonne", new ArrayList<Carte>(),-20,-20);
	TasDeCartes p0 = new TasDeCartes("Autour aucune pile", new ArrayList<Carte>(),-20,-20);

	public Panneau() {
		setSize(815, 600);
		setBackground(Color.ORANGE);
		fond = new ImageIcon("Cartes/Fond1.jpg");
		win = new ImageIcon("Cartes/Je parle meme pas.jpg");

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(fond.getImage(), 0, 0, this);

		g.drawRect(jeu.p1.posX, jeu.p1.posY, dx, dy);
		g.drawRect(jeu.p2.posX, jeu.p2.posY, dx, dy);
		g.drawRect(jeu.p3.posX, jeu.p3.posY, dx, dy);
		g.drawRect(jeu.p4.posX, jeu.p4.posY, dx, dy);
		
		/*if (!jeu.defausse.listeDeCartes.isEmpty())
			g.drawImage(new ImageIcon("Cartes/0.jpg").getImage(),
					jeu.defausse.listeDeCartes.get(0).posX,
					jeu.defausse.listeDeCartes.get(0).posY, 75, 100, this);*/
		/*	if (!jeu.poubelle.listeDeCartes.isEmpty())
			g.drawImage(new ImageIcon("Cartes/0.jpg").getImage(),
				jeu.poubelle.listeDeCartes.get(0).posX,
				jeu.poubelle.listeDeCartes.get(0).posY, 75, 100, this);

		if (!jeu.poubelle.listeDeCartes.isEmpty())
			g.drawImage((jeu.poubelle.listeDeCartes.get(jeu.poubelle.listeDeCartes.size() - 1)).img.getImage(),
					jeu.poubelle.listeDeCartes.get(jeu.poubelle.listeDeCartes.size() - 1).posX, 
					jeu.poubelle.listeDeCartes.get(jeu.poubelle.listeDeCartes.size() - 1).posY, 75, 100, this);
		*/
		peindreP(g, jeu.p1.listeDeCartes);
		peindreP(g, jeu.p2.listeDeCartes);
		peindreP(g, jeu.p3.listeDeCartes);
		peindreP(g, jeu.p4.listeDeCartes);
		
		peindreC(g, jeu.c1.listeDeCartes);
		peindreC(g, jeu.c2.listeDeCartes);
		peindreC(g, jeu.c3.listeDeCartes);
		peindreC(g, jeu.c4.listeDeCartes);
		peindreC(g, jeu.c5.listeDeCartes);
		peindreC(g, jeu.c6.listeDeCartes);
		peindreC(g, jeu.c7.listeDeCartes);
		
		peindreC(g, listeDeplacement);
		
		if (jeu.Win() == true){
			g.drawImage(win.getImage(), 0, 0, this);
		}
		

	}

	/*TCHEKER
	 * public void peindreP(Graphics g, ArrayList<Carte> l){
		if (l.isEmpty() == false)
			g.drawImage(l.get(l.size()-1).img.getImage(),l.get(0).posX, l.get(0).posY, 75,100, this);
	}*/
	
	/*TCHEKER
	 * public void peindreC(Graphics g, ArrayList<Carte> l) {
		for (int i = 0; i < l.size(); i++)
			if (l.get(i).ret)
				g.drawImage(l.get(i).img.getImage(), l.get(i).posX, l.get(i).posY, 75, 100, this);
			else
				g.drawImage(new ImageIcon("Cartes/0.jpg").getImage(),l.get(i).posX, l.get(i).posY, 75, 100, this);
	}*/


	public void mouseClicked(MouseEvent e) {// relache sans bouge
		Position clik = new Position(e.getX(),e.getY());
		if (sourisSurDefausse(clik) == true){
			System.out.println("Souris clique sur defausse");
			jeu.ajouterCartePoubelle();
		}
		if(!sourisSurQuelleColonne(clik).equals(c0)){
			TasDeCartes c = sourisSurQuelleColonne(clik);
			Carte carte = c.listeDeCartes.get(c.listeDeCartes.size()-1);
			if  ((positionSurElement(carte.posX, carte.posY, dx, dy, clik.getX(), clik.getY())) && (carte.ret == false))
				carte.ret = true;
		}
		repaint();
		
		
		//ce qui suit sert a verifier que les methodes sourisSueQuelleColonne, sourisAutourQuellePile 
		//et sourisSurQuelleRangDeCarte fonctionnent correctemnt
		/*if (sourisSurPoubelle(e)==true)
			System.out.println("poubelle");
		if ((sourisSurQuelleColonne(e) != c0) || (sourisAutourQuellePile(e) != c0)){			
			if ( sourisSurQuelleColonne(e) == jeu.c1)
				System.out.println("rang : " +sourisSurQuelleRangDeCarte(e.getY(),sourisSurQuelleColonne(e)) +" et colonne : c1");
			if ( sourisSurQuelleColonne(e) == jeu.c2)
				System.out.println("rang : " +sourisSurQuelleRangDeCarte(e.getY(),sourisSurQuelleColonne(e)) +" et colonne : c2");
			if ( sourisSurQuelleColonne(e) == jeu.c3)
				System.out.println("rang : " +sourisSurQuelleRangDeCarte(e.getY(),sourisSurQuelleColonne(e)) +" et colonne : c3");
			if ( sourisSurQuelleColonne(e) == jeu.c4)
				System.out.println("rang : " +sourisSurQuelleRangDeCarte(e.getY(),sourisSurQuelleColonne(e)) +" et colonne : c4");
			if ( sourisSurQuelleColonne(e) == jeu.c5)
				System.out.println("rang : " +sourisSurQuelleRangDeCarte(e.getY(),sourisSurQuelleColonne(e)) +" et colonne : c5");
			if ( sourisSurQuelleColonne(e) == jeu.c6)
				System.out.println("rang : " +sourisSurQuelleRangDeCarte(e.getY(),sourisSurQuelleColonne(e)) +" et colonne : c6");
			if ( sourisSurQuelleColonne(e) == jeu.c7)
				System.out.println("rang : " +sourisSurQuelleRangDeCarte(e.getY(),sourisSurQuelleColonne(e)) +" et colonne : c7");
			if ( sourisAutourQuellePile(e) == jeu.p1)
				System.out.println("pile : p1");
			if ( sourisAutourQuellePile(e) == jeu.p2)
				System.out.println("pile : p2");
			if ( sourisAutourQuellePile(e) == jeu.p3)
				System.out.println("pile : p3");
			if ( sourisAutourQuellePile(e) == jeu.p4)
				System.out.println("pile : p4");
		}else{
			System.out.println("sur c0");
		}*/
	}

	@Override
	public void mouseEntered(MouseEvent e) {// rentre dans la fenetre
	}

	@Override
	public void mouseExited(MouseEvent e) {// sortie de la fenetre
	}

	public void mousePressed(MouseEvent e) {// j'enfonce la sourie
		preC.setX(e.getX());
		preC.setY(e.getY());
		
		if ((!sourisSurQuelleColonne(preC).equals(c0)) || (sourisSurPoubelle(preC) == true)){
			listeDeplacement.clear();
			
			if (sourisSurPoubelle(preC) == true){
				ColonneOrigine = jeu.poubelle;
				ArrayList<Carte> l = new ArrayList<Carte>(1);
				l.add(jeu.poubelle.listeDeCartes.get(jeu.poubelle.listeDeCartes.size()-1));				
				listeDeplacement = l;
			} else {
				ColonneOrigine = sourisSurQuelleColonne(preC);
				listeDeplacement=quelleListeDeplacer(ColonneOrigine,preC.getX(),preC.getY());
			}
			refX = ColonneOrigine.listeDeCartes.get(sourisSurQuelleRangDeCarte(preC.getY(),ColonneOrigine)).posX;
			refY = ColonneOrigine.listeDeCartes.get(sourisSurQuelleRangDeCarte(preC.getY(),ColonneOrigine)).posY;
			
		}
		//repaint();
		
		
		/*mouvX = e.getX();
		mouvY = e.getY();
		if (sourisSurQuelleColonne(e) == c0){
			System.out.println("sur c0");
		}else{
			tdc = sourisSurQuelleColonne(e);
			refX = tdc.listeDeCartes.get(sourisSurQuelleRangDeCarte(e.getY(),tdc)).posX;
			refY = tdc.listeDeCartes.get(sourisSurQuelleRangDeCarte(e.getY(),tdc)).posY;
			for( int i = sourisSurQuelleRangDeCarte(e.getY(),tdc); i<tdc.listeDeCartes.size(); i++){
				listeDeplacement = tdc.listeDeCartes;
			}
		}
		repaint();*/
	}

	public void mouseReleased(MouseEvent e) {// relache la sourie
		derC.setX(e.getX());
		derC.setY(e.getY());
		
		TasDeCartes c = carteAutourQuelleColonne(derC);
		TasDeCartes p = carteAutourQuellePile(derC);
	
		//if ((!c.equals(c0)) || (!p.equals(p0))) {
		System.out.println("on est sur la " + c.nom + " et sur la " +p.nom);
		//deplaceListe(mouvX,mouvY,listeDeplacement);
		
		if (c.equals(cA0) || p.equals(p0)){
			deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
			repaint();
		}
		
		if (!p.equals(p0)){
			if ((jeu.ajouterCartePilePossible(listeDeplacement,p)) == true ){
				System.out.println("on peut deplacer la liste sur la " + p.nom);
				jeu.ajouterCartePile(listeDeplacement, p, ColonneOrigine);
				repaint();
			}else {
				deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
				repaint();
			}
		}
		if (!c.equals(cA0)){
			if ((jeu.ajouterListeColonnePossible(listeDeplacement, c)) == true ){
				System.out.println("on peut deplacer la liste sur la " + c.nom);
				jeu.ajouterListeColonne(listeDeplacement, c, ColonneOrigine);
				repaint();
			}else {
				deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
				repaint();
			}
		}
		
		listeDeplacement.clear();
		// a vérifier pour le null !!!!!!!!!!!!!!!!!!!!!!!!
		ColonneOrigine = null;		
		preC.setX(0);
		preC.setY(0);
		refX = 0;
		refY =0;
		
		derC.setX(0);
		derC.setY(0);
		
		repaint();

		
		/*
		//if ((sourisAutourQuelleColonne(e) != c0) && (sourisAutourQuellePile(e) != c0)){
			if (carteAutourQuellePile(e) != c0) {
				if (((jeu.ajouterCartePilePossible(listeDeplacement.get(0),carteAutourQuellePile(e))) == true )){
					jeu.ajouterCartePile(listeDeplacement.get(0), carteAutourQuellePile(e), ColonneOrigine);
				} else {
					deplaceListe(mouvX,mouvY,listeDeplacement);
					if (carteAutourQuelleColonne(e) != c0);{
						if (jeu.ajouterListeColonnePossible(listeDeplacement, carteAutourQuelleColonne(e), ColonneOrigine))
							jeu.ajouterListeColonne(listeDeplacement, carteAutourQuelleColonne(e), ColonneOrigine);
						else{
							deplaceListe(mouvX,mouvY,listeDeplacement);
						}
					}
				}
				deplaceListe(mouvX,mouvY,listeDeplacement);
			}
		//}
		repaint();
		*/
		
		
		/*if ((sourisSurQuellePile(e).equals(c0)) && (sourisSurQuelleColonne(e).equals(c0))){
			System.out.println("p0 / c0");
			tdc.posX = refX;
			tdc.posY = refY;
		} else {
			if (tdc.listeDeCartes.size() == 1){
				if(jeu.ajouterCartePilePossible(listeDeplacement.get(0),sourisSurQuellePile(e)) == true)
					jeu.ajouterCartePile(listeDeplacement.get(0), sourisSurQuellePile(e), tdc);
			}
		}
		repaint();*/
	}

	public void mouseDragged(MouseEvent e) {// clique + deplace la sourie
		if (draggable(listeDeplacement) == true) {
			deplaceListe(e.getX(), e.getY(), listeDeplacement);
			repaint();
			derC.setX(e.getX());
			derC.setY(e.getY());
		}
	}

	public void mouseMoved(MouseEvent e) {// deplace
	}

/*TCHEKER
 * 	public boolean draggable(ArrayList<Carte> l){
		if (listeDeplacement.size() != 0){
			return(l.get(0).ret);
		} else { return false; }
	}*/
		
	
/*TCHEKER
 * 	public ArrayList<Carte> quelleListeDeplacer(TasDeCartes c, int x, int y){
		int rang = sourisSurQuelleRangDeCarte(y, c);
		ArrayList<Carte> liste = new ArrayList<Carte>(c.listeDeCartes.size() - rang);
		for (int i = rang; i< c.listeDeCartes.size(); i++){
			liste.add(c.listeDeCartes.get(i));
		}
		return liste;
	}*/
	
	
	/*TCHEKER
	//retourne vrai si x € {Ex,Ex+dx} et y € {Ey,Ey+dy}
	public boolean positionSurElement(int Ex, int Ey, int dEx, int dEy, int x, int y){
			return (((x>Ex) && (x<(Ex + dEx))) && (((y>Ey) && (y<(Ey+dEy)))));
	}
	
	//retourne vrai si x € {Ex,Ex+dx} +/- (dpx/2)   et  y € {Ey,Ey+dy} +/- (dpy/2)
	public boolean positionAutourElement(int Ex, int Ey, int dEx, int dEy, int x, int y){
		return (((x>(Ex-(dpx/2))) && (x<(Ex + dEx+(dpx/2)))) && (((y>(Ey-(dpy/2)) && (y<(Ey+dEy+(dpy/2)))))));
	}
	*/
	
	
/*	public void deplaceListe(int x, int y, ArrayList<Carte> l){
		int cst = 0;
		for (int i = 0; i< l.size(); i++){
			l.get(i).posX = x-preC.getX() + refX;
			l.get(i).posY = y-preC.getY() + refY + pEcartY*cst;
			cst++;
		}*/
	//	c1.pileDeCartes.get(0).posX = e.getX()-mouvX + refX;
	//	c1.pileDeCartes.get(1).posX = e.getX()-mouvX + refX;
	//	c1.pileDeCartes.get(0).posY = e.getY()-mouvY + refY;
	//	c1.pileDeCartes.get(1).posY = e.getY() + pEcartColonneY-mouvY + refY;
	} 

	/*TCHEKER
	 //retourne vrai si la souris est sur la colonne c
	public boolean sourisSurColonne(Position e, TasDeCartes c) {
		if (c.listeDeCartes.isEmpty() == true) {
			return false;
		} else {
			return (positionSurElement(c.posX, c.posY, dx, ((c.listeDeCartes.size() - 1)*pEcartY)+dy, e.getX(), e.getY()) == true);
		}

	}
*/
	
/*TCHEKER
 * 	//retourne c0 si la souris n'est sur aucune colonne sinon c1, c2, c3 ...
	public TasDeCartes sourisSurQuelleColonne(Position e) {
		if (sourisSurColonne(e, jeu.c1))
			return jeu.c1;
		else if (sourisSurColonne(e, jeu.c2))
			return jeu.c2;
		else if (sourisSurColonne(e, jeu.c3))
			return jeu.c3;
		else if (sourisSurColonne(e, jeu.c4))
			return jeu.c4;
		else if (sourisSurColonne(e, jeu.c5))
			return jeu.c5;
		else if (sourisSurColonne(e, jeu.c6))
			return jeu.c6;
		else if (sourisSurColonne(e, jeu.c7))
			return jeu.c7;
		else
			return c0;
	}*/

/* TCHERKER
	//retourne VRAI si le cecntre de la carte est sur la derniere carte de la colone c
	public boolean carteAutourColonne(Position pos, TasDeCartes c) {
		if (c.listeDeCartes.isEmpty() == true)
			return (positionAutourElement(c.posX, c.posY, dx, dy, /*convertirPositionSourisCentreCarteX(/pos.getX(/)/), /*convertirPositionSourisCentreCarteY(/pos.getY()/)/) == true);
		else{
			Carte LastCarte = c.listeDeCartes.get(c.listeDeCartes.size()-1);
			return (positionAutourElement(LastCarte.posX, LastCarte.posY, dx, dy, /*convertirPositionSourisCentreCarteX(/pos.getX()/*)/, /*convertirPositionSourisCentreCarteY(/pos.getY()/*)/) == true);
		}
		
	}*/
	
/*TCHEKER
 * 	//retourne c0 si la position n'est AUTOUR d'aucune derniere carte de colonnes, sinon c1, c2, c3 ...
	public TasDeCartes carteAutourQuelleColonne(Position pos){
		
		if (carteAutourColonne(pos, jeu.c1) == true)
			if (ColonneOrigine != jeu.c1)
				return jeu.c1;
		if (carteAutourColonne(pos, jeu.c2) == true)
			if (ColonneOrigine != jeu.c2)
				return jeu.c2;
		if (carteAutourColonne(pos, jeu.c3) == true)
			if (ColonneOrigine != jeu.c3)
				return jeu.c3;
		if (carteAutourColonne(pos, jeu.c4) == true)
			if (ColonneOrigine != jeu.c4)
				return jeu.c4;
		if (carteAutourColonne(pos, jeu.c5) == true)
			if (ColonneOrigine != jeu.c5)
				return jeu.c5;
		if (carteAutourColonne(pos, jeu.c6) == true)
			if (ColonneOrigine != jeu.c6)
				return jeu.c6;
		if (carteAutourColonne(pos, jeu.c7) == true)
			if (ColonneOrigine != jeu.c7)
				return jeu.c7;
		return this.cA0;
	}*/
														
/*TCHEKER	
 * //retourne 0 si position y sur la premiere carte, size-1 si sur derneire
	public int sourisSurQuelleRangDeCarte(int y, TasDeCartes c){
		for (int i = 0; i<c.listeDeCartes.size()-1; i++){
			if (y < i*pEcartY + pEcartY+c.posY)
				return i;
		} return c.listeDeCartes.size()-1;
	}*/


/*TCHEKER
	 * //retourne VRAI si la carte est autour de la pile p
	public boolean carteAutourDeLaPile(Position pos, TasDeCartes p){
		return (positionAutourElement(p.posX, p.posY, dx, dy, /*convertirPositionSourisCentreCarteX(/pos.getX()/*)/, /*convertirPositionSourisCentreCarteY(/pos.getY()/*)/) == true);
	}*/

/*TCHEKER
 * 	//retourne c0 si la carte n'est AUTOUR d'aucune pile, sinon p1, p2, p3 ...
	public TasDeCartes carteAutourQuellePile(Position pos){
		if (carteAutourDeLaPile(pos, jeu.p1))
			return jeu.p1;
		else if (carteAutourDeLaPile(pos, jeu.p2))
			return jeu.p2;
		else if (carteAutourDeLaPile(pos, jeu.p3))
			return jeu.p3;
		else if (carteAutourDeLaPile(pos, jeu.p4))
			return jeu.p4;
		else 
			return p0; 
	}*/

/*TCHEKER
 * 	public boolean sourisSurPoubelle(Position e){
		return(positionSurElement(jeu.poubelle.posX, jeu.poubelle.posY, dx, dy, e.getX(), e.getY()));
	}*/
	
/*TCHEKER
 * 	public boolean sourisSurDefausse(Position e){
		return(positionSurElement(jeu.defausse.posX, jeu.defausse.posY, dx, dy, e.getX(), e.getY()));
	}*/

	/*public int convertirPositionSourisCentreCarteX(int psx){
		return (psx - (psx - refX) + dx/2);
	}
	
	public int convertirPositionSourisCentreCarteY(int psy){
		return (psy - (psy - refX) + dx/2);
	}*/
	
}