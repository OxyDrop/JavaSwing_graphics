package premierefenetre.Normal;

import java.util.EventObject;

/**
 *
 * @author Serero
 */
public class FormEvent extends EventObject { //Evenement dans le composant Form(JPANEL)
	private String gtname;
	private String gtoccupation;
	private String gtAge;
	private String gtjcb;
	private String gttID;
	private String gtgd;
	private Boolean isUsCit;
	//herite des variables dans ActionPerformed
	public FormEvent(Object source, String gtname, String gtoccupation, String gtAge, String gtJcb, boolean isUsCit, String gttID, String gtgd)
	{
		super(source);
		this.gtname=gtname;
		this.gtoccupation=gtoccupation;
		this.gtAge=gtAge;
		this.gtjcb=gtJcb;
		this.gttID=gttID;
		this.gtgd=gtgd;
		this.isUsCit=isUsCit;
	}

	public String getGtname() {
		return gtname;
	}

	public void setGtname(String gtname) {
		this.gtname = gtname;
	}

	public String getGtoccupation() {
		return gtoccupation;
	}

	public void setGtoccupation(String gtoccupation) {
		this.gtoccupation = gtoccupation;
	}

	public String getGtAge() {
		return gtAge;
	}

	public String getGtjcb() {
		return gtjcb;
	}

	public String getTaxID() {
		return gttID;
	}

	public String getGtgd() {
		return gtgd;
	}

	public Boolean getIsUsCit() {
		return isUsCit;
	}
	
	
}
