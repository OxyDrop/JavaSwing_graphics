package Threads;
public class ThrAff extends Thread
{
	private Nombres nomb;
	public ThrAff(Nombres nomb)
	{
		this.nomb=nomb;
	}
	public void run()
	{
		try{
			while(!interrupted())
			{
				nomb.affiche();
				sleep(200);
			}
		}catch(InterruptedException e){}
	}
}
