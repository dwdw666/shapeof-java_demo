package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import modele.MapInDesk;
import modele.Mode;
import modele.Player;
import vue.*;
public class MoveMapNodeControle {
	private MapNodeVue mapnodevue;
	private MapInDesk  map;
	
	public  MoveMapNodeControle(MapNodeVue mapnodevue,MapInDesk map) {
		this.mapnodevue=mapnodevue;
		this.map=map;
	
		// L'appuie sur le bouton
	    this.mapnodevue.addActionListener(new ActionListener() {
			
	    	public void actionPerformed(ActionEvent arg0) {
				System.out.println("\nControleur de l'interrupteur: activation de move");
				Icon iconnull=new ImageIcon(this.getClass().getResource("/image/null.png")); //image null
				if(map.getmode()==Mode.move) {
					if(map.findcard(mapnodevue.getx(), mapnodevue.gety())!=null) {
						map.setIconForMove(mapnodevue.getIcon());
						map.setCardForMove(map.findcard(mapnodevue.getx(),mapnodevue.gety()));
						map.removemapnode(map.findkey(mapnodevue.getx(),mapnodevue.gety()));
						
					}
					else{
						map.insertcard(map.findkey(mapnodevue.getx(),mapnodevue.gety()),map.getCardForMove());
						map.setCardForMove(null);
						
					}
				}
				
			
			}
		});
	}
	
}
