package controleusuels;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ComboBox {
	public static void main(String[] args){
		Fen4 fen = new Fen4();
		fen.setVisible(true);
	}
}
class Fen4 extends JFrame implements ActionListener{
	String[] color = {"rouge", "bleu", "gris", "vert", "jaune", "noir", "blanc", "orange"};
	JComboBox combo;
	public Fen4(){
		setTitle("Combo Box");
		setSize(300,200);
		setBackground(Color.white);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		combo = new JComboBox(color);
		combo.setBackground(Color.white);
		combo.setEditable(true);
		contenu.add(combo);
		combo.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev){
		System.out.print("action combo - ");
		if(combo.getSelectedIndex()==-1){
			System.out.println("saisie nouvelle valeur : "+combo.getSelectedItem());
			combo.addItem(combo.getSelectedItem());
		}else
			System.out.println("selection valeur existante : "+combo.getSelectedItem()+" de rang : "+combo.getSelectedIndex());
	}
}
