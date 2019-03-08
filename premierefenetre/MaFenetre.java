package premierefenetre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MaFenetre extends JFrame{ //Fenetre = ecouteur
	JButton button1 = new JButton("A"); 
	JButton button2 = new JButton("B");
	public MaFenetre(){
		setTitle("Gestion de clics"); //titre de la fenetre
		setBounds(50,100,300,150); //coordonnées du coin haut-gauche de la fenetre et dimensions
		addMouseListener(new MouseAdapter(){ //classe anonyme - definition d'une nouvelle methode
			public void mouseClicked(MouseEvent ev){ //Evenement clic de la souris
				System.out.println("clic au point de coordonnées "+ev.getX()+", "+ev.getY());
			}
		});
		getContentPane().setLayout(new FlowLayout()); //Ajout d'un ordre d'affichage au conteneur de la fenetre
		getContentPane().add(button1); //Ajout du bouton au conteneur
		getContentPane().add(button2);
		EcouteBouton ecout1 = new EcouteBouton(10);
		EcouteBouton ecout2 = new EcouteBouton(20);
		button1.addActionListener(ecout1); //la fenetre ecoute button, ajout nouvel evenement
		button2.addActionListener(ecout2);
	}
}
