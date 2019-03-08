package controleusuels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Etiquette {
	public static void main(String[] args){
		Fen1 fen = new Fen1();
		fen.setVisible(true);
	}
}
class Fen1 extends JFrame implements ActionListener{
	private JLabel texte;
	private JButton bouton;	
	private int nbClics;
	public Fen1(){
		setTitle("Etiquette");
		setSize(50,100);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		nbClics=0;
		bouton = new JButton("COMPTEUR");
		texte = new JLabel(""+nbClics);
		contenu.add(bouton);
		contenu.add(texte);
		bouton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev){
		nbClics++;
		texte.setText(""+nbClics);
	}
}
