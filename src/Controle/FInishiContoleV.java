package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Desk;
import modele.Player;
import modele.VirtuelPlayer;
public class FInishiContoleV {
	private JButton btnFinish_1;
	private VirtuelPlayer  vplayer;  
	private Desk    desk;
	
	
	public FInishiContoleV (JButton btnFinish_1,VirtuelPlayer player,Desk desk){
		this.btnFinish_1=btnFinish_1;
		this.desk=desk;
		this.vplayer=player;
		// L'appuie sur le bouton
		
		this.btnFinish_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("\nControleur de l'finishiV: "+"virtuel player player");
				if(vplayer.getvictorycard()==null) {
					vplayer.drow(desk);
					vplayer.setvictorycard(vplayer.getcardinhand());
					vplayer.decidePlay(desk.getmap(), desk);
				}
				else{
					vplayer.drow(desk);
					vplayer.decidePlay(desk.getmap(), desk);
					
				}
			}
		});
	}
}
