/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author Acer
 */
public class Nombres {
	private boolean pret = false;
	private int n=1,carre;
	public synchronized void calcul() throws InterruptedException{
		if(!pret){
			n++;
			carre=n*n;
			pret=true;
			notifyAll();
		}
		else
			wait();
			
	}
	public synchronized void affiche(){
		try{
			if(pret){
				System.out.println(n+" a pour carre "+carre);
				notifyAll();
				pret=false;
			}
			else wait();
		}catch(InterruptedException e){}
	}
	public boolean pret(){
		return pret;
	}
}

