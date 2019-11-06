package Patience;

import java.util.ArrayList;


public class TasDeCartes {
	
	ArrayList<Carte> liste;
	int posX;
	int posY;
	String nom;
	private int largeur = 75;
	private int hauteur = 100;
	
	
	public TasDeCartes(String name, ArrayList<Carte> liste, int posx, int posy) {
		this.nom = name;
		this.liste = liste;
		this.posX = posx;
		this.posY = posy;
	}
	
	public TasDeCartes(){
		
	}
	
	public int positionSurQuelleRangDeCarte(Position pos){
		return 0;
	}
	
	int getLargeur() {
		return largeur;
	}

	void setLargeur(int tailleX) {
		largeur = tailleX;
	}

	int getHauteur() {
		return hauteur;
	}

	void setHauteur(int tailleY) {
		hauteur = tailleY;
	}

	
	public boolean positionEstDessus(Position pos) {
		return (pos.surElement(posX, posY, getLargeur(), getHauteur()));
	}
	
}
