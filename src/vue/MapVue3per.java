package vue;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Controle.CompterControle;
import Controle.DrowCardControle;
import Controle.DrowVCardControle;
import Controle.FinishiControle;
import Controle.InsertCardControle;
import Controle.MapControle;
import Controle.MoveCardControle;
import Controle.MoveMapNodeControle;
import Observer_Pattern.Observer;
import modele.Card;
import modele.CardHeap;
import modele.Desk;
import modele.MapInDesk;
import modele.Player;
import modele.Playlist;
import modele.Sys;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MapVue3per<Player3> implements Observer{

	private JFrame frame;
	private JPanel contentPane;
	private JLabel infoBoard;
	private JLabel infoBoard1;
	private JLabel infoBoard2;
	private JLabel infoBoard3;
	private JLabel player1info;
	private JLabel player2info;
	private JLabel player3info;


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

	private JButton btnPlaycard_3;
	private JButton btnMovecard_3;
	private JButton btnDrowvcard_3;
	private JButton btnFinish_3;
	private JButton btnDrowcard_3;

	private JButton btnCompter;
	
	private Sys sys;
	private Desk desk;
	private Playlist playerlist;
	/**
	 * Launch the application.
	 */
	public static void mapvue3per() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int sign=0;
					int sign_playcard=0; //repsent player havent done 
					int sign_move=0;     //repsent player havent done
					//initial playerlist
					Player player1 = new Player();
					Player player2=  new Player();
					Player player3 = new Player();
					Playlist playerlist = new Playlist(player1,player2,player3);
					MapInDesk map = new MapInDesk();
					//initial cardheap
					CardHeap cardheap = new CardHeap();
					cardheap.washHeap();
					// initial desk
					Desk desk = new Desk(map,cardheap);
					Sys sys = new Sys(desk,playerlist);
					//initial vue
					MapVue3per window = new MapVue3per(desk,player1,player2,player3);
					window.frame.setVisible(true);
					
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
								"\nplayer"+player2.getPlayerID()+"got "+sys.comptepoint(player2)
								+"\nplayer"+player3.getPlayerID()+"got "+sys.comptepoint(player3));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MapVue3per(Desk desk,Player player1,Player player2,Player player3) {
		initialize();
		this.desk= desk;
		this.playerlist=new Playlist(player1,player2,player3);
		MapInDesk mapindesk=desk.getmap();
		mapindesk.addObserver(this);

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
		new DrowCardControle(btnDrowcard_3,infoBoard,player3,desk);
		
		new DrowVCardControle(btnDrowvcard_1,infoBoard,player1,desk);
		new DrowVCardControle(btnDrowvcard_2,infoBoard,player2,desk);
		new DrowVCardControle(btnDrowvcard_3,infoBoard,player3,desk);
		
		new InsertCardControle(btnPlaycard_1,mapindesk,player1);
		new InsertCardControle(btnPlaycard_2,mapindesk,player2);
		new InsertCardControle(btnPlaycard_3,mapindesk,player3);
		
		new FinishiControle(btnFinish_1,btnMovecard_1,btnPlaycard_1,btnDrowvcard_1,btnDrowcard_1,
				btnFinish_2,btnMovecard_2,btnPlaycard_2,btnDrowvcard_2,btnDrowcard_2,btnFinish_3,
				btnMovecard_3,btnPlaycard_3,btnDrowvcard_3,btnDrowcard_3);
		
		new FinishiControle(btnFinish_2,btnMovecard_2,btnPlaycard_2,btnDrowvcard_2,btnDrowcard_2,
				btnFinish_1,btnMovecard_1,btnPlaycard_1,btnDrowvcard_1,btnDrowcard_1,
				btnFinish_3,btnMovecard_3,btnPlaycard_3,btnDrowvcard_3,btnDrowcard_3);
		
		new FinishiControle(btnFinish_3,btnMovecard_3,btnPlaycard_3,btnDrowvcard_3,btnDrowcard_3,
				btnFinish_2,btnMovecard_2,btnPlaycard_2,btnDrowvcard_2,btnDrowcard_2,btnFinish_1,
				btnMovecard_1,btnPlaycard_1,btnDrowvcard_1,btnDrowcard_1);
		new MoveCardControle(btnMovecard_1,desk.getmap());
		new MoveCardControle(btnMovecard_2,desk.getmap());
		new MoveCardControle(btnMovecard_3,desk.getmap());
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
		
		new CompterControle(btnCompter,infoBoard,infoBoard1,infoBoard2,infoBoard3,sys,player1,player2,player3);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1035, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);

		Border blackline = BorderFactory.createLineBorder(Color.black);
		Icon icon=new ImageIcon(this.getClass().getResource("/image/null.png")); //image null
		contentPane.setLayout(null);
		
		player3info = new JLabel("player3:");//
		player3info.setBounds(102, 613, 54, 15);
		contentPane.add(player3info);
		
		btnPlaycard_3 = new JButton("Insert card");
		btnPlaycard_3.setBackground(new Color(224, 255, 255));
		btnPlaycard_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlaycard_3.setBounds(166, 593, 106, 70);
		contentPane.add(btnPlaycard_3);
		
		btnMovecard_3 = new JButton("Move card");
		btnMovecard_3.setBackground(new Color(224, 255, 255));
		btnMovecard_3.setBounds(280, 593, 106, 70);
		contentPane.add(btnMovecard_3);
		
		btnDrowvcard_3 = new JButton("drow victorycard");
		btnDrowvcard_3.setBackground(new Color(224, 255, 255));
		btnDrowvcard_3.setBounds(400, 593, 106, 70);
		contentPane.add(btnDrowvcard_3);
		
		btnFinish_3 = new JButton("finishi");
		btnFinish_3.setBackground(new Color(224, 255, 255));
		btnFinish_3.setBounds(516, 593, 106, 70);
		contentPane.add(btnFinish_3);
		
		btnDrowcard_3 = new JButton("drow card");
		btnDrowcard_3.setBackground(new Color(224, 255, 255));
		btnDrowcard_3.setBounds(632, 593, 106, 70);
		contentPane.add(btnDrowcard_3);

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
		btnPlaycard_1.setBackground(new Color(255, 192, 203));
		btnPlaycard_1.setBounds(166, 433, 106, 70);
		frame.getContentPane().add(btnPlaycard_1);

		btnMovecard_1 = new JButton("Move card");
		btnMovecard_1.setBackground(new Color(255, 192, 203));
		btnMovecard_1.setBounds(280, 433, 106, 70);
		frame.getContentPane().add(btnMovecard_1);

		btnDrowvcard_1 = new JButton("drow victory card");
		btnDrowvcard_1.setBackground(new Color(255, 192, 203));
		btnDrowvcard_1.setBounds(400, 433, 106, 70);
		frame.getContentPane().add(	btnDrowvcard_1);

		btnFinish_1 = new JButton("finishi");
		btnFinish_1.setBackground(new Color(255, 192, 203));
		btnFinish_1.setBounds(516, 433, 106, 70);
		frame.getContentPane().add(btnFinish_1);

		btnDrowcard_1 = new JButton("drow card");
		btnDrowcard_1.setBackground(new Color(255, 192, 203));
		btnDrowcard_1.setBounds(632, 433, 106, 70);
		frame.getContentPane().add(btnDrowcard_1 );

		/**
		 * initialement les buttons des fonctions de player2 
		 */
		btnPlaycard_2 = new JButton("Insert card");
		btnPlaycard_2.setBackground(new Color(255, 250, 205));
		btnPlaycard_2.setBounds(166, 513, 106, 70);
		contentPane.add(btnPlaycard_2);

		btnMovecard_2 = new JButton("Move card");
		btnMovecard_2.setBackground(new Color(255, 250, 205));
		btnMovecard_2.setBounds(280, 513, 106, 70);
		contentPane.add(btnMovecard_2);

		btnDrowvcard_2 = new JButton("drow vicory carcd");
		btnDrowvcard_2.setBackground(new Color(255, 250, 205));
		btnDrowvcard_2.setBounds(400, 513, 106, 70);
		contentPane.add(btnDrowvcard_2);

		btnFinish_2 = new JButton("finishi");
		btnFinish_2.setBackground(new Color(255, 250, 205));
		btnFinish_2.setBounds(516, 513, 106, 70);
		contentPane.add(btnFinish_2);

		btnDrowcard_2 = new JButton("drow card");
		btnDrowcard_2.setBackground(new Color(255, 250, 205));
		btnDrowcard_2.setBounds(632, 513, 106, 70);
		contentPane.add(btnDrowcard_2);

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
		
		infoBoard3 = new JLabel("");
		infoBoard3.setBounds(839, 405, 326, 81);
		contentPane.add(infoBoard3);
		
		btnCompter= new JButton("Compter");
		btnCompter.setBackground(new Color(255, 250, 205));
		btnCompter.setBounds(757, 613, 106, 70);
		contentPane.add(btnCompter);

		player1info= new JLabel("player1:");
		player1info.setBounds(98, 461, 58, 15);
		contentPane.add(player1info);

		player2info = new JLabel("player2:");
		player2info.setBackground(Color.PINK);
		player2info.setBounds(98, 541, 58, 15);
		contentPane.add(player2info);

	}
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
		infoBoard.setText(s);
	}

	public void update(Object o) {}
}


