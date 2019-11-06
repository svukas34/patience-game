import java.util.ArrayList;

public class Coup extends Paquet{
	
	// retourne true si la carte est rouge, k ce qu'il y a dans la carte
    public boolean estRouge(Object k){
    	boolean rep = false ;
    	for(int i=1; i<53; i++)
    		if(k.equals("Ca"+i)||k.equals("Co"+i))rep =true;
    	return rep;
    }
	
    //k est le numeros de la carte
    public boolean estDecroissant(Object k1, Object k2){
    	int j1=0,j2=0;
    	for(Couleur coul : Couleur.values())
    		for(int i=1; i<14; i++){
    			if(k1.equals(coul+""+i)) j1=i;
    			if(k2.equals(coul+""+i)) j2=i;
    }return (j1<j2);
    	
    }
    
   // retourne true si la carte est visible 
    public boolean estVisible(int j){
    	return(j==24||j==26||j==29||j==33||j==38||j==44||j==51);	
    }
    
    public boolean estrangeable(Object k, int i){
    	boolean rep=false;
    	for(Couleur coul : Couleur.values())
    		if(k.equals(coul+""+i))rep=true;
    	return rep;
    			
    }
	
    // retourne true quend la colonne est vide
    public boolean estVide(ArrayList l1, ArrayList l2, int k){
    	return (l1.isEmpty()==true /*&& valeur(l2,i)==12*/);
    }
	
	// retourne true quand le jeu est fini
	public boolean estFini(){
		return (C1.isEmpty()==true && C2.isEmpty()==true && C3.isEmpty()==true && C4.isEmpty()==true && C5.isEmpty()==true && C6.isEmpty()==true && C7.isEmpty()==true && defausse.isEmpty()==true);
	}

	
}