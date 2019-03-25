package premierefenetre.Normal;

import java.io.Serializable;


/**
 *
 * @author Serero
 */
public class Person implements Serializable //database 
{
	private int id;
	private static int cpt=0;
	private String name;
	private String occupation;
	private String age;
	private String job;
	private String taxID;
	private boolean usCitizen;
	private String gender;

	public Person(String name, String occupation, 
				String age, String job, String taxID, 
				boolean usCitizen, String gender) 
	{
		this.id = cpt;
		cpt++;
		this.name = name;
		this.occupation = occupation;
		this.age = age;
		this.job = job;
		this.taxID = taxID;
		this.usCitizen = usCitizen;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCpt() {
		return cpt;
	}

	public static void setCpt(int cpt) {
		Person.cpt = cpt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public boolean isUsCitizen() {
		return usCitizen;
	}

	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}

	public String getJob() {
		return job;
	}

	public String getGender() {
		return gender;
	}
	
}
