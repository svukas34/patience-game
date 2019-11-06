
import java.util.ArrayList;


public class TasDeCartes {
	
	ArrayList<Carte> listeDeCartes;
	int posX;
	int posY;
	String nom;
	
	public TasDeCartes(){}
	
	public TasDeCartes(String name, ArrayList<Carte> pile, int posx, int posy) {
		super();
		this.nom = name;
		listeDeCartes = pile;
		this.posX = posx;
		this.posY = posy;
	}
		
}
