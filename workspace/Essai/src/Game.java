import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;


public class Game {

	public Colonne defausse = new Colonne(new ArrayList<Carte>(), 25, 25);
	public Colonne defausse1= new Colonne(new ArrayList<Carte>(), 119, 25);	
	public Colonne C1= new Colonne(new ArrayList<Carte>(), 25, 190);
	public Colonne C2= new Colonne(new ArrayList<Carte>(), 128, 190);
	public Colonne C3= new Colonne(new ArrayList<Carte>(), 238, 190);
	public Colonne C4= new Colonne(new ArrayList<Carte>(), 355, 190);
	public Colonne C5= new Colonne(new ArrayList<Carte>(), 469, 190);
	public Colonne C6= new Colonne(new ArrayList<Carte>(), 586, 190);
	public Colonne C7= new Colonne(new ArrayList<Carte>(), 705, 190);
	public Colonne R1= new Colonne(new ArrayList<Carte>(), 350, 25);
	public Colonne R2= new Colonne(new ArrayList<Carte>(), 468, 25);
	public Colonne R3= new Colonne(new ArrayList<Carte>(), 587, 25);
	public Colonne R4= new Colonne(new ArrayList<Carte>(), 705, 25);

	public Game(){	
		for(Carte.Couleur coul : Carte.Couleur.values())
			for(int i=1; i<=13; i++)
				defausse.Pile.add(new Carte(new ImageIcon(coul.toString()+i+".jpg"), defausse.posx ,defausse.posy, coul, i));
		
		Collections.shuffle(defausse.Pile);
		defausse.Pile.get(0).ret = true;
		defausse.Pile.get(2).ret = true;
		defausse.Pile.get(5).ret = true;
		defausse.Pile.get(9).ret = true;
		defausse.Pile.get(14).ret = true;
		defausse.Pile.get(20).ret = true;
		defausse.Pile.get(27).ret = true;
		
		C1.Pile.add(defausse.Pile.get(0));
		C1.Pile.get(0).pox = C1.posx;
		C1.Pile.get(0).poy = C1.posy;
		
		for (int i = 1; i < 3; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C2.posx;
			Carte.poy = C2.posy;
			C2.Pile.add(Carte);
		}
		for (int i = 3; i < 6; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C3.posx;
			Carte.poy = C3.posy;
			C3.Pile.add(Carte);
		}
		for (int i = 6; i < 10; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C4.posx;
			Carte.poy = C4.posy;
			C4.Pile.add(Carte);
		}
		for (int i = 10; i < 15; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C5.posx;
			Carte.poy = C5.posy;
			C5.Pile.add(Carte);
		}
		for (int i = 15; i < 21; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C6.posx;
			Carte.poy = C6.posy;
			C6.Pile.add(Carte);
		}
		for (int i = 21; i < 28; i++) {
			Carte Carte = defausse.Pile.get(i);
			Carte.pox = C7.posx;
			Carte.poy = C7.posy;
			C7.Pile.add(Carte);
		}
		
		
		defausse.Pile.removeAll(C1.Pile);
		defausse.Pile.removeAll(C2.Pile);
		defausse.Pile.removeAll(C3.Pile);
		defausse.Pile.removeAll(C4.Pile);
		defausse.Pile.removeAll(C5.Pile);
		defausse.Pile.removeAll(C6.Pile);
		defausse.Pile.removeAll(C7.Pile);
		
		InitColonne(C1);
		InitColonne(C2);
		InitColonne(C3);
		InitColonne(C4);
		InitColonne(C5);
		InitColonne(C6);
		InitColonne(C7);
	}
	
	public void InitColonne(Colonne c){
		for (int i = 1; i < c.Pile.size(); i++) {
			Carte carte = c.Pile.get(i);
			carte.poy = c.posy + i * 10;
		}
	}
	
	public boolean Win(){
		return (C1.Pile.isEmpty() && C2.Pile.isEmpty() && C3.Pile.isEmpty() && C4.Pile.isEmpty() && C5.Pile.isEmpty() && C6.Pile.isEmpty() && C7.Pile.isEmpty() && defausse.Pile.isEmpty() && defausse1.Pile.isEmpty());			
	}
	
	public void ajouterCarteDefausse(){
		if (!defausse.Pile.isEmpty()){
			Carte LastCarte = defausse.Pile.get(defausse.Pile.size() - 1);
		
			LastCarte.pox = defausse1.posx;
			LastCarte.ret=true;
			
			defausse1.Pile.add(LastCarte);
			defausse.Pile.remove(LastCarte);
		
		}else
			for(int i=defausse1.Pile.size()-1; i>=0; i--){
				Carte LastCarte = defausse1.Pile.get(i);
				
				LastCarte.pox = defausse.posx;
				LastCarte.ret=false;
				
				defausse.Pile.add(LastCarte);
				defausse1.Pile.remove(LastCarte);	
			}
	}

	
	public void ajouterCarteC(Carte carte, Colonne colonne, Colonne colonneOrigine){
		
		if (!carte.memeCouleur(colonne.Pile.get(colonne.Pile.size()))){ 
			carte.pox = colonne.posx;
		
			if (colonne.Pile.isEmpty() && carte.valeur==13)
				carte.poy = colonne.posy;
			else
				carte.poy = colonne.Pile.get(colonne.Pile.size() - 1).poy + 20;
			
			colonne.Pile.add(carte);
			colonneOrigine.Pile.remove(carte);
			System.out.println("c'est bon");
		}
	}
	
	public void ajouterCarteR(Carte carte, Colonne colonne, Colonne colonneOrigine){
		Carte LastCarte = colonne.Pile.get(colonne.Pile.size()-1);
	
		// switch par couleur
		if (carte.couleur.equals(LastCarte.couleur)){		
			carte.pox = colonne.posx;		
			carte.poy = colonne.posy;	
			colonne.Pile.add(carte);	
			colonneOrigine.Pile.remove(carte);
		}
	}
		
}
