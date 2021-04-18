package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import modele.MapInDesk;
import modele.Mode;
import vue.MapNodeVue;

public class MoveCardControle {
	private JButton btnmovecard;
	private MapInDesk map;
	
	public  MoveCardControle(JButton btnmovecard,MapInDesk map) {
		this.btnmovecard= btnmovecard;
		this.map=map;
		
		// L'appuie sur le bouton
		
		this.btnmovecard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("\nControleur de l'interrupteur:  move card");
			    map.setmode(Mode.move);
			}
		});
	}
}
