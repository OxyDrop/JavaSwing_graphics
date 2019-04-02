package premierefenetre;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import premierefenetre.Normal.Person;
import premierefenetre.Normal.PersonTableModel;
import premierefenetre.interfaces.PersonTableListener;

/**
 *
 * @author Serero
 */
public class TablePanel extends JPanel
{
	private JTable table;
	private PersonTableModel ptm;
	private JPopupMenu jpopm;
	private PersonTableListener ptl;
	
	public TablePanel()
	{
		ptm = new PersonTableModel();
		table = new JTable(ptm);
		jpopm = new JPopupMenu();
		JMenuItem removeItem = new JMenuItem("Delete row");
		table.addMouseListener(new MouseAdapter(){ //Adapter permet d'implementer les classes abstraites au choix et non toutes
			public void mouseReleased (MouseEvent ev){
				
				int row = table.rowAtPoint(ev.getPoint()); //recupere la ligne du clic
				table.getSelectionModel().setSelectionInterval(row, row); //selectionne la ligne
				
				if (ev.isPopupTrigger()) jpopm.show(ev.getComponent() ,ev.getX(),ev.getY()); //affiche la JPopMenu
				//if(ev.getButton() == MouseEvent.BUTTON3) jpopm.show(...)
		}});
		
		removeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev){
				int row = table.getSelectedRow();
			
				if(ptl!=null)
				{
					ptl.rowDeleted(row);
					ptm.fireTableRowsDeleted(row, row);
				}
		}});
	
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
		jpopm.add(removeItem);
		add(table,"Center");
	}
	
	public void setData(List<Person> db)
	{
		ptm.setData(db);
	}
	public void refresh()
	{
		ptm.fireTableDataChanged();
	}
	public void setPersonTableListener(PersonTableListener ptl)
	{
		this.ptl=ptl;
	}
}
