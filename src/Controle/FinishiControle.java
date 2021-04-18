package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.MapInDesk;
import modele.Player;
import vue.MapNodeVue;

public class FinishiControle {
	private JButton btnPlaycard_1;
	private JButton btnMovecard_1;
	private JButton btnDrowvcard_1;
	private JButton btnFinish_1;
	private JButton btnDrowcard_1;
	
	private JButton btnPlaycard_2;
	private JButton btnMovecard_2;
	private JButton btnDrowvcard_2;
	private JButton btnFinish_2;
	private JButton btnDrowcard_2;
	
	private JButton btnPlaycard_3;
	private JButton btnMovecard_3;
	private JButton btnDrowvcard_3;
	private JButton btnFinish_3;
	private JButton btnDrowcard_3;
	

	public FinishiControle(JButton btnFinish_1,JButton btnPlaycard_1,JButton btnMovecard_1,JButton btnDrowvcard_1,JButton btnDrowcard_1,
			JButton btnFinish_2,JButton btnPlaycard_2,JButton btnMovecard_2,JButton btnDrowvcard_2,JButton btnDrowcard_2) {
		this.btnDrowcard_1=btnDrowcard_1;
		this.btnMovecard_1=btnMovecard_1;
		this.btnDrowvcard_1=btnDrowvcard_1;
		this.btnPlaycard_1=btnPlaycard_1;
		this.btnFinish_1=btnFinish_1;
		
		// L'appuie sur le bouton
		
		this.btnFinish_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("\nControleur de l'interrupteur: "+ "hidden buttons");
				btnDrowcard_1.setVisible(false);
				btnMovecard_1.setVisible(false);
				btnPlaycard_1.setVisible(false);
				btnDrowvcard_1.setVisible(false);
				btnFinish_1.setVisible(false);
				
				btnDrowcard_2.setVisible(true);
				btnMovecard_2.setVisible(true);
				btnPlaycard_2.setVisible(true);
				btnDrowvcard_2.setVisible(true);
				btnFinish_2.setVisible(true);
				
			}
		});
	}
	
	public FinishiControle(JButton btnFinish_1,JButton btnPlaycard_1,JButton btnMovecard_1,JButton btnDrowvcard_1,
			JButton btnDrowcard_1,
			JButton btnFinish_2,JButton btnPlaycard_2,JButton btnMovecard_2,JButton btnDrowvcard_2,JButton btnDrowcard_2,
			JButton btnFinish_3,JButton btnPlaycard_3,JButton btnMovecard_3,JButton btnDrowvcard_3,JButton btnDrowcard_3) {
		this.btnDrowcard_1=btnDrowcard_1;
		this.btnMovecard_1=btnMovecard_1;
		this.btnDrowvcard_1=btnDrowvcard_1;
		this.btnPlaycard_1=btnPlaycard_1;
		this.btnFinish_1=btnFinish_1;
		
		// L'appuie sur le bouton
		
		this.btnFinish_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("\nControleur de l'interrupteur: "+ "hidden buttons");
				btnDrowcard_1.setVisible(false);
				btnMovecard_1.setVisible(false);
				btnPlaycard_1.setVisible(false);
				btnDrowvcard_1.setVisible(false);
				btnFinish_1.setVisible(false);
				
				btnDrowcard_2.setVisible(true);
				btnMovecard_2.setVisible(true);
				btnPlaycard_2.setVisible(true);
				btnDrowvcard_2.setVisible(true);
				btnFinish_2.setVisible(true);
			

				btnDrowcard_3.setVisible(true);
				btnMovecard_3.setVisible(true);
				btnPlaycard_3.setVisible(true);
				btnDrowvcard_3.setVisible(true);
				btnFinish_3.setVisible(true);
			}
		});
	}
}
