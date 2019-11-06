package PackagePremier;

import java.util.Scanner;

public class Main {

	public static void main(String []args){
		System.out.println("A quelle jeu voulez vous jouer ? solitaire tapez 1, freecell tapez 2");
		Scanner sc = new Scanner(System.in);
	    int i = sc.nextInt();
		Fenetre fen = new Fenetre();
		fen.setVisible(true);
		if (i == 1)
			fen.setContentPane(fen.panS);
		else
		if (i == 2)
			fen.setContentPane(fen.panF);
		else
		if (i == 0)
			fen.setContentPane(fen.panT);
		else 
			System.out.println("Mauvaise reponse, relancez le programme");
	}
}
