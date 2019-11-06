import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class Fenetre extends JFrame {
	
	Pannel_Test tp = new Pannel_Test();

    public Fenetre() {
    setSize(806,628);
	setBackground(Color.gray);
	
//	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	setResizable(false);

	setContentPane(tp);
	this.setVisible(true);
	tp.setVisible(true);
    }
    
   public static void main(String[] args) {
    	@SuppressWarnings("unused")
		Fenetre tf = new Fenetre();
        }
}