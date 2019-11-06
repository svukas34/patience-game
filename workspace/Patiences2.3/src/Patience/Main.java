package Patience;

import java.util.Scanner;


public class Main {

	public static void main(String []args){
		System.out.println("A quelle jeu voulez vous jouer ? solitaire tapez 1, freecell tapez 2");
		Scanner sc = new Scanner(System.in);
	    int i = sc.nextInt();
	    Fenetre fen = new Fenetre();
		fen.setVisible(true);
		if (i == 1){
			fen.p = fen.panS;
		}else{
			if (i == 2){
				fen.p = fen.panF;
			}else{
				System.out.println("Mauvaise reponse, relancez le programme");
			}
		}
	}
}