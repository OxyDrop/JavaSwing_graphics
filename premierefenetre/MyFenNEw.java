package premierefenetre;
import premierefenetre.Normal.FormEvent;
import premierefenetre.interfaces.FormListener;
import premierefenetre.interfaces.StringListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.filechooser.FileNameExtensionFilter;
import premierefenetre.Normal.Controller;
import premierefenetre.interfaces.PersonTableListener;
/**
 *
 * @author Serero
 */
public class MyFenNEw{
	public static void main(String[] args)
	{
			SwingUtilities.invokeLater(() -> {
				JFrame.setDefaultLookAndFeelDecorated(true);
				MyFen fen = new MyFen();
				fen.setOpacity(0.95f);
				fen.setVisible(true);
			});
	}
}
class MyFen extends JFrame{
	
	private JTextArea jta;
	private Toolbar tbar;
	private JForm jfo;
	private JFileChooser jfic;
	private Controller controller;
	private TablePanel tablep;
	
	public MyFen()
	{
		setTitle("Test");
		setSize(600,600);
		setMinimumSize(new Dimension(500,400));
		Container content = getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		content.setLayout(new BorderLayout());
		
		jta = new JTextArea();
		tbar = new Toolbar();
		jfo = new JForm();
		jfic = new JFileChooser();
		controller = new Controller();
		tablep = new TablePanel();
		tablep.setData(controller.getPeople());
		tablep.setPersonTableListener(new PersonTableListener(){
			public void rowDeleted(int row){
				controller.removePerson(row);
				tablep.refresh();
			}});
				
		setJMenuBar(createMenuBar());
		//jfic.addChoosableFileFilter(new PersonFileFilter());
		jfic.addChoosableFileFilter(new FileNameExtensionFilter("Images", "png","jpg","jpeg","gif","tiff","tif","bmp"));
		
		tbar.setStringListener(new StringListener(){
			public void textEmitted(String s) {
				jta.append(s);
			}
		});	
	
		jfo.setFormListener(new FormListener(){ //ajout ecouteur evenement
			public void FormEventOccured(FormEvent e)
			{
				String name = e.getGtname(); //recuperation des données JForm->FormEvent->MyFen
				String occupation = e.getGtoccupation();
				String age = e.getGtAge();
				String job = e.getGtjcb();
				String taxID = e.getTaxID();
				String gender = e.getGtgd();
				
				jta.append(name+" : \""+age+"\" : "+gender+" : " +occupation+" : "+job+" : "+taxID+"\n"); //Ajout au JTextArea
				controller.addPerson(e);
				tablep.refresh();
		}});
		
		content.add(tbar,"North"); 
		content.add(jta,"South");	
		jta.setPreferredSize(new Dimension(100,50));
		content.add(jfo,"West");
		content.add(tablep,"Center");
	}
	private JMenuBar createMenuBar() 
	{
		JMenuBar jmb = new JMenuBar();
		
		JMenu window = new JMenu("Window");
		JMenu help = new JMenu("Help");
		
		JMenu file = new JMenu("File");
		JMenuItem exportData = new JMenuItem("Export data...");
		JMenuItem importData = new JMenuItem("Import data...");
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exportData); 
		file.add(importData);
		file.addSeparator();
		file.add(exit);
		file.setMnemonic('f');
		exit.setMnemonic('x');
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		exit.addActionListener((ActionEvent ae) -> {
			
			int action = JOptionPane.showConfirmDialog(MyFen.this, "Do you really want to exit the application ?",
														"Confirm exit",JOptionPane.OK_CANCEL_OPTION);
			if(action==JOptionPane.OK_OPTION)
				System.exit(0);
		});
		
		JMenu show = new JMenu("Show");
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		showFormItem.addActionListener((ActionEvent ae) -> {
			jfo.setVisible(((JCheckBoxMenuItem)ae.getSource()).isSelected());
		});
		show.add(showFormItem);
		window.add(show);
		
		importData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,InputEvent.CTRL_MASK));
		importData.addActionListener((ActionEvent ae) -> {
			if(jfic.showOpenDialog(MyFen.this)==JFileChooser.APPROVE_OPTION)
			{
				try {
					controller.LoadFromFile(jfic.getSelectedFile());
					tablep.refresh();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(MyFen.this, "Could not load from file", "Error", JOptionPane.ERROR);
				} catch (ClassNotFoundException ex) {}
				
				jta.append("Loading "+jfic.getSelectedFile().getName()+" ...\n");
			}
		});
		exportData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		exportData.addActionListener((ActionEvent ae) -> {
			if(jfic.showSaveDialog(MyFen.this)==JFileChooser.APPROVE_OPTION)
				try {
					controller.saveToFile(jfic.getSelectedFile());
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(MyFen.this, "Could not save to file", "Error", JOptionPane.ERROR);
				}
			jta.append("Saving "+jfic.getSelectedFile().getName()+"... \n");
		});
		
		jmb.add(file);
		jmb.add(window);
		return jmb;
	}
}



