package vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controle.ChoisiControle;
import modele.SysGraph2Per;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class PremiereChoisi {
	public static PremiereChoisi window;
	private JFrame frame;
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;
	private JButton bouton5;
	private ChoisiControle choisiControle;
	/**
	 * Launch the application.
	 */
	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremiereChoisi.window = new PremiereChoisi();
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
	public PremiereChoisi() {
		this.choisiControle= new ChoisiControle();
		initialize();
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
		
		bouton1 = new JButton("2 personnes");
		bouton1.setBackground(new Color(255, 192, 203));
		bouton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choisiControle.process(1);
				PremiereChoisi.window.frame.setVisible(false);
			}
		});
		bouton1.setBounds(32, 41, 183, 23);
		frame.getContentPane().add(bouton1);
		
		bouton2 = new JButton("3 personnes");
		bouton2.setBackground(new Color(255, 192, 203));
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choisiControle.process(2);
				PremiereChoisi.window.frame.setVisible(false);
			}		});
		bouton2.setBounds(32, 74, 183, 23);
		frame.getContentPane().add(bouton2);
		
		bouton3 = new JButton("conter avec computer");
		bouton3.setBackground(new Color(255, 192, 203));
		bouton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choisiControle.process(3);
				PremiereChoisi.window.frame.setVisible(false);
			}
		});
		bouton3.setBounds(33, 109, 182, 23);
		frame.getContentPane().add(bouton3);
		
		bouton4 = new JButton("comment jouer");
		bouton4.setBackground(new Color(255, 192, 203));
		bouton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choisiControle.process(4);
				PremiereChoisi.window.frame.setVisible(false);
			}
		});
		bouton4.setBounds(33, 142, 182, 23);
		frame.getContentPane().add(bouton4);
		
		bouton5 = new JButton("quitter");
		bouton5.setBackground(new Color(255, 192, 203));
		bouton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choisiControle.process(5);
				PremiereChoisi.window.frame.setVisible(false);
			}
		});
		bouton5.setBounds(33, 175, 182, 23);
		frame.getContentPane().add(bouton5);
		
		JLabel lblNewLabel = new JLabel("Welcome to SHAPE UP!");
		lblNewLabel.setBounds(36, 10, 167, 31);
		frame.getContentPane().add(lblNewLabel);
	}
}
