/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Acer
 */
class FenBoutonsDyn extends JFrame {
	private final JButton crBouton;
	
	public FenBoutonsDyn(){
		setTitle("Boutons Dynamiques"); //FENETRE
		setSize(500,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenu = getContentPane(); //CONTENEUR
		contenu.setLayout(new FlowLayout());
		crBouton = new JButton("Creation bouton"); //BOUTON CREATEUR
		contenu.add(crBouton); // AJOUT A LA FENETRE
		EcoutCr ecoutCr = new EcoutCr(contenu); //ECOUTEUR BOUTON
		crBouton.addActionListener(ecoutCr); //AJOUT ECOUTEUR BOUTON CREATEUR
	}
}
class EcoutCr implements ActionListener{
	private Container contenu;
	private static int id=0;
	public EcoutCr(Container contenu){
		this.contenu = contenu;
	}
	public void actionPerformed(ActionEvent ev){
		if(ev.getActionCommand().equals("Creation bouton"))
		{
			JButton nouvBout = new JButton("BOUTON"+id++);
			nouvBout.addActionListener(this);
			contenu.add(nouvBout);
		}
		contenu.validate();
		System.out.println("Action sur le bouton "+ev.getActionCommand());
	}
}
public class BoutonDynamique{
	public static void main(String[] args){
		FenBoutonsDyn fen = new FenBoutonsDyn();
		fen.setVisible(true);
	}
}
