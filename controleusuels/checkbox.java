package controleusuels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class checkbox {
	public static void main(String[] args){
		FenCoche fen = new FenCoche();
		fen.setVisible(true);
	}
}
class FenCoche extends JFrame implements ActionListener{
	private JCheckBox coche1,coche2;
	private JButton etat;
	public FenCoche(){
		setTitle("Cases a cocher");
		setSize(400,150);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		coche1 = new JCheckBox("case 1");
		coche2 = new JCheckBox("case 2");
		etat = new JButton("etat");
		contenu.add(coche1);
		contenu.add(coche2);
		contenu.add(etat);
		coche1.addActionListener(this);
		coche2.addActionListener(this);
		etat.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev){
		String nom = ev.getActionCommand(); 
		if(nom.equals("etat"))
			System.out.println("Etat CASES : "+coche1.isSelected()+" "+coche2.isSelected());
		else
			System.out.println("action "+nom);
	}
}
