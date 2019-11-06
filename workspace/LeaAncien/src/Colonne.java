
import java.util.ArrayList;


public class Colonne {
	
	ArrayList<Carte> Pile;
	int posx;
	int posy;
	
	public Colonne(ArrayList<Carte> pile, int posx, int posy) {
		super();
		Pile = pile;
		this.posx = posx;
		this.posy = posy;
	}
		
}
