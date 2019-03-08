package controleusuels;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.List;
public class BoiteListe {
	public static void main(String[] args){
		Fen3 fen = new Fen3();
		fen.setVisible(true);
	}
}
class Fen3 extends JFrame implements ListSelectionListener{
	private JList list;
	String[] color = {"rouge", "bleu", "gris", "vert", "jaune", "noir", "blanc", "orange"};
	public Fen3(){
		setTitle("Boite Liste");
		setSize(300,150);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		list = new JList(color);
		list.setForeground(Color.white);
		list.setBackground(Color.gray);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setBackground(Color.WHITE);
		list.setVisibleRowCount(5);
		contenu.add(scroll);
		list.addListSelectionListener(this);
		
	}
	@Override
	public void valueChanged(ListSelectionEvent ev){
		if(ev.getValueIsAdjusting()){
			System.out.println("**Action Liste - valeurs selectionees :");
				List<Object> valeurs = list.getSelectedValuesList();
				for(Object o : valeurs){
					System.out.println((String) o);
				}
		}
	}
}