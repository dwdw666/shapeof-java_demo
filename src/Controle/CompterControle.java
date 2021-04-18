package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import modele.Desk;
import modele.MapInDesk;
import modele.Player;
import modele.Sys;
public class CompterControle {
	
	private JButton unBouton;
	private Player player1;
	private Player player2; 
	private Player player3;
	private JLabel label; 
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private Sys    sys;
	private int etatReinitial;
	public CompterControle (int etatReinitial,JButton unBouton, JLabel label,JLabel label1,JLabel label2,Sys sys,Player player1,Player player2) {
		this.unBouton=unBouton;
		this.label=label;
		this.label1=label1;
		this.label2=label2;
		this.sys=sys;
		this.player1=player1;
		this.player2=player2;
		this.etatReinitial=etatReinitial;
		// L'appuie sur le bouton
		
		this.unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("\nControleur de compter: ");
				System.out.println("player "+player1.getPlayerID()+player1.getvictorycard()+"obtenue "+sys.comptepoint(player1)+" points");
				//unlabel.setText("player "+player1.getPlayerID()+sys.comptepoint(player1)+" points"+
				//"\nplayer "+player2.getPlayerID()+sys.comptepoint(player2)+" points");
				if(etatReinitial==0) {
				if(sys.comptepoint(player1)>(sys.comptepoint(player2))) {
					label.setText("player1 obtenue"+sys.comptepoint(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("player1 gagne!");
				}else if(sys.comptepoint(player1)<(sys.comptepoint(player2))){
					label.setText("player1 obtenue"+sys.comptepoint(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("player2 gagne!");
				}else {
					label.setText("player1 obtenue"+sys.comptepoint(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("vous avez la meme points!");
				}
				
				
			}else {
				
				if(sys.comptepointRei(player1)>(sys.comptepoint(player2))) {
					label.setText("player1 obtenue"+sys.comptepointRei(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("player1 gagne!");
				}else if(sys.comptepointRei(player1)<(sys.comptepoint(player2))){
					label.setText("player1 obtenue"+sys.comptepointRei(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("player2 gagne!");
				}else {
					label.setText("player1 obtenue"+sys.comptepointRei(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("vous avez la meme points!");
				}
				
				
				
				
			}
			}
		});
	}
	public CompterControle (JButton unBouton, JLabel label,JLabel label1,JLabel label2,JLabel label3,Sys sys,Player player1,Player player2,Player player3) {
		this.unBouton=unBouton;
		this.label=label;
		this.label1=label1;
		this.label2=label2;
		this.label3=label3;
		this.sys=sys;
		this.player1=player1;
		this.player2=player2;
		this.player3=player3;
		// L'appuie sur le bouton
		
		this.unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("\nControleur de compter: ");
				//System.out.println("player "+player1.getPlayerID()+player1.getvictorycard()+"obtenue "+sys.comptepoint(player1)+" points");
				if((sys.comptepoint(player1)>=sys.comptepoint(player2))&&(sys.comptepoint(player1)>=sys.comptepoint(player3))) {
					label.setText("player1 obtenue"+sys.comptepoint(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("player3 obtenue "+sys.comptepoint(player3)+" points\r\n");
					label3.setText("player1 gagne!");
				}else if((sys.comptepoint(player2)>=sys.comptepoint(player1))&&(sys.comptepoint(player2)>=sys.comptepoint(player3))){
					label.setText("player1 obtenue"+sys.comptepoint(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("player3 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label3.setText("player2 gagne!");
				}else if((sys.comptepoint(player3)>=sys.comptepoint(player1))&&(sys.comptepoint(player3)>=sys.comptepoint(player2))){
					label.setText("player1 obtenue"+sys.comptepoint(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("player3 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label3.setText("player3 gagne!");
				}else {
					label.setText("player1 obtenue"+sys.comptepoint(player1)+" points\r\n");
					label1.setText("player2 obtenue "+sys.comptepoint(player2)+" points\r\n");
					label2.setText("player3 obtenue "+sys.comptepoint(player2)+" points\r\n");
					
				}
			}
		});
	}
	
	
	
	
	
	

	
	
	
}
