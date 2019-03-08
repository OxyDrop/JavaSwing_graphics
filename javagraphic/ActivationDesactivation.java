
package javagraphic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ActivationDesactivation{
	public static void main(String[] args){
		FenActiv fen = new FenActiv();
		fen.setVisible(true);
	}
}
class FenActiv extends JFrame implements ActionListener{
	final int NBOUTONS = 5;
	private JButton[] tabBout;
	public FenActiv(){
		setTitle("Activation/Desactivation");
		setSize(500,150);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		tabBout = new JButton[NBOUTONS];
		for(int i=0;i<NBOUTONS;i++){
			tabBout[i]=new JButton("BOUTON"+i);
			contenu.add(tabBout[i]);
			tabBout[i].addActionListener(this);
		}
		
	}
	public void actionPerformed(ActionEvent ev){
		JButton source = (JButton)ev.getSource();
		System.out.println("on desactive le bouton "+((JButton)source).getActionCommand());
		source.setEnabled(false);
	}	
}
