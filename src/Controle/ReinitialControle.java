package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import modele.MapInDesk;
import modele.Mode;
import modele.Player;
import modele.Sys;
import vue.CommentjouerVue;
import vue.DeuxiemeChoisi;
import vue.MapVue;
import vue.MapVue3per;
import vue.QuitterVue;

public class ReinitialControle {
	private MapInDesk map;
	private JButton btnReinitial;
	private Sys sys;
	private Player player1,player2;
	private JLabel infoBoard;
	public ReinitialControle() {
		
	}
	
	
	public ReinitialControle(JButton btnReinitial,MapInDesk map) {
		this.btnReinitial=btnReinitial;
		this.map=map;
		
	
			
	}
		
		
	
	public String process(int message) {
		if(message==1) {
			this.map.reinitialiser(0);
		}else if(message==2) {
			this.map.reinitialiser(1);
		}else if(message==3) {
			this.map.reinitialiser(2);
		}else if(message==4) {
		
		}

		return ""+message;
	}
	
	
}
