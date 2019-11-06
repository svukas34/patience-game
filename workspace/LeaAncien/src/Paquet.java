import java.util.*;

public class Paquet extends Carte{

	public ArrayList defausse = new ArrayList();
	
	public ArrayList C1= new ArrayList();
	public ArrayList C2= new ArrayList();
	public ArrayList C3= new ArrayList();
	public ArrayList C4= new ArrayList();
	public ArrayList C5= new ArrayList();
	public ArrayList C6= new ArrayList();
	public ArrayList C7= new ArrayList();
	public ArrayList R1= new ArrayList();
	public ArrayList R2= new ArrayList();
	public ArrayList R3= new ArrayList();
	public ArrayList R4= new ArrayList();
	
	// creer un paquet de 52 cartes
	public Paquet(){
		for(Couleur coul : Couleur.values())
			for(int i=1; i<=13; i++)
				defausse.add(coul+""+i);
	}
	
    //melange le paquet de carte
	public void melange(){
		Collections.shuffle(defausse);
	}
	
	public ArrayList Liste(){
		return defausse;
	}
	 
	// creer les 7 colonnes et la défausse
/*	public void colonne(){
		for(int i=51; i>=25; i--){
			if(i==51)C1.add(defausse.get(i)); 
			if(i==50)for(int j=50; j>=49; j--)C2.add(defausse.get(j));
			if(i==48)for(int j=48; j>=46; j--)C3.add(defausse.get(j));
			if(i==45)for(int j=45; j>=42; j--)C4.add(defausse.get(j));
			if(i==41)for(int j=41; j>=37; j--)C5.add(defausse.get(j));
			if(i==36)for(int j=36; j>=31; j--)C6.add(defausse.get(j));
			if(i==30)for(int j=30; j>=24; j--)C7.add(defausse.get(j));
		}
		for(int i=51; i>=24; i--)
			defausse.remove(i);
	} */
	
}