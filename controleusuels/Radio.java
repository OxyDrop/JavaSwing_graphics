package controleusuels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Radio {
	public static void main(String[] args){
		Fen fen = new Fen();
		fen.setVisible(true);
	}
}
class Fen extends JFrame implements ActionListener{
	private JRadioButton rad1, rad2, rad3;
	private JButton etat;
	public Fen(){
		setTitle("Boutons Radio");
		setSize(400,150);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		ButtonGroup groupe = new ButtonGroup();
		rad1=new JRadioButton("Radio 1",true);
		rad2=new JRadioButton("Radio 2");
		rad3=new JRadioButton("Radio 3");
		etat=new JButton("etat");
		contenu.add(rad1); contenu.add(rad2); contenu.add(rad3);
		groupe.add(rad1); groupe.add(rad2); groupe.add(rad3);
		rad1.addActionListener(this); rad2.addActionListener(this); rad3.addActionListener(this);
		contenu.add(etat); etat.addActionListener(this);
	}@Override
	public void actionPerformed(ActionEvent ev){
		String nom = ev.getActionCommand();
		if(nom.equals("etat"))
			System.out.println("ETATS RADIOS :\n1: "+rad1.isSelected()+" 2: "+rad2.isSelected()+" 3: "+rad3.isSelected());
		else
			System.out.println("action "+nom);
	}
	
}
