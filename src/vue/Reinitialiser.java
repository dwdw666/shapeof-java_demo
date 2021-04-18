package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controle.CompterControle;
import Controle.ReinitialControle;
import modele.MapInDesk;
import modele.Player;
import modele.Sys;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Reinitialiser {
	public static Reinitialiser window;
	private JFrame frame;
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;
	private ReinitialControle rein;
	private JButton btnReinitial;
	//private Reinitialiser window;
	private MapInDesk map;
	private int etatReinitial;
	private JLabel lblNewLabel_2;
	private JLabel infoBoard;
	private JLabel infoBoard1;
	private JLabel infoBoard2;
	private Sys sys;
	private Player player1;
	private Player player2;
	/**
	 * Launch the application.
	 */
	public static void reinitialiserMain(JButton btnReinitial, MapInDesk map,JLabel infoBoard,JLabel infoBoard1,
			JLabel infoBoard2,Sys sys,Player player1,Player player2) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reinitialiser.window = new Reinitialiser(btnReinitial,map,infoBoard,infoBoard1,infoBoard2,sys,player1,player2);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reinitialiser(JButton btnReinitial, MapInDesk map,JLabel infoBoard,JLabel infoBoard1,
			JLabel infoBoard2,Sys sys,Player player1,Player player2) {
		this.map=map;
		this.btnReinitial=btnReinitial;
		this.player1=player1;
		this.player2=player2;
		this.sys=sys;
		this.infoBoard=infoBoard;
		this.infoBoard1=infoBoard1;
		this.infoBoard2=infoBoard2;
		ReinitialControle rein=new ReinitialControle(btnReinitial,map);
		this.rein=rein;
		initialize();
		
		//new ReinitialControle(btnCompter,infoBoard,sys,player1,player2);
		new CompterControle(1,bouton1,infoBoard,infoBoard1,infoBoard2,sys,player1,player2);
		new CompterControle(1,bouton2,infoBoard,infoBoard1,infoBoard2,sys,player1,player2);
		new CompterControle(1,bouton3,infoBoard,infoBoard1,infoBoard2,sys,player1,player2);
		new CompterControle(0,bouton4,infoBoard,infoBoard1,infoBoard2,sys,player1,player2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voulez vous utiliser 2 points \r\n");
		lblNewLabel.setBounds(50, 20, 416, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("pour perturber l'ordre d'un ligne de cartes?");
		lblNewLabel_1.setBounds(50, 35, 275, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		bouton1 = new JButton("perturber ligne1");
		bouton1.setBackground(new Color(255, 192, 203));
		bouton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rein.process(1);
				Reinitialiser.window.frame.setVisible(false);
			}
		});
		bouton1.setBounds(55, 81, 156, 23);
		frame.getContentPane().add(bouton1);
		
		bouton2 = new JButton("perturber ligne 2");
		bouton2.setBackground(new Color(255, 192, 203));
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rein.process(2);
				Reinitialiser.window.frame.setVisible(false);
			}
		});
		bouton2.setBounds(55, 111, 156, 23);
		
		frame.getContentPane().add(bouton2);
		
		bouton3 = new JButton("perturber ligne 3");
		bouton3.setBackground(new Color(255, 192, 203));
		bouton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rein.process(3);
				Reinitialiser.window.frame.setVisible(false);
			}
		});
		bouton3.setBounds(55, 144, 156, 23);
		frame.getContentPane().add(bouton3);
		
		bouton4 = new JButton("non, merci");
		bouton4.setBackground(new Color(255, 192, 203));
		bouton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rein.process(4);
				Reinitialiser.window.frame.setVisible(false);
			}
		});
		bouton4.setBounds(55, 177, 156, 23);
		frame.getContentPane().add(bouton4);
		
		lblNewLabel_2 = new JLabel("petit privilege pour player1:");
		lblNewLabel_2.setBounds(50, 0, 253, 25);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
