package modele;

import vue.MapVue;
import java.util.Scanner;
public class SysGraph2Per extends Sys implements Runnable{
	private Thread thread_player; //thread for read from console for player1
	private Sys sys;
	public SysGraph2Per() {
		
		
	}
	

	public void processu_vp(){
		//initial playerlist
				System.out.println("******initial playerlist*****");	
		    	Player player1 = new Player();
		    	Player player2= new VirtuelPlayer();
				Playlist playerlist = new Playlist(player1,player2);
				playerlist.showallplayer();
				
				//initial map
				System.out.println("******initial map*****");
				MapInDesk map = new MapInDesk();
				
				//initial cardheap
				System.out.println("******initial cardheap*****");
				CardHeap cardheap = new CardHeap();
				cardheap.washHeap();
				
				// initial desk
				System.out.println("******initial desk*****");
				Desk desk = new Desk(map,cardheap);
			
				//initial vue
				System.out.println("******initial vue*****");
				MapVue vue = new MapVue(desk,player1,player2);
				
				
				// initial system
				this.sys = new Sys(desk,playerlist);
				this.sys.getmap().showmap();
				this.sys.getplayerlist().showallplayer();
				int turn=1; //compter le tourne
				
				
				// initial thread player
				thread_player=new Thread(this);
				thread_player.run();
				
				
			//****************************1st turn********************************************		
				//indiquez first player and second player drow victorycard and play
				vue.addinfo("aaa");
				while(player1.getvictorycard()==null || player2.getvictorycard()==null) {
					if(player1.getvictorycard()==null) {
						vue.addinfo("player"+player1.getPlayerID()+" tirer votre victorycard ");
					}
					if(player1.getvictorycard()!=null&&player2.getvictorycard()==null) {
						vue.addinfo("player"+player2.getPlayerID()+" tirer votre victorycard ");
					}
					
				}
				

				if(this.sys.isfull()==true) {
				vue.addinfo("player"+player1.getPlayerID()+"got "+sys.comptepoint(player1)+
						"\nplayer"+player2.getPlayerID()+"got "+sys.comptepoint(player2));
				}	
	}
	

	public void run() {
		//initiale scanner for string and sacnner0 for int
		Scanner scanner = new Scanner(System.in);
		Scanner scanner0 = new Scanner(System.in);
		int sign=0;
		int sign_playcard=0; //repsent player havent done 
		int sign_move=0;     //repsent player havent done
		Player player1=sys.getplayerlist().getplayer(0);
		Player player2=sys.getplayerlist().getplayer(1);
		System.out.println("Start Game!!!!!!!!");
	    playmainmenue();
		String choisi = scanner.nextLine();
		System.out.println("votre choisi="+choisi);	
		
		switch(choisi){
		//2 player mode
		case "1" :
			int turn=1; //compter le tourne
   	//****************************1st turn********************************************		
			//indiquez first player drow victorycard and play
			sys.playmenuedrowvictorycard(player1);
			choisi=scanner.nextLine();
			sys.drowvictorycard(player1,choisi);
			//indiquez second player drow victorycard and play
			sys.playmenuedrowvictorycard(player2);
			choisi=scanner.nextLine();
			sys.drowvictorycard(player2,choisi);
	//****************************other turns********************************************
			while(sys.isfull()==false) {
				System.out.println("**********tourne "+turn+"**********");
				
				//first player'turn
				sys.player_turn(sign, sign_playcard, sign_move, player1);
				//second player'turn
				sys.player_turn(sign, sign_playcard, sign_move, player2);
				
				turn++;
			}
			System.out.println("game over");
			System.out.println("player"+player1.getPlayerID()+player1.getvictorycard()+"obtenue "+sys.comptepoint(player1)+" points");
			System.out.println("player"+player2.getPlayerID()+player2.getvictorycard()+"obtenue "+sys.comptepoint(player2)+" points");
	    break;
	    //3 players mode
	    case "2" :
	    	
	    	//initial playerlist 
	    	System.out.println("******initial playerlist*****");	
	    	Player player3 = new Player();
			Player player4=  new Player();
			Player player5=  new Player();
			Playlist playerlist3 = new Playlist(player3,player4,player5);
			playerlist3.showallplayer();
				
			//initial map
			System.out.println("******initial map*****");
			MapInDesk map3 = new MapInDesk();
			//initial cardheap
			System.out.println("******initial cardheap*****");
			CardHeap cardheap3 = new CardHeap();
			cardheap3.washHeap();
			
			// initial desk
			System.out.println("******initial desk*****");
			Desk desk3 = new Desk(map3,cardheap3);
			// initial system
			Sys sys3 = new Sys(desk3,playerlist3);
			sys3.getmap().showmap();
			int turn3=1;
   	//****************************1st turn********************************************		
			//indiquez first player drow victorycard 
			sys3.playmenuedrowvictorycard(player3);
			choisi=scanner.nextLine();
			sys3.drowvictorycard(player3,choisi);
			//indiquez second player drow victorycard 
			sys3.playmenuedrowvictorycard(player4);
			choisi=scanner.nextLine();
			sys3.drowvictorycard(player4,choisi);
			//indiquez second player drow victorycard 
			sys3.playmenuedrowvictorycard(player5);
			choisi=scanner.nextLine();
			sys3.drowvictorycard(player5,choisi);
	//****************************other turns********************************************
			while(sys3.isfull()==false) {
				System.out.println("**********tourne "+turn3+"**********");
				
				//first player'turn
				sys3.player_turn(sign, sign_playcard, sign_move, player3);
				//second player'turn
				sys3.player_turn(sign, sign_playcard, sign_move, player4);
				//third player'turn
				sys3.player_turn(sign, sign_playcard, sign_move, player5);
				turn3++;
			}
			System.out.println("game over");
			System.out.println("player"+player3.getPlayerID()+player3.getvictorycard()+"obtenue "+sys3.comptepoint(player3)+" points");
			System.out.println("player"+player4.getPlayerID()+player4.getvictorycard()+"obtenue "+sys3.comptepoint(player4)+" points");
			System.out.println("player"+player5.getPlayerID()+player5.getvictorycard()+"obtenue "+sys3.comptepoint(player5)+" points");
		    break; 
	    case "3"://conter avec ordinateur
			//initial playerlist 
	    	System.out.println("******initial playerlist*****");	
	    	Player player6 = new Player(); //player real
			VirtuelPlayer player7=  new VirtuelPlayer(); //player virtuel
			Playlist playerlistv = new Playlist(player6,player7);
			playerlistv.showallplayer();
				
			//initial map
			System.out.println("******initial map*****");
			MapInDesk mapv = new MapInDesk();
			//initial cardheap
			System.out.println("******initial cardheap*****");
			CardHeap cardheapv = new CardHeap();
			cardheapv.washHeap();
			
			// initial desk
			System.out.println("******initial desk*****");
			Desk deskv = new Desk(mapv,cardheapv);
			// initial system
			Sys sysv = new Sys(deskv,playerlistv);
			sysv.getmap().showmap();
			int turnv=1; //compter le tourne
	    	
	    	playmenuechoisiDifficulty(); //play menu of cchosi mode of virtuel player
	    	choisi=scanner.nextLine();
			System.out.println("votre choisi="+choisi);	
			VirtuelPlayer vir = new VirtuelPlayer();
			switch(choisi) {
			case "1":
				System.out.println("virtuel player is simple");
				Strategy A = new StrategyA();
				vir.changeStrategy(A);
			break;
			case "2":
				System.out.println("virtuel player is more complex");
				Strategy B = new StrategyB();
				vir.changeStrategy(B);
			break;
			}
			//****************************1st turn********************************************		
			//indiquez first player drow victorycard 
			sysv.playmenuedrowvictorycard(player6);
			choisi=scanner.nextLine();
			sysv.drowvictorycard(player6,choisi);
			//ivirtuelplayer drow victorycard 
			
			vir.drow(deskv);
			vir.setvictorycard(vir.getcardinhand()); //setvictorycard of vp
			System.out.println("Virtuel player"+vir.getPlayerID()+"drow victory card "+
			vir.getvictorycard());
	//****************************other turns********************************************
			while(sysv.isfull()==false) {
				System.out.println("**********tourne "+turnv+"**********");
				//first player'turn
				sysv.player_turn(sign, sign_playcard, sign_move, player6);
				//virtuel player'turn
				vir.drow(deskv);
				vir.decidePlay(mapv, deskv);
				turnv++;
			}
			System.out.println("game over");
			System.out.println("player"+player6.getPlayerID()+player6.getvictorycard()+"obtenue "+sysv.comptepoint(player6)+" points");
			System.out.println("player"+player7.getPlayerID()+player7.getvictorycard()+"obtenue "+sysv.comptepoint(player7)+" points");
			
			
			
			
	    case "5" :
	    	System.out.println("bye bye");	
		    break; 
		}
	 


			

	
		
		 
	}
		
	
	public void strat() {
		System.out.println("Starting " );
		if (thread_player == null) {
			thread_player = new Thread (thread_player);
			thread_player.start ();
	      }
	}
	public static void main(String[] args) {
		SysGraph2Per sys = new SysGraph2Per();
		sys.processu_vp();
	}
}
