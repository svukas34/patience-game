import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener{
	static String Carte = new String("B");
	static String Fond = new String("Fond2");
	static String Gagne = new String("G1");
	
	JButton ok = new JButton("OK");
	JPanel containerF = new JPanel();
	
	static JRadioButton f2 = new JRadioButton("Classique",new ImageIcon("Fond2.gif"), true);
	static JRadioButton f1 = new JRadioButton("fantaisiste", new ImageIcon("Fond1.gif"), false);
	static JRadioButton f3 = new JRadioButton("Paris Diderot",new ImageIcon("Fond3.gif"), false);
	static JRadioButton f4 = new JRadioButton("Radio",new ImageIcon("Fond4.gif"), false);
	
	JMenu fichier = new JMenu("Fichier");
	JMenuItem MFond = new JMenuItem("Modifier l'Apparence");
	JMenuItem nouveau = new JMenuItem("Nouvelle Partie");
	ButtonGroup groupCarte = new ButtonGroup();
	ButtonGroup groupFond = new ButtonGroup();
	
	PanSolitaire panS = new PanSolitaire();
	
public Fenetre(){
		groupFond.add(f1);
		groupFond.add(f2);
		groupFond.add(f3);
		groupFond.add(f4);
		
		JMenuBar menu = new JMenuBar();
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,  ActionEvent.CTRL_MASK));
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		nouveau.addActionListener(this);
		f1.addActionListener(this);
		f2.addActionListener(this);
		f3.addActionListener(this);
		f4.addActionListener(this);
		
		MFond.addActionListener(this);
		ok.addActionListener(this);
		setTitle("Solitaire");
		setSize(830,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fichier.add(nouveau);
		fichier.add(MFond);
		fichier.add(quitter);
		menu.add(fichier);
		setJMenuBar(menu);
		setContentPane(panS);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==nouveau){
			panS = new PanSolitaire();
			this.remove(panS);
			setContentPane(panS);
			this.setVisible(true);
		}
		
		 if(e.getSource()==MFond){
			JLabel label = new JLabel("Modifier le Fond");
			JPanel radioPanel = new JPanel();
			radioPanel.setLayout(new GridLayout(2, 2));
			
			radioPanel.add(f1);
			radioPanel.add(f2);
			radioPanel.add(f3); 
			radioPanel.add(f4); 
			
			containerF.setBackground(Color.white);
			containerF.setLayout(new BorderLayout());
	    	containerF.add(radioPanel,  BorderLayout.CENTER);
	    	containerF.add(ok, BorderLayout.SOUTH);
	    	containerF.add(label, BorderLayout.NORTH);
	    
			setContentPane(containerF);
			this.setVisible(true);
		 }
		
		if(f1.isSelected()){
			Fond="Fond1";
			Carte="A";
			Gagne="G1";
		}else if(f2.isSelected()){
			Fond="Fond2";
			Carte="B";
			Gagne="G1";
		}else if(f3.isSelected()){
			Fond="Fond3";
			Carte="C";
			Gagne="G3";
		}else if(f4.isSelected()){
			Fond="Fond4"; 
			Carte="D";
			Gagne="G4";
		}
		if(e.getSource() == ok){
			setContentPane(panS);
			setVisible(true);
		}	
		 
	}
}