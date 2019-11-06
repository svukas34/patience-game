import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;


public class Pannel_Test extends JPanel implements MouseInputListener {
	
	
 	public ImageIcon _fond;
	public Game _game= new Game();
 	
	int _x=0;
	int _y=0;
	
	
	
    public Pannel_Test() {
    	setSize(815, 600);
    	setBackground(Color.pink);
	
    	_fond = new ImageIcon("src\\Fond1.jpg");		

    	addMouseListener(this);
    	addMouseMotionListener(this);
    }



    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	g.drawImage(_fond.getImage(), 0, 0, this);
    	
    	peindreC(g, _game.C1.Pile);
    	peindreC(g, _game.C2.Pile);
    	peindreC(g, _game.C3.Pile);
    	peindreC(g, _game.C4.Pile);
    	peindreC(g, _game.C5.Pile);
    	peindreC(g, _game.C6.Pile);
    	peindreC(g, _game.C7.Pile);
    	
    	if(!_game.defausse.Pile.isEmpty())
    		g.drawImage(new ImageIcon("0.jpg").getImage(),_game.defausse.Pile.get(0).pox,_game.defausse.Pile.get(0).poy, this);
    	if(!_game.defausse1.Pile.isEmpty())
    		g.drawImage(new ImageIcon("0.jpg").getImage(),_game.defausse1.Pile.get(0).pox,_game.defausse1.Pile.get(0).poy, this);
    	
    	if(!_game.defausse1.Pile.isEmpty())
    		g.drawImage((_game.defausse1.Pile.get(_game.defausse1.Pile.size() - 1)).img.getImage(),_game.defausse1.Pile.get(_game.defausse1.Pile.size()-1).pox,_game.defausse1.Pile.get(_game.defausse1.Pile.size()-1).poy,this);	
    
    	
    	
    }
    
	public void mouseClicked(MouseEvent e) {//relache sans bouge
		if(sourieCarte(e,25,25))
			_game.ajouterCarteDefausse();
		
		repaint();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {//rentre dans la fenetre
	}

	@Override
	public void mouseExited(MouseEvent e) {//sortie de la fenetre		
	}
	
	public void mousePressed(MouseEvent e) {//j'enfonce la sourie
		_x=e.getX();
		_y=e.getY();
	}
	
	public void mouseReleased(MouseEvent e) {//relache la sourie
		//pas fini
	//	if(!_game.carte.memeCouleur(_game.C1.Pile.get(0)))
		repaint();
	}

	
	public void mouseDragged(MouseEvent e) {//clique + deplace la sourie
		deplaceCarte(e, colonne(e,_x,_y).Pile);
		repaint();
	}

	public void mouseMoved(MouseEvent e) {//deplace
	} 
	
	public void deplaceCarte(MouseEvent e, ArrayList<Carte> list){
		list.get(list.size()-1).pox = e.getX();
		list.get(list.size()-1).poy = e.getY();
		
	} 

	public boolean sourieCarte(MouseEvent e, int posx, int posy){
		return(e.getX()<=posx+75+20 && e.getX()>=posx-20 && e.getY()<=posy+75+20 && e.getY()>=posy-20);	
	}
	
    public void peindreC(Graphics g, ArrayList<Carte> l ){
    for(int i=0; i<l.size();i++)
		if(l.get(i).ret)
			g.drawImage(l.get(i).img.getImage(),l.get(i).pox,l.get(i).poy, this);
		else
			g.drawImage(new ImageIcon("0.jpg").getImage(),l.get(i).pox,l.get(i).poy, this);
    }

    public Colonne colonne(MouseEvent e,int posx, int posy){
    	if(sourieCarte(e,_game.C1.Pile.get(_game.C1.Pile.size()-1).pox,_game.C1.Pile.get(_game.C1.Pile.size()-1).poy)) return _game.C1;
    	else if(sourieCarte(e,_game.C2.Pile.get(_game.C2.Pile.size()-1).pox,_game.C2.Pile.get(_game.C2.Pile.size()-1).poy)) return _game.C2;
    	else if(sourieCarte(e,_game.C3.Pile.get(_game.C3.Pile.size()-1).pox,_game.C3.Pile.get(_game.C3.Pile.size()-1).poy)) return _game.C3;
    	else if(sourieCarte(e,_game.C4.Pile.get(_game.C4.Pile.size()-1).pox,_game.C4.Pile.get(_game.C4.Pile.size()-1).poy)) return _game.C4;
    	else if(sourieCarte(e,_game.C5.Pile.get(_game.C5.Pile.size()-1).pox,_game.C5.Pile.get(_game.C5.Pile.size()-1).poy)) return _game.C5;
    	else if(sourieCarte(e,_game.C6.Pile.get(_game.C6.Pile.size()-1).pox,_game.C6.Pile.get(_game.C6.Pile.size()-1).poy)) return _game.C6;
    	else if(sourieCarte(e,_game.C7.Pile.get(_game.C7.Pile.size()-1).pox,_game.C7.Pile.get(_game.C7.Pile.size()-1).poy)) return _game.C7;
    	else return _game.defausse1;
    } 

}
