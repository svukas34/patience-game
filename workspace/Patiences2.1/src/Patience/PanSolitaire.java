package Patience;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class PanSolitaire extends JPanel implements MouseMotionListener, MouseListener {
	public ImageIcon fond;
	public ImageIcon win;
	public ImageIcon face;
	public int Ecart = 30;
	
	Solitaire jeu = new Solitaire();
	
	int Hauteur = 100;
	int Largeur = 75;
	
	//position de la souris lors du 1er clique avant mouvX / mouvY
	Position preC = new Position();
	//position de la carte lors du 1er clique	
	int refX;
	int refY;
	//position de la carte lors du "dernier clique"	
	Position derC = new Position();
		
		TasDeCartes ColonneOrigine = new TasDeCartes();
		ArrayList<Carte> listeDeplacement = jeu.listeDeplacement;
	
	TasDeCartes cA0 = new TasDeCartes("Autour Aucune colonne", new ArrayList<Carte>(),-20,-20);	
	TasDeCartes c0 = new TasDeCartes("Sur ucune colonne", new ArrayList<Carte>(),-20,-20);
	TasDeCartes p0 = new TasDeCartes("Autour aucune pile", new ArrayList<Carte>(),-20,-20);

	
	
	public PanSolitaire() {
		super();
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

		g.drawRect(jeu.p1.posX, jeu.p1.posY, Hauteur, Largeur);
		g.drawRect(jeu.p2.posX, jeu.p2.posY, Hauteur, Largeur);
		g.drawRect(jeu.p3.posX, jeu.p3.posY, Hauteur, Largeur);
		g.drawRect(jeu.p4.posX, jeu.p4.posY, Hauteur, Largeur);
		
		if (!jeu.defausse.liste.isEmpty())
			g.drawImage(new ImageIcon("Cartes/0.jpg").getImage(),
					jeu.defausse.liste.get(0).posX,
					jeu.defausse.liste.get(0).posY, 75, 100, this);
		
		if (!jeu.talon.liste.isEmpty())
			g.drawImage(new ImageIcon("Cartes/0.jpg").getImage(),
				jeu.talon.liste.get(0).posX,
				jeu.talon.liste.get(0).posY, 75, 100, this);

		if (!jeu.talon.liste.isEmpty())
			g.drawImage((jeu.talon.liste.get(jeu.talon.liste.size() - 1)).img.getImage(),
					jeu.talon.liste.get(jeu.talon.liste.size() - 1).posX, 
					jeu.talon.liste.get(jeu.talon.liste.size() - 1).posY, 75, 100, this);
					
		peindreP(g, jeu.p1.liste);
		peindreP(g, jeu.p2.liste);
		peindreP(g, jeu.p3.liste);
		peindreP(g, jeu.p4.liste);
		
		peindreC(g, jeu.c1.liste);
		peindreC(g, jeu.c2.liste);
		peindreC(g, jeu.c3.liste);
		peindreC(g, jeu.c4.liste);
		peindreC(g, jeu.c5.liste);
		peindreC(g, jeu.c6.liste);
		peindreC(g, jeu.c7.liste);
		
		peindreC(g, listeDeplacement);
		
		if (jeu.Win() == true){
			g.drawImage(win.getImage(), 0, 0, this);
		}
		

	}

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


	public void mouseClicked(MouseEvent e) {// relache sans bouge
		Position clik = new Position(e.getX(),e.getY());
		if (jeu.defausse.positionEstDessus(clik) == true){
			System.out.println("Souris clique sur defausse");
			jeu.talon.ajouterCarte(jeu.defausse);
		}
		if(!jeu.positionSurQuelleColonne(clik).equals(c0)){
			TasDeCartes c = jeu.positionSurQuelleColonne(clik);
			Carte LastCarte = c.liste.get(c.liste.size()-1);
			if  ((clik.surElement(LastCarte.posX, LastCarte.posY, Largeur, Hauteur)) && (LastCarte.ret == false))
				LastCarte.ret = true;
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}

	public void mousePressed(MouseEvent e) {
		preC.setX(e.getX());
		preC.setY(e.getY());
		
		if ((!jeu.positionSurQuelleColonne(preC).equals(c0)) || (jeu.talon.positionEstDessus(preC) == true)){
			listeDeplacement.clear();
			
			if (jeu.talon.positionEstDessus(preC) == true){
				ColonneOrigine = jeu.talon;
				ArrayList<Carte> l = new ArrayList<Carte>(1);
				l.add(jeu.talon.liste.get(jeu.talon.liste.size()-1));				
				listeDeplacement = l;
			} else {
				ColonneOrigine = jeu.positionSurQuelleColonne(preC);
				listeDeplacement = jeu.quelleListeDeplacer(ColonneOrigine,preC);
			}
			refX = ColonneOrigine.liste.get(ColonneOrigine.positionSurQuelleRangDeCarte(preC)).posX;
			refY = ColonneOrigine.liste.get(ColonneOrigine.positionSurQuelleRangDeCarte(preC)).posY;
			
		}
	}

	public void mouseReleased(MouseEvent e) {
		derC.setX(e.getX());
		derC.setY(e.getY());
		
		Colonne c = jeu.positionAutourQuelleColonne(derC, preC);
		Pile p = jeu.positionAutourQuellePile(derC, preC);
	
		//if ((!c.equals(c0)) || (!p.equals(p0))) {
		System.out.println("on est sur la " + c.nom + " et sur la " +p.nom);
		//deplaceListe(mouvX,mouvY,listeDeplacement);
		
		if (c.equals(cA0) || p.equals(p0)){
			jeu.deplaceListe(preC.getX(),preC.getY(),listeDeplacement, preC, refX, refY);
			repaint();
		}
		
		if (!p.equals(p0)){
			if ((p.ajouterCartePossible(listeDeplacement)) == true ){
				System.out.println("on peut deplacer la liste sur la " + p.nom);
				p.ajouterCarte(listeDeplacement, ColonneOrigine);
				repaint();
			}else {
				jeu.deplaceListe(preC.getX(),preC.getY(),listeDeplacement,preC, refX, refY);
				repaint();
			}
		}
		if (!c.equals(cA0)){
			if ((c.ajouterListePossible(listeDeplacement)) == true ){
				System.out.println("on peut deplacer la liste sur la " + c.nom);
				c.ajouterListe(listeDeplacement, ColonneOrigine);
				repaint();
			}else {
				jeu.deplaceListe(preC.getX(),preC.getY(),listeDeplacement, preC, refX, refY);
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
	}

	public void mouseDragged(MouseEvent e) {
		if (jeu.draggable(listeDeplacement) == true) {
			jeu.deplaceListe(e.getX(), e.getY(), listeDeplacement, preC, refX, refY);
			repaint();
			derC.setX(e.getX());
			derC.setY(e.getY());
		}
	}

	public void mouseMoved(MouseEvent e) { }
	

}