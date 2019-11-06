package Patience;

import java.util.ArrayList;


public class TasDeCartes {
	
	ArrayList<Carte> liste;
	int posX;
	int posY;
	String nom;
	Carte LastCarte;
	private static int largeur = 75;
	private static int hauteur = 100;
	
	
	public TasDeCartes(String name, ArrayList<Carte> liste, int posx, int posy) {
		this.nom = name;
		this.liste = liste;
		this.posX = posx;
		this.posY = posy;
		//setLargeur(75);
		//setHauteur(100);
		if (!liste.isEmpty())
			LastCarte = liste.get(liste.size()-1);
	}
	
	public TasDeCartes(){
		
	}
	
	public int positionSurQuelleRangDeCarte(Position pos){
		return 0;
	}
	
	public void initLastCarte(){
		if (this.liste.isEmpty())
			LastCarte = new Carte();
		else
			LastCarte = liste.get(liste.size()-1);
	}
	
	static int getLargeur() {
		return largeur;
	}

	void setLargeur(int tailleX) {
		largeur = tailleX;
	}

	static int getHauteur() {
		return hauteur;
	}

	void setHauteur(int tailleY) {
		hauteur = tailleY;
	}

	
	public boolean positionEstDessus(Position pos) {
		return (pos.surElement(posX, posY, getLargeur(), getHauteur()));
	}
	
}
