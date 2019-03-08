package dimensions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class DimBoutons {
	public static void main(String[] args){
		Fen2Bouton fen = new Fen2Bouton();
		fen.setVisible(true);
		Scanner scan = new Scanner(System.in);
		int num,l,h;
		System.out.println("Entrez le numero du bouton, sa largeur et sa hauteur, 5 pour arreter");
		do{
			System.out.print("num bouton : ");
			num=scan.nextInt();
			System.out.println("larg : ");
			l=scan.nextInt();
			System.out.println("haut : ");
			h=scan.nextInt();
			fen.setTaillBout(num,l,h);
		}while(num!=5);
	}
}
class Fen2Bouton extends JFrame{
	final int NBOUTONS = 4;
	private JButton[] boutons;
	public Fen2Bouton(){
		setTitle("Modif taille boutons");
		setSize(300,150);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		boutons = new JButton[NBOUTONS];
		for(int i = 0; i<NBOUTONS ; i++){
			boutons[i]=new JButton("NUM"+i);
			contenu.add(boutons[i]);
		}
	}
	public void setTaillBout(int num,int l, int h){
		boutons[num].setPreferredSize(new Dimension(l,h));
		boutons[num].revalidate();
	}
}

