import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Pannel extends JPanel  implements MouseMotionListener, MouseListener{
	
	public un un = new un();
	
	int Co=1;
	int Ca=1;
	int P=1;
	int T=1;
	
	  //permet de garder en memoire la position de la carte en train de bouger
	int bouge=51;
	int lache=51;
	
	int nbcarte;
	int def;
	
 	public ImageIcon fond;
	
 	public ArrayList<ImageIcon> img2= new ArrayList<ImageIcon>();
	public int [] posX2 =new int[52];
	public int [] posY2={24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,190,190,200,190,200,210,190,200,210,220,190,200,210,220,230,190,200,210,220,230,240,190,200,210,220,230,240,250};
	
	public int [] posX3 = new int [posX2.length];
	public int [] posY3 = new int [posX2.length];
		//permet de bouger la carte
	boolean [] clic2 = new boolean [posX2.length];
		//permet de dire si la carte est visible ou pas
	boolean []clic3=new boolean[posX2.length];
	
    public Pannel() {
	setSize(815, 600);
	setBackground(Color.pink);
	
	nbcarte=23;
	def=nbcarte+1;
	
	fond = new ImageIcon("Fond1.jpg");
	
	for(int i=0; i<posX2.length; i++){
		un.copie(un.Liste(), img2);
		if(i<24)posX2[i]=25;
		if(i==24)posX2[i]=25;
		if(i>24&&i<27)posX2[i]=128;
		if(i>26&&i<30)posX2[i]=238;
		if(i>29&&i<34)posX2[i]=355;
		if(i>33&&i<39)posX2[i]=469;
		if(i>38&&i<45)posX2[i]=586;
		if(i>44&&i<52)posX2[i]=705;
		
		posX3[i]=posX2[i];
		posY3[i]=posY2[i];
		clic2[i]=false;
		if(un.estVisible(i))clic3[i]=true;
	}
	
	addMouseListener(this);
    addMouseMotionListener(this);
	
    } 
    
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	g.drawImage(fond.getImage(), 0, 0, this);
    	for(int i=0; i<52; i++){
    		if(!clic3[i])
    			g.drawImage(new ImageIcon("0.jpg").getImage(), posX2[i], posY2[i], this);
    		else 
    			g.drawImage(img2.get(i).getImage(), posX2[i], posY2[i], this);
    	}
    		//redessine la carte quon est en train de bouger
    	g.drawImage(img2.get(bouge).getImage(), posX2[bouge], posY2[bouge], this);
   	}   
    
    public void mousePressed(MouseEvent e){ //sactive quand j'enfonce la souris
    	for(int i=0; i<52; i++){
    		if(posX2[i]<=e.getX()&&posX2[i]+75>=e.getX()&&posY2[i]<=e.getY()&&posY2[i]+108>=e.getY()){
    			clic2[i]=true;
    			bouge=i;
    		}
    	}
      }
    
    public void mouseDragged(MouseEvent e){//s'active quand la souris est enfoncé et qu'on la bouge
    	for(int i=0; i<52; i++){
    		
    		if(posX2[i]-20<=e.getX()&&posX2[i]+75+20>=e.getX()&&posY2[i]<=e.getY()&&posY2[i]+100+20+20>=e.getY())
    			lache =i;
    			//me permet de deplacer une carte nimporte ou
    		if(clic2[i]){
    			posX2[i]=e.getX();
    			posY2[i]=e.getY();		
    		} 
    		deplaceCarteDef(e,i);
    		repaint();
    	}System.out.println(bouge+"  "+lache);
    	repaint();
    }
    
    public void mouseReleased(MouseEvent e){//sactive quand je lache la souris apres lavoir bouge
    	for(int i=0; i<52;i++){
    			// permet de deplacer une seule carte
    		clic2[i]=false;
    		chgPositionDefausse(e,i);
    		deplaceCarteDef(e,i);
    		}def--;
    		
    	System.out.println(posX2[19]+"  "+posY2[19]);	
		repaint();
	}
	
    public void mouseClicked(MouseEvent e) {//sactive quand je lache
    		//retourne la carte quand on clique dessus
    	clic3[bouge]=true;
    	repaint();
    }
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
     
    	//permet de faire defiler la defausse
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
    
 }


