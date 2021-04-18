package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import modele.Desk;
import modele.Player;

public class DrowVCardControle {
	private JButton unBouton;
	private JLabel unlabel;
	private Player  player; 
	private Desk    desk;
	public DrowVCardControle (JButton unBouton,JLabel unlabel,Player player,Desk desk) {
		this.unBouton=unBouton;
		this.player=player;
		this.unlabel=unlabel;
		this.desk=desk;
		// L'appuie sur le bouton
		
		this.unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("\nControleur de l'interrupteur: activation de drow card");
				player.drow(desk);
				player.setvictorycard(player.getcardinhand());
				Icon icon=new ImageIcon(this.getClass().getResource("/image/"+player.getvictorycard().toString()+".png"));
				System.out.println(player.getvictorycard());
				unlabel.setIcon(icon);
			}
		});
	}
}
