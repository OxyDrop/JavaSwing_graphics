/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenetreRepaint extends JFrame implements ActionListener{
	private PanRepaint pan;
	private JButton rectangle, ovale;
	public FenetreRepaint(){
		setTitle("Exemple appel repaint");	//FENETRE
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contenu = getContentPane();//CONTENEUR
		pan = new PanRepaint();//PANNEAU
		pan.setBackground(Color.cyan);
		contenu.add(pan);//AJOUT CONTENU
		rectangle = new JButton("Rectangle");//BOUTON RECTANGLE 
		contenu.add(rectangle,"North"); //AJOUT AU CONTENEUR EN HAUT
		rectangle.addActionListener(this); //AJOUT D'UN ECOUTEUR D'EVENEMENT
		ovale = new JButton("Ovale"); //BOUTON OVALE
		contenu.add(ovale,"South"); //AJOUT AU CONTENEUR EN BAS
		ovale.addActionListener(this); //AJOUT D'UN ECOUTEUR D'EVENEMENT
	}
	public void actionPerformed(ActionEvent ev){
		if(ev.getSource()==rectangle) pan.setRectangle(); //DESSINER UN RECTANGLE
		if(ev.getSource()==ovale) pan.setOvale(); //DESSINER UNE OVALE
		pan.repaint(); //REDESSINER
	}
}
class PanRepaint extends JPanel{
	private boolean rectangle = false, ovale = false;
	public void paintComponent(Graphics g){
		super.paintComponent(g); //APPEL PAINTCOMPONENT
		g.setColor(Color.BLUE); 
		if(ovale) g.drawOval(80,20,120,60); 
		if(rectangle) g.drawRect(80,20,120,60);
	}
	public void setRectangle(){rectangle=true;ovale=false;}
	public void setOvale(){rectangle=false;ovale=true;}
}
public class Repaint {
	public static void main(String[] args){
		FenetreRepaint fen = new FenetreRepaint();
		fen.setVisible(true);
	}
}
