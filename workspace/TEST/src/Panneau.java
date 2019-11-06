import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//import Deplacement.Ecouteur;

import java.util.ArrayList;

public class Panneau extends JPanel implements ActionListener {
	PanCard pc1 = new PanCard();
	PanCard pc2 = new PanCard();
//	JPanel panB = new JPanel();
//	JPanel pan = new JPanel();
	PanCard pc3 = new PanCard();
	PanCard pc4 = new PanCard();
	PanCard pc5 = new PanCard();
	PanCard pc6 = new PanCard();
	PanCard pc7 = new PanCard();
	
//	GridLayout gl = new GridLayout(1,7);
	
	private Image img;
	
	ArrayList<PanCard> maListe = new ArrayList<PanCard>();
	
	
/**	BouttonPrendre b1 = new BouttonPrendre();
	BouttonPoser b2 = new BouttonPoser();
	BouttonPrendre b3 = new BouttonPrendre();
	BouttonPoser b4 = new BouttonPoser();
	BouttonPrendre b5 = new BouttonPrendre();
	BouttonPoser b6 = new BouttonPoser();
	BouttonPrendre b7 = new BouttonPrendre();
	BouttonPoser b8 = new BouttonPoser();
	BouttonPrendre b9 = new BouttonPrendre();
	BouttonPoser b10 = new BouttonPoser();
	BouttonPrendre b11 = new BouttonPrendre();
	BouttonPoser b12 = new BouttonPoser();
	BouttonPrendre b13 = new BouttonPrendre();
	BouttonPoser b14 = new BouttonPoser();
*/	
	
	
	
	
	public Panneau(){
	
		try {
			img = ImageIO.read(new File("2K.jpg"));
		} catch (IOException e) {
			System.out.println("mauvais nom fichier");
		}
	//	ImageIcon carte= new ImageIcon("carteface.jpeg");
		this.setBackground(Color.RED);
		//this.setSize(1200, 800);		
		this.setVisible(true);
		this.addMouseListener(new Ecouteur());

				  
	}
	    
	    class Ecouteur extends  MouseAdapter{
	    	public void mouseClicked(MouseEvent ev){
	    		System.out.println("Click la souris" + ev.getX()+" "+ev.getY());
	    		}
			}
		
	    	public void mousePressed(MouseEvent ev ){
	    		System.out.println("bouton de souris enfonce");
	    	}
	    	
	    	public void mouseEntered(MouseEvent ev){
	    		System.out.println("la souris entre dans le composant");
	    	}
	    	public void mouseExited(MouseEvent ev){
	    		System.out.println("la souris sort du composant");
	    	}
	    	public void mouseReleased(MouseEvent ev){
	    		System.out.println("ghkjs");
	    	}
	    	
	  
	    
	/*	pc1.ImagePanel.setNomImage("Back");
		pc2.ImagePanel.setNomImage("2K");
		pc3.ImagePanel.setNomImage("3T");
		pc4.ImagePanel.setNomImage("6P");
		pc5.ImagePanel.setNomImage("9C");
		pc6.ImagePanel.setNomImage("AC");
		pc7.ImagePanel.setNomImage("RP");
		
		maListe.add(pc1);
		maListe.add(pc2);
		
		
	//	gl.setHgap(15);
	//	gl.setVgap(25);
	//	this.setLayout(gl);
		this.add(maListe.get(0));
		this.add(maListe.get(0));
		this.add(pc3);
		this.add(pc4);
		this.add(pc5);
		this.add(pc6);
		this.add(pc7); */
		
		
/**		panB.setLayout(new GridLayout(2,7));
		panB.add(b1);
		panB.add(b3);
		panB.add(b5);
		panB.add(b7);
		panB.add(b9);
		panB.add(b11);
		panB.add(b13);
		panB.add(b2);
		panB.add(b4);
		panB.add(b6);
		panB.add(b8);
		panB.add(b10);
		panB.add(b12);
		panB.add(b14);
*/
		
/**		this.setLayout(new BorderLayout());
		this.add(panH, BorderLayout.CENTER);
		this.add(panB, BorderLayout.SOUTH);
*/

		
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, 95, 125, this);
	}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}

	
	
/**	// pour l'image de fond :
	//Je pense que cette méthode sert à peindre l'image "img"
	//mais comme il n'y a pas d'image c'est transparent
	public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
	} 
*/

/**	public static void EchangePanCard(ArrayList<PanCard> maListe,int a, int b){
		maListe.set(a,pc2);
		maListe.set(b,pc1);
	}
*/
	
}