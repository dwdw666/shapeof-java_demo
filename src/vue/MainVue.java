package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.net.URL;
	/**
	 * 
	 * 
	 * @author wang
	 * date: 2020-12-30
	 */
public class MainVue extends JFrame{
	
	private JPanel contentPane;
	private JPanel Pane1;

	public MainVue() {
		/**
		 * initial the main frame
		 */
		this.setTitle("Shape up");
		this.setBounds(0, 0, 1366, 768);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//设置ContentPane属性
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//不使用布局
		contentPane.setLayout(null);
		//设置ContentPane为透明
		contentPane.setOpaque(false);
		this.setContentPane(contentPane);
		
		
		
		addauthinfo();
		//this.setbackground();
	}
	
	
	public void setbackground() {
		JLabel lblBackground = new JLabel();
		URL resource = this.getClass().getResource("/image/shapeup.jpg");
		System.out.println(resource);
		ImageIcon icon = new ImageIcon(resource); 
		lblBackground.setIcon(icon);
		lblBackground.setBounds(0, 0, 1366, 768); // 设置组件的显示位置及大小
		this.getContentPane().add(lblBackground); // 将组件添加到面板中
	}
	
	public void addauthinfo() {
		JLabel AuthorInf = new JLabel("2wang");
		AuthorInf.setBounds(0,0,200,200);
		contentPane.add(AuthorInf);
	}
	
	
	public static void main(String[] args) {
		MainVue vue = new MainVue();
	}


}


