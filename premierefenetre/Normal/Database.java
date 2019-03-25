package premierefenetre.Normal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Serero
 */
public class Database 
{
	private List<Person> people;

	public Database() 
	{
		people = new ArrayList<>();
	}
	public void addPerson(Person p)
	{
		people.add(p);
	}
	public void removePerson(int index)
	{
		people.remove(index);
	}
	public List<Person> getPeople() 
	{
		return Collections.unmodifiableList(people); //les autres classes ne peuvent pas modifier la liste
	}
	
	public void saveToFile(File f) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	
		Person[] p = people.toArray(new Person[people.size()]);
		oos.writeObject(p);
		
		oos.close();
	}
	public void LoadFromFile(File f) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Person[] p = (Person[])ois.readObject();
		people.clear();
		people.addAll(Arrays.asList(p));
		ois.close();
	}
	
}
