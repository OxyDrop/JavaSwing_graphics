package premierefenetre.Normal;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Serero
 */
public class Controller 
{
	Database db = new Database();
	
	public List<Person> getPeople()
			{
				return db.getPeople();
			}
	public void addPerson(FormEvent e)
	{
				String name = e.getGtname(); //recuperation des données JForm->FormEvent->MyFen
				String occupation = e.getGtoccupation();
				String age = e.getGtAge();
				String job = e.getGtjcb();
				String taxID = e.getTaxID();
				String gender = e.getGtgd();
				boolean isUs = e.getIsUsCit();
			
				Person p = new Person(name, occupation, age, job, taxID, isUs, gender);
				db.addPerson(p);
	}
	public void saveToFile(File f) throws IOException
	{
		db.saveToFile(f);
	}
	public void LoadFromFile(File f) throws IOException, ClassNotFoundException
	{
		db.LoadFromFile(f);
	}
	public void removePerson(int index)
	{
		db.removePerson(index);
	}
}
