/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premierefenetre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Acer
 */
public class EcouteBouton implements ActionListener {
	private int n;
	public EcouteBouton(int n){
		this.n=n;
	}
	public void actionPerformed(ActionEvent ev){
		System.out.println("action sur bouton "+n);
	}
	
}
