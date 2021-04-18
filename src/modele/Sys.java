package modele;
import java.util.*;
import vue.*;
/**
 * <p>Backend system of the game witch controls the process of the game
 * @author Wang Taojun
 * @since 25 December 2020
 * @version 1.0
 */
public class Sys {
	private Desk desk;
	private Playlist playerlist;
	private Compteur compteur;
	
	private MapVue vue;
    /**
     * <p>play mianmenue 
     */
	public static void playmainmenue() {
		System.out.println("*********************************");
		System.out.println("          1. 2 personnes ");
		System.out.println("          2. 3 personnes ");
		System.out.println("          3. conter avec computer ");
		System.out.println("          4. comment jouer ");
		System.out.println("          5. quiter ");
		System.out.println("*********************************");
		System.out.println("tapper votre choisi");
	}
    /**
     * <p>play menu
     */
	public void playmenue_guideplayer(Player player) {
		System.out.println("*********************************");
		System.out.println("          Playr"+player.getPlayerID()+"'s turn");
		System.out.println("          1. drow and play card in hand ");
		System.out.println("          2. move carte ");
		System.out.println("          3. check victory card ");
		System.out.println("          4. check card in hand ");
		System.out.println("          5. showmap ");
		System.out.println("          6. finish this turn ");
		System.out.println("*********************************");
		System.out.println("player"+player.getPlayerID()+" entrer votre choisi");
	}
	/**
	 * play menue when player drow the victorycard
	 * @param player {@link Player}]
	 */
	public void playmenuedrowvictorycard(Player player) {
		System.out.println("*********************************");
		System.out.println("player"+player.getPlayerID()+" tirer votre victorycard ");
		System.out.println("entrer Y drow entrer N quite  ");
		System.out.println("********************************");
	}
	/**
	 * play menue when player drow the victorycard
	 * @param player {@link Player}]
	 */
	public void playmenuedrowcard(Player player) {
		System.out.println("*********************************");
		System.out.println("player"+player.getPlayerID()+" drow card ");
		System.out.println("entrer Y drow entrer N quite ");
		System.out.println("*********************************");
	}
	/**
	 * <p> Show the list which stored all the cards that has been played.
	 * @param player
	 */
	public void showlistcard_played(Player player) {
		player.showlistcard_played();
	}
	/**
	 * <p>play menue of choisi
	 */
	public static void playmenuechoisiDifficulty() {
		System.out.println("*********************************");
		System.out.println("choisi le mode:");
		System.out.println("1. mode simple");
		System.out.println("2. mode difficult");
		System.out.println("*********************************");
		System.out.println("entre votre choisi");
	}
	/**
	 * player drows {@code card}
	 * @param player {@link Player}
	 * @param choisi 
	 */
	public void drowcard(Player player,String choisi) {
		System.out.println("votre choisi="+choisi);
		switch(choisi) {
		case "Y"  :case "y" :
			player.drow(desk);
			System.out.println("votre card ="+player.getcardinhand());
		break;
		case "N" :case "n" :
			System.out.println("88");	;
		break;
		}

	}
	/**
	 * <p>processu de drow card
	 * @param player
	 * @param choisi
	 */
	public void drowvictorycard(Player player,String choisi) {
		System.out.println("votre choisi="+choisi);
		switch(choisi) {
		case "Y"  :case "y" :
			System.out.println(player.getvictorycard());
			player.drow(desk);
			player.setvictorycard(player.getcardinhand()); //set victorycard
			System.out.println("votre victorycard ="+player.getvictorycard());
		break;
		case "N" :case "n" :
			System.out.println("88");	
		break;
		}
	}
	/**
	 * <p>Creat a {@code sys} based on {@code desk} and {@code playerlist}
	 * @param desk
	 * @param playerlist
	 */
	public Sys(Desk desk,Playlist playerlist) {
		this.desk=desk;
		this.playerlist=playerlist;
		this.compteur=new Compteur();
	}
	/**
	 * <p>Creat a {@code sys}
	 */
	public Sys() {}
	/**
	 * <p>Get {@code this.desk.map}
	 * @return map {@link MapInDesk}
	 */
	public MapInDesk getmap() {
		return desk.getmap();
	}
	/**
	 * <p>Get player list
	 * @return playerlist
	 */
	public Playlist getplayerlist() {
		return playerlist;
	}
	/**
	 * Determine if the map is full
	 * @return {@code true} if the map is full, {@code false} if the map is not full
	 */
	public boolean isfull() {
		return desk.getmap().isfull();
	}
	/**
	 * <p>Calculate points in the map by victorycard of player.Calculate scores by row and by column
	 * @param player
	 * @return points of {@code player}
	 */
	public int comptepoint(Player player) {
		return compteur.compte(desk, player.getvictorycard());
	}
	public int comptepointRei(Player player) {
		int i=compteur.compte(desk, player.getvictorycard())-2;
		return i;
	}
	/**
	 * <p>All the things that a player should do in one tour
	 * @param sign
	 * @param sign_playcard
	 * @param sign_move
	 * @param player
	 */
	public void player_turn(int sign,int sign_playcard,int sign_move,Player player) {
		Scanner scanner = new Scanner(System.in); //read String
		Scanner scanner0 = new Scanner(System.in);//read int
		while(sign==0) {
			playmenue_guideplayer(player);//play the menu for player witch guide player1 for what he can do
			String choisi=scanner.nextLine();
			switch(choisi) {
			case "1": //drow play cardinhande
				if(sign_playcard==0) {
					playmenuedrowcard(player);
					choisi=scanner.nextLine();
					drowcard(player,choisi);  //player1 drow card
					System.out.println("mettre votre carte "+player.getcardinhand()+" dans positionx [0,4]");
					int x=scanner0.nextInt();
					System.out.println("mettre votre carte "+player.getcardinhand()+" dans positiony [0,2]");
					int y=scanner0.nextInt();
					returnetat rt=player.play(desk, x, y); //if the option play is successful 
					if(rt==returnetat.successful) {
						sign_playcard=1;
						desk.map.showmap();
					}
					else {
						System.out.println("you can't insert card here");
					}
						
				}
				else {
					System.out.println("you have played card");
				}
			break;
			case "2":
				if(sign_move==0) {
					System.out.println("choose card witch you want to choose");
					player.showlistcard_played();
					System.out.println("you want to move whitch card ?");
					System.out.println("card position x [0,4]");
					int x0=scanner0.nextInt();
					System.out.println("card position y [0,2]");
					int y0=scanner0.nextInt();
					System.out.println("to whitch position");
					System.out.println("card position x [0,4]");
					int x1=scanner0.nextInt();
					System.out.println("card position y [0,2]");
					int y1=scanner0.nextInt();
					returnetat rt=player.move(desk, getmap().findkey(x0,y0), getmap().findkey(x1,y1));
					if(rt==returnetat.successful) {
						getmap().showmap();
						sign_move=1;
					}
					else {
						System.out.println("can't move like this");
					}
						
				}
				else {
					System.out.println("you have moved card");
				}
			break;
			case "3":
			    System.out.println(player.getvictorycard());
			
			break;
		    case "4":
		    	System.out.println(player.getcardinhand());
			break;
			case "5":
				getmap().showmap();
			break;
			case "6":
				if(sign_playcard==1) {
					sign=1;
				}
				else {
					System.out.println("you have to at least play card");
				}
			break;
		}
	  }
			sign=sign_playcard*sign_move; //si et seulement si player has done play and move
	
		sign=0;
		sign_playcard=0; //repsent player havent done 
		sign_move=0;     //repsent player havent done
	}
	/**
	 * <p>initial all iteam in the sys
	 * @param num_of_player
	 */
	public void initialment(int num_of_player) {
		//initial playerlist 
    	System.out.println("******initial playerlist*****");	
    	if(num_of_player==2) {
    		Player player1 = new Player();
    		Player player2=  new Player();
    		Playlist playerlist = new Playlist(player1,player2);
    		playerlist.showallplayer();
    	}
    	else if(num_of_player==3) {
    		Player player1 = new Player();
    		Player player2=  new Player();
    		Player player3=  new Player();
    		Playlist playerlist = new Playlist(player1,player2,player3);
    		playerlist.showallplayer();
    	}
   
			
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
		// initial system
		Sys sys = new Sys(desk,playerlist);
		sys.getmap().showmap();
	}
	
	public static void main(String[] args) {
		//initiale scanner for string and sacnner0 for int
		Scanner scanner = new Scanner(System.in);
		Scanner scanner0 = new Scanner(System.in);
		int sign=0;
		int sign_playcard=0; //repsent player havent done 
		int sign_move=0;     //repsent player havent done
		System.out.println("Start Game!!!!!!!!");
		 try { 
			 Thread.currentThread().sleep(1000);
		 } 
		 catch(Exception e){}
		 System.out.println("initialement");
		 try { 
			 Thread.currentThread().sleep(1000);
		 } 
		 catch(Exception e){}
	        
	    playmainmenue();
		String choisi = scanner.nextLine();
		System.out.println("votre choisi="+choisi);	
		
		switch(choisi){
		//2 player mode
		case "1" :
	    	
			//initial playerlist 
	    	System.out.println("******initial playerlist*****");	
	    	Player player1 = new Player();
			Player player2=  new Player();
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
			// initial system
			Sys sys = new Sys(desk,playerlist);
			sys.getmap().showmap();
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
}