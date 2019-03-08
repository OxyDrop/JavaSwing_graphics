package javagraphic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Fenetre extends JFrame{
	private JPanel pan;
	Fenetre(){
		setTitle("Traces de clics");
		setSize(300,150);
		pan = new JPanel(); 
		getContentPane().add(pan); //AJOUT PANNEAU
		pan.addMouseListener(new EcouteClic(pan)); //AJOUT NOUVEAU EVENEMENT SOURIS 
	}
}
class EcouteClic extends MouseAdapter{
	private JPanel pan;
	private String[] name = {"Chocolat","Myrtille","Framboise","Amande","Confiture"};
	public EcouteClic(JPanel pan){
		this.pan=pan;
	}
	public void mouseClicked(MouseEvent ev){ //
		Graphics g = pan.getGraphics(); //PAS DE REDEFINITION DE PAINTCOMPONENT, PAS DE PERMANENCE DES DESSINS, DESSIN A LA VOLEE
		g.setColor(Color.BLUE);
		g.drawRect(ev.getX(),ev.getY(),12,12);
		g.drawString(name[(int)(Math.random()*name.length)], ev.getX()+12, ev.getY()+12);
		g.dispose(); //LIBERATION MEMOIRE
	}
}
public class TraceRect {
	public static void main(String[] args){
		Fenetre fen = new Fenetre();
		fen.setVisible(true);
	}
	
}
