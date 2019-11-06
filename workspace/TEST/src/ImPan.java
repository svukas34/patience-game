import java.awt.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImPan extends JPanel{
	private String NomImage;
	private int posX = -50;
	
	public ImPan(){
	}
	
	public String getNomImage(){
		return this.NomImage;
	}
	
	public void setNomImage(String nom){
		this.NomImage=nom;
	}	
	
	
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("src//"+NomImage+".jpg"));
			//image qui remplie tout le panel
			g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
			}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
