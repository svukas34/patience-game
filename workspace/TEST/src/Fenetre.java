import java.awt.*;

import javax.swing.*;

public class Fenetre extends JFrame {
private Panneau panH = new Panneau();
private ImPan pan = new ImPan();

	 public Fenetre(){
		    this.setTitle("Solitaire V 01");
		    this.setSize(1200,800);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
		    
		    pan.setNomImage("Fond");
//			panH.setBackground(Color.GREEN);
//		    pan.setBackground(Color.GREEN);
		    pan.setLayout(new GridLayout(2,1));
		    pan.add(panH);

		    
		    
		    this.setContentPane(pan);
		    this.setVisible(true);
	 }
	 
	 public Panneau getpanH(){
		 return panH;
	 }
}
