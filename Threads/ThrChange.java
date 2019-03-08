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
public class ThrChange extends Thread{
	private Nombres nomb;
	public ThrChange(Nombres nomb){
		this.nomb=nomb;
	}
	public void run(){
		try{
			while(!interrupted()){
				nomb.calcul();
				sleep(500);
			}
		}catch(InterruptedException e){}
	}
}
