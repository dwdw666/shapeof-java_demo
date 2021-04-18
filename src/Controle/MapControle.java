package Controle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import modele.*;
import vue.*;

/**
 * controle insert card
 * @author 80774
 *
 */
public class MapControle {
	
	private MapNodeVue unBouton;
	private MapInDesk map;

	public MapControle(MapNodeVue unBouton,MapInDesk map) {
		this.unBouton=unBouton;
		this.map=map;
		
		// L'appuie sur le bouton
		
		this.unBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("\nControleur de l'interrupteur: "+ map.getplycurrent().getPlayerID()+"player's turn");
			    if(map.getmode()==Mode.insert) {
			    	map.insertcard(map.findkey(unBouton.getx(),unBouton.gety() ), map.getplycurrent().getcardinhand());
			    }
				
			}
		});
	}
	
}
