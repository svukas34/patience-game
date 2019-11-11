
import javax.swing.ImageIcon;


public class Carte {
	public ImageIcon img;
	
	public enum Couleur {C, K, P, T;}
    
    int posX;
    int posY;
    public boolean ret;
    Couleur couleur;
    int valeur;
    
    public enum CouleurAbsolue {Rouge, Noir;}
    CouleurAbsolue couleurAbsolue;
    
    
   
	public Carte(ImageIcon img, int pox, int poy, Couleur couleur, int valeur) {
		super();
		this.img = img;
		this.posX = pox;
		this.posY = poy;
		this.ret = false;
		this.couleur = couleur;
		this.valeur = valeur;
		
		if (this.couleur.equals(Couleur.K)||this.couleur.equals(Couleur.C)){
			this.couleurAbsolue = CouleurAbsolue.Rouge;
		}
		else { this.couleurAbsolue = CouleurAbsolue.Noir; }
	}
	
	public Carte(ImageIcon img, int pox, int poy, Couleur couleur, int valeur, boolean ret) {
		super();
		this.img = img;
		this.posX = pox;
		this.posY = poy;
		this.ret = false;
		this.couleur = couleur;
		this.valeur = valeur;
		this.ret = ret;
		
		if (this.couleur.equals(Couleur.K)||this.couleur.equals(Couleur.C)){
			this.couleurAbsolue = CouleurAbsolue.Rouge;
		}
		else { this.couleurAbsolue = CouleurAbsolue.Noir; }
	}
    
    //verifie si la carte THIS et la carte KARD ont la meme couleur (rouge/noir)
    public boolean memeCouleur(Carte Kard){
    	return(this.couleurAbsolue.equals(Kard.couleurAbsolue));
    }
    
}

