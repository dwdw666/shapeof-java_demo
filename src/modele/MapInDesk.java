package modele;
import Observer_Pattern.*;

import Observer_Pattern.Observable;
import javax.swing.*;
import java.util.*;
/**
 * <p>The class {@link MapInDesk} implements the interface {@link Observable} and contains a map 5*3 and provide methodes which can 
edit map 
 * @author Wang Taojun
 * @since 15 December 2020
 *@version 1.0
 */
public class MapInDesk extends Observable {
	public Map<Mapenodekey,MapNode> mapindesk = new HashMap<Mapenodekey,MapNode>();
	private Player plycurrent;
	private Mode mode; 	//indiquer le mode : "insert","move","normal"
	private Icon icon_move; //for move mode
	private Card card_move; //for move mode
	/**
	 * <p> Creat a map with 15 {@link Mapenodekey} 
	 * 
	 */
	public MapInDesk() {
		for(int i=0;i<=4;i++) {
			for(int j=0;j<=2;j++) {
				Mapenodekey mapnodekey = new Mapenodekey(i,j);
				mapindesk.put(mapnodekey,new MapNode());
				System.out.println("creer "+mapnodekey.toString()+" "+mapindesk.get(mapnodekey));
			}
		}
		System.out.println("creer une nouvelle map and size ="+mapindesk.size());
	}
	/**
	 * <p>Get the Map stored 
	 * @return {@link HashMap} 
	 */
	public HashMap<Mapenodekey, MapNode> getMapindesk() {
		return (HashMap<Mapenodekey, MapNode>) this.mapindesk;
	}
	/**
	 * <p>Enter position (x,y) of the key and return the key witch conforms
	 * @param x position x
	 * @param y position y
	 * @return the key witch conforms
	 */
	public Mapenodekey findkey(int x, int y){
		for(Mapenodekey key : mapindesk.keySet()) {
			if(key.getx()==x && key.gety()==y) 
				return key;

		}

		Mapenodekey key = new Mapenodekey(0,0);
		return key;

	}
	/**
	 * <p>Enter a {@code Mapenodekey} and return the key witch conforms the methodes {@code equal}
	 * @param mpkey
	 * @return
	 */
	public Mapenodekey findkey(Mapenodekey mpkey){
		for(Mapenodekey key : mapindesk.keySet()) {
			if(key.equals(mpkey)) 
				return key;

		}

		Mapenodekey key = new Mapenodekey(0,0);
		return key;

	}
	/**
	 * <p>Enter position (x,y) of the key and return the {@code Card} witch conforms
	 * @param x position x
	 * @param y position y
	 * @return {@code Card} witch conforms
	 */
	public Card findcard(int x,int y) {
		Mapenodekey key=new Mapenodekey(x,y);
		key=findkey(key);
		return mapindesk.get(key).getcard();
	}
	/**
	 * <p>Determine if the map is full
	 *
	 * @return {@code true} if the map is full {@code false} if the map is not full
	 */
	public boolean isfull() {
		int sign=1;
		for (Map.Entry<Mapenodekey,MapNode> entry : mapindesk.entrySet()) {
			if(entry.getValue().getcard()==null) {
				sign=0;
			}

		}
		if(sign==0) {
			return false;
		}
		else
			return true;
	}
	/**
	 * <p>Set the champs disponibles for cards adjacency,
	 * @param key
	 * @param i
	 */
	public void setDisponibleAdjacency(Mapenodekey key,int i) {
		if(key.getx()-1>=0 && key.gety()<=2) {
			int x=key.getx();
			int y=key.gety();
			for(Mapenodekey mapkey:mapindesk.keySet()) {
				if(mapkey.getx()==x-1 && mapkey.gety()==y) {
					mapindesk.get(mapkey).setDisponible(i);

				}
			}

		}
		if(key.getx()+1<=4 && key.gety()<=2) {
			int x=key.getx();
			int y=key.gety();
			for(Mapenodekey mapkey:mapindesk.keySet()) {
				if(mapkey.getx()==x+1 && mapkey.gety()==y) {
					mapindesk.get(mapkey).setDisponible(i);


					//		    			System.out.println(mapindesk.get(mapkey).GetDisponible());
					//		    			System.out.println(mapindesk.get(mapkey).Getcard());
				}
			}

		}
		if(key.getx()<=4 && key.gety()+1<=2) {
			int x=key.getx();
			int y=key.gety();
			for(Mapenodekey mapkey:mapindesk.keySet()) {
				if(mapkey.getx()==x && mapkey.gety()==y+1) {
					mapindesk.get(mapkey).setDisponible(i);

				}
			}

		}
		if(key.getx()<=4 && key.gety()-1>=0) {
			int x=key.getx();
			int y=key.gety();
			for(Mapenodekey mapkey:mapindesk.keySet()) {
				if(mapkey.getx()==x && mapkey.gety()==y-1) {
					mapindesk.get(mapkey).setDisponible(i);

				}
			}

		}
		//	 System.out.println("SetDisponibleAdjacency for key"+key.toString());
	}


	/**
	 * Insert card and notify observer
	 * @param  key {@code Mapenodekey} 
	 * @param card {@code Card} 
	 * @return {@code successful} if insert successfully, {@code fail} if insert unsuccessfully
	 */
	public returnetat insertcard(Mapenodekey key,Card card) {
		int sign=0;
		key=findkey(key); //change this key to a real key
		MapNode mpnd = new MapNode(card,mapindesk.get(key).getDisponible()); //mpnd has card which we offer and original disponible 

		for(Mapenodekey mapnodekey : mapindesk.keySet()) {
			if(mapindesk.get(mapnodekey).getcard()!=null) {
				sign=1;
			}
		}
		if(sign==0) {
			//if this is the first card, we can insert this card and set the disponible as true which means this mapnode has been filled 
			mpnd.setDisponible(-1);     //set this disponible -1
			setDisponibleAdjacency(key,1); // set disponible for cards Adjacency+1
			mapindesk.put(key, mpnd); 
			System.out.println(" Inset first card "+mapindesk.get(key));
			this.setChanged();
			this.notifyObservers(key.getx(),key.gety(),mpnd.getcard()); // notify observser
			System.out.println("ss"); //test
			return returnetat.successful;
		}
		else{//there are cards in the map
			if( mapindesk.get(key).getDisponible()>0 && mapindesk.get(key).getcard()==null ) { //le position doit etre disponible if disponibe>0
				mpnd.setDisponible(-1); 
				setDisponibleAdjacency(key,+1);
				mapindesk.put(key, mpnd);
				System.out.println("Insertcard in "+mapindesk.get(key));
				this.setChanged();
				this.notifyObservers(key.getx(),key.gety(),mpnd.getcard()); // notify observer
				return returnetat.successful;

			}
			else{
				System.out.println(" We can't Insertcard here"+mapindesk.get(key));
				this.setChanged();
				this.notifyObservers(" We can't Insertcard here");
				return returnetat.fail;
			}

		}


	}

	/**
	 * <p>Remove card if there are a card lied this key and notify observer
	 * @param key {@code Mapenodekey} 
	 * @return {@code successful} if remove successfully, {@code fail} if remove unsuccessfully
	 */
	public returnetat removemapnode(Mapenodekey key) {
		key=findkey(key);  //find a usefull key
		if( mapindesk.get(key).getcard()!=null) {
			mapindesk.get(key).setDisponible(+1);
			setDisponibleAdjacency(key,-1);
			mapindesk.get(key).setcard(null);
			System.out.println("remove card"+mapindesk.get(key).getcard());
			this.setChanged();
			this.notifyObservers(key.getx(),key.gety());
			return returnetat.successful;
		}
		else
			return returnetat.fail;
	}
	/** 
	 * <p> Move card from position of {@code key1} to {@code key2} 
	 * @param key1 {@code Mapenodekey} 
	 * @param key2 {@code Mapenodekey} 
	 * @return {@code successful} if move successfully, {@code fail} if move unsuccessfully
	 */
	public returnetat move(Mapenodekey key1,Mapenodekey key2) {
		key1=findkey(key1);
		key2=findkey(key2);

		if( mapindesk.get(key2).getDisponible()>0 && mapindesk.get(key2).getcard()==null && mapindesk.get(key1).getcard()!=null) {

			Card card=mapindesk.get(key1).getcard();
			removemapnode(key1); //remove le mapnode1
			returnetat rt=insertcard(key2,card); //
			return rt;
		}
		else {
			System.out.println("we can't move like this");
			return returnetat.fail;
		}

	}
	/**
	 * change
	 * @param key1
	 * @param key2
	 */
	public void change(Mapenodekey key1,Mapenodekey key2) {
		key1=findkey(key1);
		key2=findkey(key2);

		

			Card card1=mapindesk.get(key1).getcard();
			Card card2=mapindesk.get(key2).getcard();
			MapNode mpnd1 = new MapNode(card1,mapindesk.get(key1).getDisponible());
			MapNode mpnd2 = new MapNode(card2,mapindesk.get(key2).getDisponible());
			removemapnode(key1); //remove le mapnode1
			removemapnode(key2);
			
			this.insertcard(key1,card2); //
			this.insertcard(key2,card1);
	}
/**
 * reinitialiser
 * @param n
 */
	public void reinitialiser(int n) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Mapenodekey> listkey1 = new ArrayList<Mapenodekey>();
		List<Mapenodekey> listkey2 = new ArrayList<Mapenodekey>();
		for (int i = 0; i < 5; i++)
			list1.add(new Integer(i));
		System.out.println(list1);

		for (int i = 0; i < 5; i++)
			list2.add(new Integer(i));
		Collections.shuffle(list2);
		System.out.println(list2);
		Mapenodekey key1=this.findkey(0,n);
		for (int i = 0; i < 5; i++) {
			listkey1.add(this.findkey(i,n));
		}
		//Mapenodekey key1=this.findkey(list2.get(0),n);
		for (int i = 0; i < 5; i++) {
		listkey1.add(this.findkey(list1.get(i),n));
		listkey2.add(this.findkey(list2.get(i),n));
		this.change(listkey1.get(i), listkey2.get(i));
		}
		
	}
/**
 * <p> Show {@code Mapenodekey} by the card  
 * @param key {@code Mapenodekey}
 * @return {@code string}
 */
	public String shownode(Mapenodekey key) {
		if(mapindesk.get(key)==null) {
			String s="NULL";
			return s;
		}
		else
			return mapindesk.get(key).toString();
	}
	/**
	 * <p> show {@code map} for example
	 * <p>
	 *  show the map comme dessous
	 * 	<P>*****************
	 *	<p>*	         *	   
	 *	<p>*	         *	      
	 * 
	 */
	public void showmap() {
		System.out.println("**********************************************************************************");
		System.out.println("**     "+shownode(findkey(0, 2))+"     **     "+shownode(findkey(1, 2))+"     **     "+shownode(findkey(2, 2))+
				"     **     "+shownode(findkey(3, 2))+"     **     "+shownode(findkey(4, 2))+"     **");
		System.out.println("**********************************************************************************");
		System.out.println("**     "+shownode(findkey(0, 1))+"     **     "+shownode(findkey(1, 1))+"     **     "+shownode(findkey(2, 1))+
				"     **     "+shownode(findkey(3, 1))+"     **     "+shownode(findkey(4,1))+"     **");
		System.out.println("**********************************************************************************");
		System.out.println("**     "+shownode(findkey(0, 0))+"     **     "+shownode(findkey(1, 0))+"     **     "+shownode(findkey(2, 0))+
				"     **     "+shownode(findkey(3, 0))+"     **     "+shownode(findkey(4, 0))+"     **");
		System.out.println("**********************************************************************************");

	}
	/**
	 * <p> Set {@code plycurrent} in this map, {@code plycurrent} represents who are modifying the {@code map} now
	 * @param player {@code Player}
	 */
	public void setplycurrent(Player player) {
		this.plycurrent=player;
	}
	/**
	 * <p> Get {@code plycurrent} in this map, {@code plycurrent} represents who are modifying the {@code map} now
	 * @return plycurrent {@code Player}
	 */
	public Player getplycurrent() {
		return this.plycurrent;
	}
	/**
	 * <p>Set the mode into {@code insert} or {@code move}
	 * @param mode {@code Mode}
	 */
	public void setmode(Mode mode){
		this.mode=mode;
	}
	/**
	 * <p>Get mode
	 * @return mode {@code Mode}
	 */
	public Mode getmode(){
		return this.mode;
	}
	/**
	 * <p>Store the Icon for the mode {@code move}
	 * @param icon {@code Icon}
	 */
	public void setIconForMove(Icon icon) {
		this.icon_move=icon;
	}
	/**
	 * <p>Get the Icon for the mode {@code move}
	 * @return icon {@code Icon}
	 */
	public Icon getIconForMove() {
		return this.icon_move;
	}
	/**
	 * <p>Store the {@code Card} for the mode {@code move}
	 * @param card
	 */
	public void setCardForMove(Card card) {
		this.card_move=card;
	}
	/**
	 * <p>get the {@code Card} for the mode {@code move}
	 * @return Card {@code card}}
	 */
	public Card getCardForMove() {
		return this.card_move;
	}
	public static void main(String[] args) {
		MapInDesk map = new MapInDesk();



		Card card =new Card(0,0,0);
		Card card0 =new Card(0,1,0);
		Card card2 =new Card(0,1,1);
		Card card3=new Card(0,0,0);
		Card card4 =new Card(0,1,0);
		Card card5 =new Card(0,1,1);
		Mapenodekey key0=new Mapenodekey(0,0);
		Mapenodekey key1=new Mapenodekey(0,1);
		Mapenodekey key2=new Mapenodekey(0,2);
		Mapenodekey key4=new Mapenodekey(1,0);
		Mapenodekey key5=new Mapenodekey(1,1);
		Mapenodekey key6=new Mapenodekey(1,2);
		Mapenodekey key7=new Mapenodekey(2,0);
		Mapenodekey key8=new Mapenodekey(2,1);
		Mapenodekey key9=new Mapenodekey(2,2);
		Mapenodekey key10=new Mapenodekey(3,0);
		Mapenodekey key11=new Mapenodekey(3,1);
		Mapenodekey key12=new Mapenodekey(3,2);
		Mapenodekey key13=new Mapenodekey(4,0);
		Mapenodekey key14=new Mapenodekey(4,1);
		Mapenodekey key15=new Mapenodekey(4,2);

		map.findkey(0,0).equals(key0);
		System.out.println(map.findkey(0,0).equals(key0));


		map.insertcard(key0, card);
		map.insertcard(key1, card0);
		map.insertcard(key2, card0);
		map.insertcard(key4, card0);
		map.insertcard(key5, card0);
		map.insertcard(key6, card0);
		map.insertcard(key7, card0);
		map.insertcard(key8, card0);
		map.insertcard(key9, card0);
		//		map.insertcard(key10, card0);
		//		map.insertcard(key11, card0);
		//		map.insertcard(key12, card0);
		//		map.insertcard(key13, card0);
		//		map.insertcard(key14, card0);
		//		map.insertcard(key15, card0);
		map.showmap();


		map.move(key1, key2);
		map.move(key7, key10);
		map.showmap();

		System.out.println(map.findcard(0, 0));
		System.out.println(map.isfull());

	}

}






















