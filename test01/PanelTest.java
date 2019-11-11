
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelTest extends JPanel implements MouseMotionListener,MouseListener {

	
	public TasDeCartes c1 = new TasDeCartes("c1",new ArrayList<Carte>(), 25, 200);

	
//taille de la carte	
	int dx = 75;
	int dy = 100;
	
//position de la souris lors du 1er clique
	int mouvX;
	int mouvY;
//position de la carte lors du 1er clique	
	int refX;
	int refY;
	
//ecart entre 2 carte dans une colone	
	int pEcartY = 30;
	
	public PanelTest(){
		setSize(815, 600);
		setBackground(Color.ORANGE);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		c1.listeDeCartes.add(new Carte(new ImageIcon("Cartes/1C.jpg"), c1.posX, c1.posY, Carte.Couleur.C, 1));
		c1.listeDeCartes.add(new Carte(new ImageIcon("Cartes/13P.jpg"), c1.posX, c1.posY+30, Carte.Couleur.P, 13));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		peindreC(g, c1.listeDeCartes);
		
	}
	
	public void peindreC(Graphics g, ArrayList<Carte> l) {
		for (int i = 0; i < l.size(); i++)
				g.drawImage(l.get(i).img.getImage(), l.get(i).posX, l.get(i).posY, 75, 100, this);
	}
	
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	//	if((e.getX()>=c1.posX) && (e.getX()<=c1.posX+dx)){
	//	if ((e.getY()>=c1.posY) && (e.getY()<=c1.posY+dy))
	//			System.out.println("dans la carte");
			mouvX = e.getX();
			mouvY = e.getY();
			refX = c1.listeDeCartes.get(0).posX;
			refY = c1.listeDeCartes.get(0).posY;
	//	}
	}

	public void mouseReleased(MouseEvent e) {
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		deplaceTasDeCartes(e, c1);
		repaint();
	}
	public void deplaceTasDeCartes(MouseEvent e, TasDeCartes c1){
		c1.listeDeCartes.get(0).posX = e.getX()-mouvX + refX;
		c1.listeDeCartes.get(1).posX = e.getX()-mouvX + refX;
		c1.listeDeCartes.get(0).posY = e.getY()-mouvY + refY;
		c1.listeDeCartes.get(1).posY = e.getY() + pEcartY-mouvY + refY;
	} 
	
	public void mouseMoved(MouseEvent e) {
	}

}
