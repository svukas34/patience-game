package premier;

import javax.swing.ImageIcon;

public class Carte {
	public String name;
	public ImageIcon img;
	private int PosX;
	private int PosY;

	public Carte(int valeur, char couleur) {
		this.name = valeur + Character.toString(couleur);
		this.img = new ImageIcon(name + ".jpg");
	}

	public void setposX(int x){
		this.PosX = x;
	}
	public int getPosX(){
		return PosX;
	}
	public void setposY(int y){
		this.PosY = y;
	}
	public int getPosY(){
		return PosY;
	}
	
}