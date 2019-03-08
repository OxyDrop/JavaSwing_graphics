package javagraphic;
import javax.swing.*;
import java.awt.*;

class MaFenetrePan extends JFrame{
	private JPanel panneau;
	public MaFenetrePan(){
		setTitle("Panneau");
		setSize(300,150);
		panneau = new Panel();
		getContentPane().add(panneau);
		panneau.setBackground(Color.yellow);
	}
}
class Panel extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(15, 10, 200, 50);
	}
}
public class Panneau{
	public static void main(String[] args){
		MaFenetrePan fen = new MaFenetrePan();
		fen.setVisible(true);
	}
}
