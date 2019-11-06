package Patience;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanSolitaire extends Panneau implements MouseMotionListener, MouseListener {

	Solitaire jeu = new Solitaire();
	
	public PanSolitaire() {
		setSize(815, 600);
		setBackground(Color.ORANGE);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(fond.getImage(), 0, 0, this);

		g.drawRect(jeu.p1.posX, jeu.p1.posY, Largeur, Hauteur);
		g.drawRect(jeu.p2.posX, jeu.p2.posY, Largeur, Hauteur);
		g.drawRect(jeu.p3.posX, jeu.p3.posY, Largeur, Hauteur);
		g.drawRect(jeu.p4.posX, jeu.p4.posY, Largeur, Hauteur);
		
		jeu.defausse.peindre(g, face, this);
		jeu.talon.peindre(g, face, this);
		
		for(int i=0; i<jeu.listeDePiles.size(); i++){
			jeu.listeDePiles.get(i).peindre(g,this);
		}
		
		for(int i=0; i<jeu.listeDeColonnes.size(); i++){
			jeu.listeDeColonnes.get(i).peindre(g,face,this);
		}

		peindreC(g, listeDeplacement);
		
		if (jeu.Win() == true){
			g.drawImage(win.getImage(), 0, 0, this);
		}
	}
	
	//A ENLEVER :	
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
		if(!positionSurQuelleColonne(clik).equals(c0)){
			TasDeCartes c = positionSurQuelleColonne(clik);
			Carte carte = c.LastCarte;
			
			if  ((clik.surElement(carte.posX, carte.posY, Largeur, Hauteur)) && (carte.ret == false))
				carte.ret = true;
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
		
		if ((!positionSurQuelleColonne(preC).equals(c0)) || (jeu.talon.positionEstDessus(preC) == true)){
			listeDeplacement.clear();
			
			if (jeu.talon.positionEstDessus(preC) == true){
				ColonneOrigine = jeu.talon;
				ArrayList<Carte> l = new ArrayList<Carte>(1);
				l.add(jeu.talon.liste.get(jeu.talon.liste.size()-1));				
				listeDeplacement = l;
			} else {
				ColonneOrigine = positionSurQuelleColonne(preC);
				listeDeplacement = quelleListeDeplacer(ColonneOrigine,preC);
			}
			refX = ColonneOrigine.liste.get(ColonneOrigine.positionSurQuelleRangDeCarte(preC)).posX;
			refY = ColonneOrigine.liste.get(ColonneOrigine.positionSurQuelleRangDeCarte(preC)).posY;
			
		}
	}

	public void mouseReleased(MouseEvent e) {
		derC.setX(e.getX());
		derC.setY(e.getY());
		
		Colonne c = positionAutourQuelleColonne(derC, preC);
		Pile p = positionAutourQuellePile(derC, preC);
	
		//if ((!c.equals(c0)) || (!p.equals(p0))) {
		System.out.println("on est sur la " + c.nom + " et sur la " +p.nom);
		//deplaceListe(mouvX,mouvY,listeDeplacement);
		
		if (c.equals(cA0) || p.equals(p0)){
			deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
			repaint();
		}
		
		if (!p.equals(p0)){
			if ((p.ajouterCartePossible(listeDeplacement)) == true ){
				System.out.println("on peut deplacer la liste sur la " + p.nom);
				p.ajouterCarte(listeDeplacement, ColonneOrigine);
				repaint();
			}else {
				deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
				repaint();
			}
		}
		if (!c.equals(cA0)){
			if ((c.ajouterListePossible(listeDeplacement)) == true ){
				System.out.println("on peut deplacer la liste sur la " + c.nom);
				c.ajouterListe(listeDeplacement, ColonneOrigine);
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
	}

	public void mouseDragged(MouseEvent e) {
		if (draggable(listeDeplacement) == true) {
			deplaceListe(e.getX(), e.getY(), listeDeplacement);
			repaint();
			derC.setX(e.getX());
			derC.setY(e.getY());
		}
	}

	public void mouseMoved(MouseEvent e) { }
	

}
