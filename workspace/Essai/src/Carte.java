import javax.swing.*;

public class Carte{
	
    public enum Couleur {Co, Ca, P, T;}
    
    ImageIcon img;
    int pox;
    int poy;
    public boolean ret;
    Couleur couleur;
    int valeur;
    

    private enum CouleurAbsolue {Rouge,Noir;}
    CouleurAbsolue couleurAbsolue;

    
    
    public Carte(ImageIcon img, int pox, int poy, Couleur couleur,int valeur) {
		super();
		this.img = img;
		this.pox = pox;
		this.poy = poy;
		this.ret = false;
		this.couleur = couleur;
		this.valeur = valeur;
		
		if (this.couleur.equals("Ca") || this.couleur.equals("Co"))
			this.couleurAbsolue = CouleurAbsolue.Rouge;
		
		else 
			this.couleurAbsolue = CouleurAbsolue.Noir;
	}
    
    public boolean memeCouleur(Carte Kard){
    //	return (Kard.couleurAbsolue.equals(carte.couleurAbsolue));
    	return(this.couleurAbsolue.equals(Kard.couleurAbsolue));
    }
}