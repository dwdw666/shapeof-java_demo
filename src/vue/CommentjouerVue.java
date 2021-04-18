package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class CommentjouerVue {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void commentjouerVue() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommentjouerVue window = new CommentjouerVue();
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
	public CommentjouerVue() {
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
		
		lblNewLabel = new JLabel("In each turn you draw a card and play it, ");
		lblNewLabel.setBounds(79, 66, 300, 78);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("and you can also choose to move a card on table");
		lblNewLabel_1.setBounds(79, 118, 300, 40);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
