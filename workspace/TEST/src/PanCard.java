import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanCard extends JPanel{
	//private String NomImage;
	BouttonPrendre BPr= new BouttonPrendre("Prendre");
	BouttonPoser BPo = new BouttonPoser("Poser");
	JPanel PanB = new JPanel();
	ImPan ImagePanel = new ImPan();
	public boolean ActiviterPoser = false;
	public boolean ActiviterPrendre = false;
	

	public PanCard(){
		BPr.addActionListener(new BPrListener());
		BPo.addActionListener(new BPoListener());
		
		PanB.setLayout(new GridLayout(2,1));
		PanB.add(BPr);
		PanB.add(BPo);
		this.setLayout(new BorderLayout());
		this.add(PanB, BorderLayout.SOUTH);
		this.add(ImagePanel);
	}
	
	class BPrListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			ActiviterPrendre = true;
		}
	}
	
	class BPoListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			ActiviterPoser = true;
		}
	}
	
/*	public String getNomImage(){
		return this.NomImage;*/
	}
	