package controleusuels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Texte {
	public static void main(String[] args){
		Fen2 fen = new Fen2();
		fen.setVisible(true);
	}	
}
class Fen2 extends JFrame implements ActionListener,FocusListener{
	private JTextField saisie,copie;
	private JButton bouton;
	Fen2(){
		setTitle("Champ texte"); setSize(300,150); //FENETRE
		Container contenu = getContentPane(); contenu.setLayout(new FlowLayout()); //CONTENEUR
		saisie = new JTextField(20); copie = new JTextField(20); //JTEXTFIELD
		bouton = new JButton("COPIER"); //BOUTON
		copie.setEditable(false); //NON MODIFIABLE
		contenu.add(saisie);contenu.add(copie); contenu.add(bouton);//AJOUT CONTENEUR
		saisie.addActionListener(this); bouton.addActionListener(this);
		saisie.addFocusListener(this);
	}
	public void actionPerformed(ActionEvent ev){
		if(ev.getSource()==bouton){
			System.out.println("validation saisie");
			copie.setText(saisie.getText());
		}
	}
	public void focusGained(FocusEvent ev){
		System.out.println("focus sur saisie");
	}
	public void focusLost(FocusEvent ev){
		System.out.println("perte focus saisie");
	}
}
