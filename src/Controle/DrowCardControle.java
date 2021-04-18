package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import modele.*;

public class DrowCardControle {
	private JButton unBouton;
	private Player  player; 
	private JLabel unlabel;
	private  Desk    desk;
	public DrowCardControle (JButton unBouton,JLabel unlabel,Player player,Desk desk) {
		this.unBouton=unBouton;
		this.unlabel=unlabel;
		this.player=player;
		this.desk=desk;
		// L'appuie sur le bouton
		
		this.unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("\nControleur de l'interrupteur: activation de drow card");
				player.drow(desk);
				Icon icon=new ImageIcon(this.getClass().getResource("/image/"+player.getcardinhand().toString()+".png"));
				unlabel.setIcon(icon);
				System.out.println(player.getcardinhand().toString());
			}
		});
	}
}
