package vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controle.ChoisiControle;
import Controle.ChoisiControleV;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;

public class DeuxiemeChoisi {

	private JFrame frame;
	private JButton bouton1;
	private JButton bouton2;
	private ChoisiControleV choisiControleV;
	/**
	 * Launch the application.
	 */
	public static void deuxiemeChoisi() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeuxiemeChoisi window = new DeuxiemeChoisi();
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
	public DeuxiemeChoisi() {
		this.choisiControleV= new ChoisiControleV();
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
		
		bouton1 = new JButton("mode simple");
		bouton1.setBackground(new Color(255, 192, 203));
		bouton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choisiControleV.process(1);
			}
		});
		bouton1.setBounds(29, 80, 127, 23);
		frame.getContentPane().add(bouton1);
		
		bouton2 = new JButton("mode difficult");
		bouton2.setBackground(new Color(255, 192, 203));
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choisiControleV.process(2);
				
			}
		});
		bouton2.setBounds(29, 164, 127, 23);
		frame.getContentPane().add(bouton2);
		
		JLabel lblNewLabel = new JLabel("choisir le mode");
		lblNewLabel.setBounds(87, 22, 152, 36);
		frame.getContentPane().add(lblNewLabel);
	}
}
