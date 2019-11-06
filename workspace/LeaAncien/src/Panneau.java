
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Panneau extends JPanel implements MouseMotionListener, MouseListener {
	public Game jeu = new Game();
	
	//taille de la carte	
		int dx = 75;
		int dy = 100;
		
	//distance entre 2 TasDeCartes
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
		int pEcartY = 10; /*30*/
		
		TasDeCartes ColonneOrigine = new TasDeCartes();
		ArrayList<Carte> listeDeplacement = new ArrayList<Carte>();
	
	TasDeCartes cA0 = new TasDeCartes("Autour Aucune colonne", new ArrayList<Carte>(),-20,-20);	
	TasDeCartes c0 = new TasDeCartes("Sur ucune colonne", new ArrayList<Carte>(),-20,-20);
	TasDeCartes p0 = new TasDeCartes("Autour aucune pile", new ArrayList<Carte>(),-20,-20);

	public Panneau() {
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
			g.drawImage(new ImageIcon("Cartes1/"+Fenetre.Carte+".jpg").getImage(),
					jeu.defausse.listeDeCartes.get(0).posX,
					jeu.defausse.listeDeCartes.get(0).posY, 75, 100, this);
			if (!jeu.poubelle.listeDeCartes.isEmpty())
			g.drawImage(new ImageIcon("Cartes1/"+Fenetre.Carte+".jpg").getImage(),
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

	public void peindreP(Graphics g, ArrayList<Carte> l){
		if (!l.isEmpty())
			g.drawImage(l.get(l.size()-1).img.getImage(),l.get(0).posX, l.get(0).posY, 75,100, this);
	}
	
	public void peindreC(Graphics g, ArrayList<Carte> l) {
		for (int i = 0; i < l.size(); i++)
			if (l.get(i).ret)
				g.drawImage(l.get(i).img.getImage(), l.get(i).posX, l.get(i).posY, 75, 100, this);
			else
				g.drawImage(new ImageIcon("Cartes1/"+Fenetre.Carte+".jpg").getImage(),l.get(i).posX, l.get(i).posY, 75, 100, this);
	}


	public void mouseClicked(MouseEvent e) {// relache sans bouge
		Position clik = new Position(e.getX(),e.getY());
		if (sourisSurDefausse(clik)){
			System.out.println("Souris clique sur defausse");
			jeu.ajouterCartePoubelle();
		}
		if(!sourisSurQuelleColonne(clik).equals(c0)){
			TasDeCartes c = sourisSurQuelleColonne(clik);
			Carte carte = c.listeDeCartes.get(c.listeDeCartes.size()-1);
			if  ((positionSurElement(carte.posX, carte.posY, dx, dy, clik.getX(), clik.getY())) && (!carte.ret))
				carte.ret = true;
		}
		repaint();
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {// j'enfonce la sourie
		preC.setX(e.getX());
		preC.setY(e.getY());
		
		if ((!sourisSurQuelleColonne(preC).equals(c0)) || (sourisSurPoubelle(preC))){
			listeDeplacement.clear();
			
			if (sourisSurPoubelle(preC)){
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
	}

	public void mouseReleased(MouseEvent e) {// relache la sourie
		derC.setX(e.getX());
		derC.setY(e.getY());
		
		TasDeCartes c = carteAutourQuelleColonne(derC);
		TasDeCartes p = carteAutourQuellePile(derC);
	
		System.out.println("on est sur la " + c.nom + " et sur la " +p.nom);
		
		if (c.equals(cA0) || p.equals(p0)){
			deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
			repaint();
		}
		
		if (!p.equals(p0)){
			if ((jeu.ajouterCartePilePossible(listeDeplacement,p))){
				System.out.println("on peut deplacer la liste sur la p" + p.nom);
				jeu.ajouterCartePile(listeDeplacement, p, ColonneOrigine);
				repaint();
			}else{
				deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
				repaint();
			}
		}
		if (!c.equals(cA0)){
			if ((jeu.ajouterListeColonnePossible(listeDeplacement, c))){
				System.out.println("on peut deplacer la liste sur la " + c.nom);
				jeu.ajouterListeColonne(listeDeplacement, c, ColonneOrigine);
				repaint();
			}else {
				deplaceListe(preC.getX(),preC.getY(),listeDeplacement);
				repaint();
			}
		}
		
		listeDeplacement.clear();
		
		ColonneOrigine = null;		
		preC.setX(0);
		preC.setY(0);
		refX = 0;
		refY =0;
		
		derC.setX(0);
		derC.setY(0);
		
		repaint();
	}
	
	// affiche un msg d'erreur

	public void mouseDragged(MouseEvent e) {// clique + deplace la sourie
		if (draggable(listeDeplacement)) {
			deplaceListe(e.getX(), e.getY(), listeDeplacement);
			repaint();
			derC.setX(e.getX());
			derC.setY(e.getY());
		}
	}

	public void mouseMoved(MouseEvent e) {}

	public boolean draggable(ArrayList<Carte> l){
		if (listeDeplacement.size() != 0){
			return(l.get(0).ret);
		} else { return false; }
	}
		
	
	public ArrayList<Carte> quelleListeDeplacer(TasDeCartes c, int x, int y){
		int rang = sourisSurQuelleRangDeCarte(y, c);
		ArrayList<Carte> liste = new ArrayList<Carte>(c.listeDeCartes.size() - rang);
		for (int i = rang; i< c.listeDeCartes.size(); i++)
			liste.add(c.listeDeCartes.get(i));
		
		return liste;
	}
	
	//retourne vrai si x € {Ex,Ex+dx} et y € {Ey,Ey+dy}
	public boolean positionSurElement(int Ex, int Ey, int dEx, int dEy, int x, int y){
			return (((x>Ex) && (x<(Ex + dEx))) && (((y>Ey) && (y<(Ey+dEy)))));
	}
	
	//retourne vrai si x € {Ex,Ex+dx} +/- (dpx/2)   et  y € {Ey,Ey+dy} +/- (dpy/2)
	public boolean positionAutourElement(int Ex, int Ey, int dEx, int dEy, int x, int y){
		return (((x>(Ex-(dpx/2))) && (x<(Ex + dEx+(dpx/2)))) && (((y>(Ey-(dpy/2)) && (y<(Ey+dEy+(dpy/2)))))));
	}
	
	public void deplaceListe(int x, int y, ArrayList<Carte> l){
		int cst = 0;
		for (int i = 0; i< l.size(); i++){
			l.get(i).posX = x-preC.getX() + refX;
			l.get(i).posY = y-preC.getY() + refY + pEcartY*cst;
			cst++;
		}
	} 

	//retourne vrai si la souris est sur la colonne c
	public boolean sourisSurColonne(Position e, TasDeCartes c) {
		if (c.listeDeCartes.isEmpty())
			return false;
		else
			return (positionSurElement(c.posX, c.posY, dx, ((c.listeDeCartes.size() - 1)*pEcartY)+dy, e.getX(), e.getY()) == true);
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

	//retourne VRAI si le cecntre de la carte est sur la derniere carte de la colone c
	public boolean carteAutourColonne(Position pos, TasDeCartes c) {
		if (c.listeDeCartes.isEmpty())
			return (positionAutourElement(c.posX, c.posY, dx, dy, pos.getX(), pos.getY()) == true);
		else{
			Carte LastCarte = c.listeDeCartes.get(c.listeDeCartes.size()-1);
			return (positionAutourElement(LastCarte.posX, LastCarte.posY, dx, dy, pos.getX(), pos.getY()) == true);
		}
		
	}
	
	//retourne c0 si la position n'est AUTOUR d'aucune derniere carte de colonnes, sinon c1, c2, c3 ...
	public TasDeCartes carteAutourQuelleColonne(Position pos){
		
		if (carteAutourColonne(pos, jeu.c1))
			if (ColonneOrigine != jeu.c1)
				return jeu.c1;
		if (carteAutourColonne(pos, jeu.c2))
			if (ColonneOrigine != jeu.c2)
				return jeu.c2;
		if (carteAutourColonne(pos, jeu.c3))
			if (ColonneOrigine != jeu.c3)
				return jeu.c3;
		if (carteAutourColonne(pos, jeu.c4))
			if (ColonneOrigine != jeu.c4)
				return jeu.c4;
		if (carteAutourColonne(pos, jeu.c5))
			if (ColonneOrigine != jeu.c5)
				return jeu.c5;
		if (carteAutourColonne(pos, jeu.c6))
			if (ColonneOrigine != jeu.c6)
				return jeu.c6;
		if (carteAutourColonne(pos, jeu.c7))
			if (ColonneOrigine != jeu.c7)
				return jeu.c7;
		return this.cA0;
	}
														
	//retourne 0 si position y sur la premiere carte, size-1 si sur derneire
	public int sourisSurQuelleRangDeCarte(int y, TasDeCartes c){
		for (int i = 0; i<c.listeDeCartes.size()-1; i++)
			if (y < i*pEcartY + pEcartY+c.posY)
				return i;
		
		return c.listeDeCartes.size()-1;
						
		}

	//retourne VRAI si la carte est autour de la pile p
	public boolean carteAutourDeLaPile(Position pos, TasDeCartes p){
		return (positionAutourElement(p.posX, p.posY, dx, dy,pos.getX(),pos.getY()) == true);
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