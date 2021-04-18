package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Card;
import modele.MapInDesk;
import modele.Mode;
import modele.Player;
/**
 * which player operates now
 * @author 80774
 *
 */
public class InsertCardControle {
	private JButton unBouton;
	private MapInDesk map;
	private Player player; 
	
	public InsertCardControle(JButton unBouton,MapInDesk map,Player player) {
		this.unBouton=unBouton;
		this.map=map;
		this.player=player;
		// L'appuie sur le bouton
		
		this.unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("\nControleur de l'interrupteur: activation de insert de"+player.getPlayerID()+"player");
				map.setmode(Mode.insert);
				map.setplycurrent(player);
			
			}
		});
	}
}
