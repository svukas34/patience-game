import java.util.*;

public class Jeu extends Coup{
	
	public void affiche(){
		for(int i=0; i<defausse.size(); i++)if(estVisible(defausse, i))System.out.print(defausse.get(i));
		System.out.println();
		for(int i=0; i<C1.size(); i++)if(estVisible(C1,i))System.out.print(C1.get(i));
		System.out.print(" | ");
		for(int i=0; i<C2.size(); i++)if(estVisible(C2,i))System.out.print(C2.get(i));
		System.out.print(" | ");
		for(int i=0; i<C3.size(); i++)if(estVisible(C3,i))System.out.print(C3.get(i));
		System.out.print(" | ");
		for(int i=0; i<C4.size(); i++)if(estVisible(C4,i))System.out.print(C4.get(i));
		System.out.print(" | ");
		for(int i=0; i<C5.size(); i++)if(estVisible(C5,i))System.out.print(C5.get(i));
		System.out.print(" | ");
		for(int i=0; i<C6.size(); i++)if(estVisible(C6,i))System.out.print(C6.get(i));
		System.out.print(" | ");
		for(int i=0; i<C7.size(); i++)if(estVisible(C7,i))System.out.print(C7.get(i));
		System.out.print(" | ");
		for(int i=0; i<R1.size(); i++)if(estVisible(R1,i))System.out.println(R1.get(i));
		System.out.println();
		for(int i=0; i<R2.size(); i++)if(estVisible(R2,i))System.out.println(R2.get(i));
		System.out.println();
		for(int i=0; i<R3.size(); i++)if(estVisible(R3,i))System.out.println(R3.get(i));
		System.out.println();
		for(int i=0; i<R4.size(); i++)if(estVisible(R4,i))System.out.println(R4.get(i));
	}
		
	public boolean coupJouable(ArrayList l1, ArrayList l2, int k1, int k2){
		if(l2==defausse)return true;
		else return (estRouge(l1, k1)!=estRouge(l2, k2) && estDecroissant(l1, l2, k1, k2)==true);
	}
	
	public ArrayList liste(int k){
		if(k==0)return defausse;
		if(k==1)return C1;
		if(k==2)return C2;
		if(k==3)return C3;
		if(k==4)return C4;
		if(k==5)return C5;
		if(k==6)return C6;
		if(k==7)return C7;
		else return R1;
	}	
	
	public void jouer(){
		Scanner sc = new Scanner(System.in);
	//	while(estFini()==false){
			ArrayList l1; 
			ArrayList l2;
			affiche();
			System.out.println("Quelle carte voulez-vous bouger?");
			int a = sc.nextInt();
			System.out.println("Ou voulez vous mettre la carte ?");
			int b = sc.nextInt();
						
			affiche();
	//	}
	}
	
	public boolean est(){
		return coupJouable(C5, C1, 4,0);
	}
	
	public static void main(String[] args){
		Jeu j = new Jeu();
	//	j.melange();
		j.colonne();
		j.affiche();
		System.out.println(j.est());
	}

}
