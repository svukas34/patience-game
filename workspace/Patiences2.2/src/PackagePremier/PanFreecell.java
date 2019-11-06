package PackagePremier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PanFreecell extends Panneau implements MouseMotionListener, MouseListener {
	public ImageIcon fond;
	public ImageIcon win;
	public Freecell jeu = new Freecell();
	
	
	
	
	
	TasDeCartes c0 = new TasDeCartes("Sur ucune colonne", new ArrayList<Carte>(),-20,-20);
	TasDeCartes p0 = new TasDeCartes("Autour aucune pile", new ArrayList<Carte>(),-20,-20);


	public PanFreecell() {
		setSize(815, 600);
		setBackground(Color.GREEN);
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
		g.drawRect(jeu.p5.posX, jeu.p5.posY, dx, dy);
		g.drawRect(jeu.p6.posX, jeu.p6.posY, dx, dy);
		g.drawRect(jeu.p7.posX, jeu.p7.posY, dx, dy);
		g.drawRect(jeu.p8.posX, jeu.p8.posY, dx, dy);
		
		peindreP(g, jeu.p1.listeDeCartes);
		peindreP(g, jeu.p2.listeDeCartes);
		peindreP(g, jeu.p3.listeDeCartes);
		peindreP(g, jeu.p4.listeDeCartes);
		peindreP(g, jeu.p5.listeDeCartes);
		peindreP(g, jeu.p6.listeDeCartes);
		peindreP(g, jeu.p7.listeDeCartes);
		peindreP(g, jeu.p8.listeDeCartes);
		
		peindreC(g, jeu.c1.listeDeCartes);
		peindreC(g, jeu.c2.listeDeCartes);
		peindreC(g, jeu.c3.listeDeCartes);
		peindreC(g, jeu.c4.listeDeCartes);
		peindreC(g, jeu.c5.listeDeCartes);
		peindreC(g, jeu.c6.listeDeCartes);
		peindreC(g, jeu.c7.listeDeCartes);
		peindreC(g, jeu.c8.listeDeCartes);
		
		peindreC(g, listeDeplacement);
		
		if (jeu.Win() == true){
			g.drawImage(win.getImage(), 0, 0, this);
		}
	}

	
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		preC.setX(e.getX());
		preC.setY(e.getY());
		
			if (!sourisSurQuelleCase(preC).equals(p0)){
				TasDeCartes p = sourisSurQuelleCase(preC);
				if (!p.listeDeCartes.isEmpty()){
					listeDeplacement.clear();
					ColonneOrigine = p;
					ArrayList<Carte> l = new ArrayList<Carte>(1);
					l.add(p.listeDeCartes.get(0));				
					listeDeplacement = l;
					card.setX(ColonneOrigine.listeDeCartes.get(sourisSurQuelleRangDeCarte(e.getY(),ColonneOrigine)).posX);
					card.setY(ColonneOrigine.listeDeCartes.get(sourisSurQuelleRangDeCarte(e.getY(),ColonneOrigine)).posY);
				}
			}
			if (!sourisSurQuelleColonne(preC).equals(c0)){ 
				listeDeplacement.clear();
				ColonneOrigine = sourisSurQuelleColonne(preC);
				listeDeplacement=quelleListeDeplacer(ColonneOrigine,e.getX(),e.getY());
				card.setX(ColonneOrigine.listeDeCartes.get(sourisSurQuelleRangDeCarte(e.getY(),ColonneOrigine)).posX);
				card.setY(ColonneOrigine.listeDeCartes.get(sourisSurQuelleRangDeCarte(e.getY(),ColonneOrigine)).posY);
			}
		}

	public void mouseReleased(MouseEvent e) {
		derC.setX(e.getX());
		derC.setY(e.getY());
		
		TasDeCartes c = sourisSurQuelleColonne(derC);
		TasDeCartes p = sourisSurQuellePile(derC);
		TasDeCartes pc = sourisSurQuelleCase(derC);

		
		if (c.equals(c0) || p.equals(p0)){
			deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
			repaint();
		}
		
		if (!p.equals(p0)){
			if (!pc.equals(p0)){
				if(jeu.ajouterCarteCasePossible(listeDeplacement, pc) == true)
					jeu.ajouterCarteCase(listeDeplacement, pc, ColonneOrigine);
			}else {
				if ((jeu.ajouterCartePilePossible(listeDeplacement,p)) == true ){
					jeu.ajouterCartePile(listeDeplacement, p, ColonneOrigine);
					repaint();
				}else {
					deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
					repaint();
				}
			}
		}
		if (!c.equals(c0)){
			if ((jeu.ajouterListeColonnePossible(listeDeplacement, c)) == true ){
				System.out.println("on peut deplacer la liste sur la " + c.nom);
				jeu.ajouterListeColonne(listeDeplacement, c, ColonneOrigine);;
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
		card.setX(0);
		card.setY(0);
		
		derC.setX(0);
		derC.setY(0);
		
		repaint();
	}

	public void mouseDragged(MouseEvent e) {// clique + deplace la sourie
		if (draggable(listeDeplacement) == true) {
			deplaceListe(e.getX(), e.getY(), listeDeplacement);
			repaint();
			derC.setX(e.getX());
			derC.setY(e.getY());
		}
	}

	public void mouseMoved(MouseEvent e) {}
	
	public boolean sourisSurPile(Position e, TasDeCartes p){
		return positionSurElement(p.posX, p.posY, dx, dy, e.getX(), e.getY());
	}
	
	public TasDeCartes sourisSurQuelleCase(Position e) {
		if (sourisSurPile(e, jeu.p1))
			return jeu.p1;
		else if (sourisSurPile(e, jeu.p2))
			return jeu.p2;
		else if (sourisSurPile(e, jeu.p3))
			return jeu.p3;
		else if (sourisSurPile(e, jeu.p4))
			return jeu.p4;
		else return p0;
	}
	
	public TasDeCartes sourisSurQuellePile(Position e){
		if (sourisSurPile(e, jeu.p1))
			return jeu.p1;
		else if (sourisSurPile(e, jeu.p2))
			return jeu.p2;
		else if (sourisSurPile(e, jeu.p3))
			return jeu.p3;
		else if (sourisSurPile(e, jeu.p4))
			return jeu.p4;
		else if (sourisSurPile(e, jeu.p5))
			return jeu.p5;
		else if (sourisSurPile(e, jeu.p6))
			return jeu.p6;
		else if (sourisSurPile(e, jeu.p7))
			return jeu.p7;
		else if (sourisSurPile(e, jeu.p8))
			return jeu.p8;
		else return p0;
	}

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
		else if (sourisSurColonne(e, jeu.c8))
			return jeu.c8;
		return c0;
	}


}
