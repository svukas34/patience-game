package Patience;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;


public class PaquetDeCartes {
	ArrayList<Carte> listeDeCartes = new ArrayList<Carte>();
	
	//cré un jeu de 52 cartes
	public PaquetDeCartes(int n){
		// permet de ne jamais creer plus de 4 paquet (moins de bug ...)
		if (n == 1){
			for (Carte.Couleur coul : Carte.Couleur.values()){
				for (int i = 1; i <= 13; i++){
					listeDeCartes.add(new Carte(new ImageIcon("Cartes/"+ i + coul.toString() + ".jpg"), 1, 2, coul, i));
				}
			}
		}
	}
	
	public void melanger(){
		Collections.shuffle(listeDeCartes);
	}
	
	public void retourner(int n){
		if (n < listeDeCartes.size()){
			listeDeCartes.get(n).ret = true;
		}
	}
}
