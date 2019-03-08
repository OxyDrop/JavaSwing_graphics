/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class Synchronized {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Nombres nomb = new Nombres();
		Thread calc = new ThrChange(nomb);
		Thread aff = new ThrAff(nomb);
		System.out.println("Suite de carres - tapez retour pour arreter");
		calc.start(); aff.start();
		String s = scan.next();
		calc.interrupt(); aff.interrupt();
	}
}



