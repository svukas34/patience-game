package Patience;


public class Position {
	 
	private int X;
	private int Y;
	
	public Position(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	public Position(){
		
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
	
	//retourne vrai si x € {Ex,Ex+dx} et y € {Ey,Ey+dy}
	public boolean surElement(int Ex, int Ey, int dEx, int dEy){
			return (((X>Ex) && (X<(Ex + dEx))) && (((Y>Ey) && (Y<(Ey+dEy)))));
	}
	
	public void convertirPositionCentreCarte(int Ex, int Ey, int dEx, int dEy, Position p){
		setX((Ex - (Ex - p.getX()) + dEx/2));
		setY((Ey - (Ey - p.getY()) + dEy/2));
	}
	
	
}
