import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

import java.text.AttributedCharacterIterator;
import java.util.*;

@SuppressWarnings("serial")
class Pannel extends JPanel  implements MouseMotionListener, MouseListener{
	
	
 	public ImageIcon fond;
	
 	public Game c= new Game();
 	
	int bouge=0;
	
	
	
    public Pannel() {
	setSize(815, 600);
	setBackground(Color.pink);
	
	fond = new ImageIcon("src\\Fond1.jpg");
	
	addMouseListener(this);
    addMouseMotionListener(this);
	
    } 
    
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	g.drawImage(fond.getImage(), 0, 0, this);
    	for(int i=0; i<52; i++){
    		if(!clic3[i])
    			g.drawImage(new ImageIcon("src\\0.jpg").getImage(), posX2[i], posY2[i], this);
    		else 
    			g.drawImage(img2.get(i).getImage(), posX2[i], posY2[i], this);
    	}
    		//redessine la carte qu on est en train de bouger
    	g.drawImage(img2.get(bouge).getImage(), posX2[bouge], posY2[bouge], this);
   	}   
    
    public void mousePressed(MouseEvent e){ //s active quand j'enfonce la souris
    	for(int i=0; i<52; i++){
    		if(posX2[i]<=e.getX()&&posX2[i]+75>=e.getX()&&posY2[i]<=e.getY()&&posY2[i]+108>=e.getY()){
    			bouge=i;
    		}
    	}
      }
    
    public void mouseDragged(MouseEvent e){//s active quand la souris est enfoncé et qu on la bouge
    	repaint();
    }
    
    public void mouseReleased(MouseEvent e){//s active quand je lache la souris apres l'avoir bouge
		repaint();
	}
	
    public void mouseClicked(MouseEvent e) {//s active quand je lache
    	repaint();
    }
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
     
    	//permet de faire défiler la defausse
    public void chgPositionDefausse(MouseEvent e, int i){
    	if(e.getX()<=100 && e.getX()>=25 && e.getY()>=25 && e.getY()<=125&&def==0){
			for(int j=0; j<24; j++){
				posX2[j]=25;
				posX3[j]=25;
				clic3[j]=false;
				def=25;
				repaint();
			}
		}
    	if(e.getX()<=100 && e.getX()>=25 && e.getY()>=25 && e.getY()<=125&&def<=24){
			posX2[def-1]=120;
			posX3[def-1]=120;	
			repaint();
    	} 
    }
    
    	//permet de 
    public void deplaceCarteDef(MouseEvent e, int i){
    	if(e.getX()<=120+75 && e.getX()>=120 && e.getY()>=24 && e.getY()<=24+100){
    		clic2[i]=false;
    		posX2[i]=posX3[i];
    		posY2[i]=posY3[i];
    		clic2[def]=true;
    		posX2[def]=e.getX();
    		posY2[def]=e.getY();
    		repaint();
    		if(un.estRouge(un.Liste().get(lache))!=un.estRouge(un.Liste().get(bouge))&&un.estDecroissant(un.Liste().get(bouge), un.Liste().get(lache))){
    			posX2[def]=posX2[lache];
    			posY3[def]=posY3[lache]+20;
    			repaint();
    		}
    	}
    }

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
 }


