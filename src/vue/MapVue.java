package vue;
import Controle.*;
import Observer_Pattern.*;
import modele.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.net.URL;
import Observer_Pattern.Observer;

/**class mapvue
 * 
 * @author wang
 *
 */
public class MapVue implements Observer{

	JFrame frame;
	private JPanel contentPane;
	private JLabel infoBoard;
	private JLabel infoBoard1;
	private JLabel infoBoard2;
	private JLabel player1info;
	private JLabel player2info;
	private JButton btnReinitial;


	private MapNodeVue btnNewButton_0;
	private MapNodeVue btnNewButton_1;
	private MapNodeVue btnNewButton_2;
	private MapNodeVue btnNewButton_3;
	private MapNodeVue btnNewButton_4;
	private MapNodeVue btnNewButton_5;
	private MapNodeVue btnNewButton_6;
	private MapNodeVue btnNewButton_7;
	private MapNodeVue btnNewButton_8;
	private MapNodeVue btnNewButton_9;
	private MapNodeVue btnNewButton_10;
	private MapNodeVue btnNewButton_11;
	private MapNodeVue btnNewButton_12;
	private MapNodeVue btnNewButton_13;
	private MapNodeVue btnNewButton_14;

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

	private JButton btnCompter;
	
	private Desk desk;
	private Playlist playerlist;
	private Sys sys;
	private Player player1;
	private Player player2;
	private MapInDesk mapindesk;
	public MapVue() {}
	
	/**
	 * Launch the application.
	 */
	public static void mapvue() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//initial playerlist
					Player player1 = new Player();
					Player player2=  new Player();
					Playlist playerlist = new Playlist(player1,player2);
					MapInDesk map = new MapInDesk();
					//initial cardheap
					CardHeap cardheap = new CardHeap();
					cardheap.washHeap();
					// initial desk
					Desk desk = new Desk(map,cardheap);
					//initial vue
					MapVue window = new MapVue(desk,player1,player2);
					
					Sys sys = new Sys(desk,playerlist);
					
					int turn=1;
					//****************************1st turn********************************************		
					//indiquez first player and second player drow victorycard and play
					
					//while(player1.getvictorycard()==null || player2.getvictorycard()==null) {
						if(player1.getvictorycard()==null) {
							window.addinfo("player"+player1.getPlayerID()+" tirer votre victorycard ");
						}else if(player1.getvictorycard()!=null&&player2.getvictorycard()==null) {
							window.addinfo("player"+player2.getPlayerID()+" tirer votre victorycard ");
						}
						//}
							//window.addinfo("we can play!");
						
						//****************************other turns********************************************
					
					if(sys.isfull()==true) {
						window.addinfo("player"+player1.getPlayerID()+"got "+sys.comptepoint(player1)+
								"\nplayer"+player2.getPlayerID()+"got "+sys.comptepoint(player2));
						
						window.frame.setVisible(true);
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MapVue(Desk desk,Player player1,Player player2 ){
		initialize();
		this.desk= desk;
		this.playerlist=new Playlist(player1,player2);
		MapInDesk mapindesk=desk.getmap();
		this.mapindesk=mapindesk;
		this.player1=player1;
		this.player2=player2;
		mapindesk.addObserver(this);
		this.sys=new Sys(desk,playerlist);
		
		new MapControle(btnNewButton_0,mapindesk);
		new MapControle(btnNewButton_1,mapindesk);
		new MapControle(btnNewButton_2,mapindesk);
		new MapControle(btnNewButton_3,mapindesk);
		new MapControle(btnNewButton_4,mapindesk);
		new MapControle(btnNewButton_5,mapindesk);
		new MapControle(btnNewButton_6,mapindesk);
		new MapControle(btnNewButton_7,mapindesk);
		new MapControle(btnNewButton_8,mapindesk);
		new MapControle(btnNewButton_9,mapindesk);
		new MapControle(btnNewButton_10,mapindesk);
		new MapControle(btnNewButton_11,mapindesk);
		new MapControle(btnNewButton_12,mapindesk);
		new MapControle(btnNewButton_13,mapindesk);
		new MapControle(btnNewButton_14,mapindesk);

		new DrowCardControle(btnDrowcard_1,infoBoard,player1,desk);
		new DrowCardControle(btnDrowcard_2,infoBoard,player2,desk);
		new DrowVCardControle(btnDrowvcard_1,infoBoard,player1,desk);
		new DrowVCardControle(btnDrowvcard_2,infoBoard,player2,desk);

		new InsertCardControle(btnPlaycard_1,mapindesk,player1);
		new InsertCardControle(btnPlaycard_2,mapindesk,player2);

		new FinishiControle(btnFinish_1,btnMovecard_1,btnPlaycard_1,btnDrowvcard_1,btnDrowcard_1,
				btnFinish_2,btnMovecard_2,btnPlaycard_2,btnDrowvcard_2,btnDrowcard_2);
		new FinishiControle(btnFinish_2,btnMovecard_2,btnPlaycard_2,btnDrowvcard_2,btnDrowcard_2,
				btnFinish_1,btnMovecard_1,btnPlaycard_1,btnDrowvcard_1,btnDrowcard_1);

		new MoveCardControle(btnMovecard_1,desk.getmap());
		new MoveCardControle(btnMovecard_2,desk.getmap());
		new MoveMapNodeControle(btnNewButton_0,mapindesk);
		new MoveMapNodeControle(btnNewButton_1,mapindesk);
		new MoveMapNodeControle(btnNewButton_2,mapindesk);
		new MoveMapNodeControle(btnNewButton_3,mapindesk);
		new MoveMapNodeControle(btnNewButton_4,mapindesk);
		new MoveMapNodeControle(btnNewButton_5,mapindesk);
		new MoveMapNodeControle(btnNewButton_6,mapindesk);
		new MoveMapNodeControle(btnNewButton_7,mapindesk);
		new MoveMapNodeControle(btnNewButton_8,mapindesk);
		new MoveMapNodeControle(btnNewButton_9,mapindesk);
		new MoveMapNodeControle(btnNewButton_10,mapindesk);
		new MoveMapNodeControle(btnNewButton_11,mapindesk);
		new MoveMapNodeControle(btnNewButton_13,mapindesk);
		new MoveMapNodeControle(btnNewButton_14,mapindesk);
		
		
		new ReinitialControle();
		new CompterControle(0,btnCompter,infoBoard,infoBoard1,infoBoard2,sys,player1,player2);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		frame.setContentPane(contentPane);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		Icon icon=new ImageIcon(this.getClass().getResource("/image/null.png")); //image null

		btnNewButton_10 = new MapNodeVue(0,2);
		btnNewButton_10.setBounds(180, 120, 100, 100);
		btnNewButton_10.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_10);


		btnNewButton_11 = new MapNodeVue(1,2);
		btnNewButton_11.setBounds(280, 120, 100, 100);
		btnNewButton_11.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_11);

		btnNewButton_12 = new MapNodeVue(2,2);
		btnNewButton_12.setBounds(380, 120, 100, 100);
		btnNewButton_12.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_12);


		btnNewButton_13 = new MapNodeVue(3,2);
		btnNewButton_13.setBounds(480, 120, 100, 100);
		btnNewButton_13.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_13);


		btnNewButton_14 = new MapNodeVue(4,2);
		btnNewButton_14.setBounds(580, 120, 100, 100);
		btnNewButton_14.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_14);

		btnNewButton_5 = new MapNodeVue(0,1);
		btnNewButton_5.setBounds(180, 220, 100, 100);
		btnNewButton_5.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_5);

		btnNewButton_6 = new MapNodeVue(1,1);
		btnNewButton_6.setBounds(280, 220, 100, 100);
		btnNewButton_6.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_6);

		btnNewButton_7 = new MapNodeVue(2,1);
		btnNewButton_7.setBounds(380, 220, 100, 100);
		btnNewButton_7.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_7);

		btnNewButton_8 = new MapNodeVue(3,1);
		btnNewButton_8.setBounds(480, 220, 100, 100);
		btnNewButton_8.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_8);

		btnNewButton_9 = new MapNodeVue(4,1);
		btnNewButton_9.setBounds(580, 220, 100, 100);
		btnNewButton_9.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_9);

		btnNewButton_0 = new MapNodeVue(0,0);
		btnNewButton_0.setBounds(180, 320, 100, 100);
		btnNewButton_0.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_0);

		btnNewButton_1 = new MapNodeVue(1,0);
		btnNewButton_1.setBounds(280, 320, 100, 100);
		btnNewButton_1.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new MapNodeVue(2,0);
		btnNewButton_2.setBounds(380, 320, 100, 100);
		btnNewButton_2.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_2);

		btnNewButton_3 = new MapNodeVue(3,0);
		btnNewButton_3.setBounds(480, 320, 100, 100);
		btnNewButton_3.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_3);

		btnNewButton_4 = new MapNodeVue(4,0);
		btnNewButton_4.setBounds(580, 320, 100, 100);
		btnNewButton_4.setBorder(blackline);
		frame.getContentPane().add(btnNewButton_4);



		/**
		 * initialement les buttons des fonctions de player1 
		 */
		btnPlaycard_1 = new JButton("Insert card");
		btnPlaycard_1.setIcon(null);
		btnPlaycard_1.setBackground(new Color(255, 192, 203));
		btnPlaycard_1.setBounds(166, 461, 106, 70);
		frame.getContentPane().add(btnPlaycard_1);

		btnMovecard_1 = new JButton("Move card");
		btnMovecard_1.setBackground(new Color(255, 192, 203));
		btnMovecard_1.setBounds(280, 461, 106, 70);
		frame.getContentPane().add(btnMovecard_1);

		btnDrowvcard_1 = new JButton("drow victory carcd");
		btnDrowvcard_1.setBackground(new Color(255, 192, 203));
		btnDrowvcard_1.setBounds(393, 461, 106, 70);
		frame.getContentPane().add(	btnDrowvcard_1);

		btnFinish_1 = new JButton("finishi");
		btnFinish_1.setBackground(new Color(255, 192, 203));
		btnFinish_1.setBounds(509, 461, 106, 70);
		frame.getContentPane().add(btnFinish_1);

		btnDrowcard_1 = new JButton("drow card");
		btnDrowcard_1.setBackground(new Color(255, 192, 203));
		btnDrowcard_1.setBounds(623, 461, 106, 70);
		frame.getContentPane().add(btnDrowcard_1 );

		/**
		 * initialement les buttons des fonctions de player2 
		 */
		btnPlaycard_2 = new JButton("Insert card");
		btnPlaycard_2.setBackground(new Color(255, 250, 205));
		btnPlaycard_2.setBounds(166, 567, 106, 70);
		contentPane.add(btnPlaycard_2);

		btnMovecard_2 = new JButton("Move card");
		btnMovecard_2.setBackground(new Color(255, 250, 205));
		btnMovecard_2.setBounds(280, 567, 106, 70);
		contentPane.add(btnMovecard_2);

		btnDrowvcard_2 = new JButton("drow vicory carcd");
		btnDrowvcard_2.setBackground(new Color(255, 250, 205));
		btnDrowvcard_2.setBounds(393, 567, 106, 70);
		contentPane.add(btnDrowvcard_2);

		btnFinish_2 = new JButton("finishi");
		btnFinish_2.setBackground(new Color(255, 250, 205));
		btnFinish_2.setBounds(509, 567, 106, 70);
		contentPane.add(btnFinish_2);

		btnDrowcard_2 = new JButton("drow card");
		btnDrowcard_2.setBackground(new Color(255, 250, 205));
		btnDrowcard_2.setBounds(623, 567, 106, 70);
		contentPane.add(btnDrowcard_2);

		
		btnCompter= new JButton("Compter");
		btnCompter.setBackground(new Color(255, 250, 205));
		btnCompter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCompter.setBounds(393, 647, 106, 70);
		contentPane.add(btnCompter);
		
		
		btnReinitial = new JButton("Reinitial");
		btnReinitial.setBackground(new Color(220, 220, 220));
		btnReinitial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reinitialiser.reinitialiserMain(btnReinitial, mapindesk,infoBoard,infoBoard1,infoBoard2,sys,player1,player2);
			}
		});
		btnReinitial.setBounds(509, 647, 100, 70);
		contentPane.add(btnReinitial);
		
		infoBoard = new JLabel("Infomation Board");
		infoBoard.setBounds(839, 71, 326, 100);
		infoBoard.setBorder(blackline);
		contentPane.add(infoBoard);
		frame.getContentPane().add(btnNewButton_3);
		

		infoBoard1 = new JLabel("");
		infoBoard1.setBounds(839, 205, 326, 81);
		contentPane.add(infoBoard1);
		
		infoBoard2 = new JLabel("");
		infoBoard2.setBounds(839, 296, 326, 81);
		contentPane.add(infoBoard2);
		


		player1info= new JLabel("player1:");
		player1info.setBounds(98, 489, 58, 15);
		contentPane.add(player1info);

		player2info = new JLabel("player2:");
		player2info.setBounds(98, 595, 58, 15);
		contentPane.add(player2info);



	}
//	public void hiddenplayer() {
//		player2info.setVisible(false);
//		btnDrowcard_2.setVisible(false);
//		btnMovecard_2.setVisible(false);
//		btnPlaycard_2.setVisible(false);
//		btnDrowvcard_2.setVisible(false);
//		btnFinish_2.setVisible(false);
//	}
	/**update the vue
	 * @param sign insert image remove image
	 * @param x
	 * @param y
	 * @param card
	 * 
	 */
	public void update(int x,int y,Card card) {
		Icon icon=new ImageIcon(this.getClass().getResource("/image/"+card.toString()+".png"));
		if(x==0 && y==0) {
			btnNewButton_0.setIcon(icon);
		}
		else if(x==1 && y==0) {
			btnNewButton_1.setIcon(icon);
		}
		else if(x==2 && y==0) {
			btnNewButton_2.setIcon(icon);
		}
		else if(x==3 && y==0) {
			btnNewButton_3.setIcon(icon);
		}
		else if(x==4 && y==0) {
			btnNewButton_4.setIcon(icon);
		}
		else if(x==0 && y==1) {
			btnNewButton_5.setIcon(icon);
		}
		else if(x==1 && y==1) {
			btnNewButton_6.setIcon(icon);
		}
		else if(x==2 && y==1) {
			btnNewButton_7.setIcon(icon);
		}
		else if(x==3 && y==1) {
			btnNewButton_8.setIcon(icon);
		}
		else if(x==4 && y==1) {
			btnNewButton_9.setIcon(icon);
		}
		else if(x==0 && y==2) {
			btnNewButton_10.setIcon(icon);
		}
		else if(x==1 && y==2) {
			btnNewButton_11.setIcon(icon);
		}
		else if(x==2 && y==2) {
			btnNewButton_12.setIcon(icon);
		}
		else if(x==3 && y==2) {
			btnNewButton_13.setIcon(icon);
		}
		else if(x==4 && y==2) {
			btnNewButton_14.setIcon(icon);
		}




	};
	public void update(int x,int y) {
		Icon iconnull=new ImageIcon(this.getClass().getResource("/image/null.png")); //image null
		if(x==0 && y==0) {
			btnNewButton_0.setIcon(iconnull);
		}
		else if(x==1 && y==0) {
			btnNewButton_1.setIcon(iconnull);
		}
		else if(x==2 && y==0) {
			btnNewButton_2.setIcon(iconnull);
		}
		else if(x==3 && y==0) {
			btnNewButton_3.setIcon(iconnull);
		}
		else if(x==4 && y==0) {
			btnNewButton_4.setIcon(iconnull);
		}
		else if(x==0 && y==1) {
			btnNewButton_5.setIcon(iconnull);
		}
		else if(x==1 && y==1) {
			btnNewButton_6.setIcon(iconnull);
		}
		else if(x==2 && y==1) {
			btnNewButton_7.setIcon(iconnull);
		}
		else if(x==3 && y==1) {
			btnNewButton_8.setIcon(iconnull);
		}
		else if(x==4 && y==1) {
			btnNewButton_9.setIcon(iconnull);
		}
		else if(x==0 && y==2) {
			btnNewButton_10.setIcon(iconnull);
		}
		else if(x==1 && y==2) {
			btnNewButton_11.setIcon(iconnull);
		}
		else if(x==2 && y==2) {
			btnNewButton_12.setIcon(iconnull);
		}
		else if(x==3 && y==2) {
			btnNewButton_13.setIcon(iconnull);
		}
		else if(x==4 && y==2) {
			btnNewButton_14.setIcon(iconnull);
		}
	}
	
	
	public void addinfo(Icon icon) {
		infoBoard.setIcon(icon);
	}
	public void addinfo(String s) {
		this.infoBoard.setText(s);
	}

	public void update(Object o) {}
}




















