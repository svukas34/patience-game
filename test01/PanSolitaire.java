
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanSolitaire extends Panneau implements MouseMotionListener, MouseListener {
	
	public Solitaire jeu = new Solitaire();
		
	
	TasDeCartes cA0 = new TasDeCartes("Autour Aucune colonne", new ArrayList<Carte>(),-20,-20);	
	TasDeCartes c0 = new TasDeCartes("Sur ucune colonne", new ArrayList<Carte>(),-20,-20);
	TasDeCartes p0 = new TasDeCartes("Autour aucune pile", new ArrayList<Carte>(),-20,-20);

	public PanSolitaire() {
		setSize(815, 600);
		setBackground(Color.ORANGE);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(new ImageIcon(Fenetre.Fond+".jpg").getImage(), 0, 0, this);

		g.drawRect(jeu.p1.posX, jeu.p1.posY, dx, dy);
		g.drawRect(jeu.p2.posX, jeu.p2.posY, dx, dy);
		g.drawRect(jeu.p3.posX, jeu.p3.posY, dx, dy);
		g.drawRect(jeu.p4.posX, jeu.p4.posY, dx, dy);
		
		g.drawRect(jeu.poubelle.posX, jeu.poubelle.posY, dx, dy);
		
		g.drawRect(jeu.c1.posX, jeu.c1.posY, dx, dy);
		g.drawRect(jeu.c2.posX, jeu.c2.posY, dx, dy);
		g.drawRect(jeu.c3.posX, jeu.c3.posY, dx, dy);
		g.drawRect(jeu.c4.posX, jeu.c4.posY, dx, dy);
		g.drawRect(jeu.c5.posX, jeu.c5.posY, dx, dy);
		g.drawRect(jeu.c6.posX, jeu.c6.posY, dx, dy);
		g.drawRect(jeu.c7.posX, jeu.c7.posY, dx, dy);
		
		if (!jeu.defausse.listeDeCartes.isEmpty())
			g.drawImage(new ImageIcon("Cartes/"+Fenetre.Carte+".jpg").getImage(),
					jeu.defausse.listeDeCartes.get(0).posX,
					jeu.defausse.listeDeCartes.get(0).posY, 75, 100, this);
			if (!jeu.poubelle.listeDeCartes.isEmpty())
				g.drawImage(new ImageIcon("Cartes/"+Fenetre.Carte+".jpg").getImage(),
				jeu.poubelle.listeDeCartes.get(0).posX,
				jeu.poubelle.listeDeCartes.get(0).posY, 75, 100, this);

		if (!jeu.poubelle.listeDeCartes.isEmpty())
			g.drawImage((jeu.poubelle.listeDeCartes.get(jeu.poubelle.listeDeCartes.size() - 1)).img.getImage(),
					jeu.poubelle.listeDeCartes.get(jeu.poubelle.listeDeCartes.size() - 1).posX, 
					jeu.poubelle.listeDeCartes.get(jeu.poubelle.listeDeCartes.size() - 1).posY, 75, 100, this);
		
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
		
		if (jeu.Win()){
			g.drawImage(new ImageIcon(Fenetre.Gagne+".jpg").getImage(), 0, 0, this);
		}
		
		if(jeu.erreur!=0)
			afficheErreur(g);
		}

	public void afficheErreur(Graphics g){
		if(jeu.erreur==1)
			g.drawImage(new ImageIcon("DNA1.png").getImage(),1,467 , this);
		else if(jeu.erreur==2)
			g.drawImage(new ImageIcon("DNA2.png").getImage(),1,440 , this);
		else if(jeu.erreur==3)
			g.drawImage(new ImageIcon("DNA3.png").getImage(),1,450 , this);
		else if(jeu.erreur==4)
			g.drawImage(new ImageIcon("DNA4.png").getImage(),1,453 , this);
		else if(jeu.erreur==5)
			g.drawImage(new ImageIcon("DNA5.png").getImage(),1,485 , this);
		else if(jeu.erreur==6)
			g.drawImage(new ImageIcon("DNA6.png").getImage(),0,470 , this);

		jeu.erreur=0;
	}


	public void mouseClicked(MouseEvent e) {
		Position clik = new Position(e.getX(),e.getY());
		if (sourisSurDefausse(clik) == true){
			jeu.ajouterCartePoubelle();
		}
		if(!sourisSurQuelleColonne(clik).equals(c0)){
			TasDeCartes c = sourisSurQuelleColonne(clik);
			Carte carte = c.listeDeCartes.get(c.listeDeCartes.size()-1);
			if  ((positionSurElement(carte.posX, carte.posY, dx, dy, clik.getX(), clik.getY())) && (carte.ret == false))
				carte.ret = true;
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
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
			card.setX(ColonneOrigine.listeDeCartes.get(sourisSurQuelleRangDeCarte(preC.getY(),ColonneOrigine)).posX);
			card.setY(ColonneOrigine.listeDeCartes.get(sourisSurQuelleRangDeCarte(preC.getY(),ColonneOrigine)).posY);
			
		}
	}

	public void mouseReleased(MouseEvent e) {
		derC.setX(e.getX());
		derC.setY(e.getY());
		
		TasDeCartes c = carteAutourQuelleColonne(derC);
		TasDeCartes p = carteAutourQuellePile(derC);
		
		if (c.equals(cA0) || p.equals(p0)){
			deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
			repaint();
		}
		
		if (!p.equals(p0)){
			if ((jeu.ajouterCartePilePossible(listeDeplacement,p)) == true ){
				jeu.ajouterCartePile(listeDeplacement, p, ColonneOrigine);
				repaint();
			}else {
				deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
				repaint();
			}
		}
		if (!c.equals(cA0)){
			if ((jeu.ajouterListeColonnePossible(listeDeplacement, c)) == true ){
				jeu.ajouterListeColonne(listeDeplacement, c, ColonneOrigine);
				repaint();
			}else {
				deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
				repaint();
			}
		}
		
		listeDeplacement.clear();
		ColonneOrigine = c0;		
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

	public void mouseMoved(MouseEvent e) {// deplace
	}
	
	

  	//retourne c0 si la souris n'est sur aucune colonne sinon c1, c2, c3 ...
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
	}


  	//retourne c0 si la position n'est AUTOUR d'aucune derniere carte de colonnes, sinon c1, c2, c3 ...
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
	}
													



	 //retourne VRAI si la carte est autour de la pile p
	public boolean carteAutourDeLaPile(Position pos, TasDeCartes p){
		return ((positionAutourElement(p.posX, p.posY, dx, dy, pos.getX(),pos.getY())) == true);
	}


 	//retourne c0 si la carte n'est AUTOUR d'aucune pile, sinon p1, p2, p3 ...
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
	}

 	public boolean sourisSurPoubelle(Position e){
		return(positionSurElement(jeu.poubelle.posX, jeu.poubelle.posY, dx, dy, e.getX(), e.getY()));
	}
	
 	public boolean sourisSurDefausse(Position e){
		return(positionSurElement(jeu.defausse.posX, jeu.defausse.posY, dx, dy, e.getX(), e.getY()));
	}	
}