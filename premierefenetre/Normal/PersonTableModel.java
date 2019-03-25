package premierefenetre.Normal;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Serero
 */
public class PersonTableModel extends AbstractTableModel 
{
	private List<Person> db;
	private final String[] colNames = {"ID","Name","Occupation","Age","Job","UsCitizen","TaxID"};
	public PersonTableModel()
	{
	
	}
	public void setData(List<Person> db)
	{
		this.db=db;
	}
	public int getRowCount() 
	{
		return db.size();
	}

	public int getColumnCount() 
	{
		return 7;
	}

	@Override
	public String getColumnName(int i) {
		return colNames[i];
	}
	
	public Object getValueAt(int row, int column)
	{
		Person person = db.get(row);
		switch(column)
		{
				case 0: 
					return person.getId();
				case 1:
					return person.getName();
				case 2:
					return person.getOccupation();
				case 3:
					return person.getAge();
				case 4:
					return person.getJob();
				case 5:
					return person.isUsCitizen();
				case 6:
					return person.getTaxID();
		}
		return null;
	}
	
}
