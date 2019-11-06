import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class Deplacement extends Coup {
	
		// deplace l'element de la position k1 à la position k2 et l'elemet k2 à k2+1
	public void deplace(int k1, int k2, ArrayList l){
		Object ob1=l.get(k1);
		l.add(k2+1,ob1);
		l.remove(k1);
	}
		
		//l1 est la liste qu'on veut recopié en ImageIcon
	public void copie(ArrayList l1, ArrayList <ImageIcon> l2){
		for(int i=0; i<l1.size(); i++){
			l2.add(new ImageIcon(l1.get(i)+".jpg"));
		}	
	}

}
