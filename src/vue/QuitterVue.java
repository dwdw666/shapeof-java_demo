package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class QuitterVue {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void quitter() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuitterVue window = new QuitterVue();
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
	public QuitterVue() {
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
		
		JLabel lblNewLabel = new JLabel("bye bye! :-)");
		lblNewLabel.setBounds(153, 110, 143, 50);
		frame.getContentPane().add(lblNewLabel);
	}
}
