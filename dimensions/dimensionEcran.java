package dimensions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class dimensionEcran {
	public static void main(String[] args){
		maFenetre fen = new maFenetre();
		fen.setVisible(true);
	}
}
class maFenetre extends JFrame{
	maFenetre(){
		setTitle("Dimension ecran/2");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimEcran = tk.getScreenSize();
		int larg = (int) dimEcran.getWidth();
		int haut = (int) dimEcran.getHeight();
		setSize(larg,haut);
	}
}
