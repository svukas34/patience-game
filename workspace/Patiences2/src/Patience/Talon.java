package Patience;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Talon extends TasDeCartes {

	public Talon(String name, ArrayList<Carte> liste, int posx, int posy){
		super(name, liste, posx, posy);
	}
	
	public boolean positionEstDessus(Position p){
		return(p.surElement(posX, posY, super.getLargeur(), super.getHauteur()));
	}
	
	public void peindre(Graphics g, ImageIcon face, JPanel pan){
		if (!liste.isEmpty()){
			g.drawImage(face.getImage(), posX, posY, super.getLargeur(), super.getHauteur(), pan);
			g.drawImage(LastCarte.img.getImage(), posX, posY, 75, 100, pan);
		}
	}
	
	public void ajouterCarte(Defausse d) {
		if (!d.liste.isEmpty()) {
			d.LastCarte.posX = this.posX;
			d.LastCarte.ret = true;

			this.liste.add(d.LastCarte);
			d.liste.remove(d.LastCarte);
			this.initLastCarte();
			d.initLastCarte();
		} else {
			// a VERIFIER ceci :
			while (!liste.isEmpty()){
				LastCarte.posX = d.posX;
				LastCarte.ret = false;
				d.liste.add(LastCarte);
				this.liste.remove(LastCarte);
				d.initLastCarte();
				this.initLastCarte();
			}
		}
	}
}
