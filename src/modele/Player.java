package modele;
import java.util.*;
/**
 * <p>The class {@code Player} implements interface {@code Accepteur} has a {@code victorycard} and {@code PlayerId} whitch is uesd to
 * idientitfy every player.
 * @author Wang Taojun
 * @since 18 December 2020
 * @version 1.0
 */
public class Player implements Accepteur {
	private Card victorycard;
	private Card cardinhand;
	private int PlayerID = numberofplayer;  //every player has different playerid
	private static int numberofplayer=1;  
	private ArrayList<Card> listofcard_played;
	/**
	 * <p> Creat a {@code player} 
	 */
	public Player() {
		victorycard = null;
		cardinhand = null;
		numberofplayer++;
		listofcard_played=new ArrayList<Card>();
	}
	/**
	 * <p>Implement the abstract method of the interface {@link Accepteur}
	 */
	public void accepte(Visitor visitor) {
		Visitor.visit(this);
	}
	/**
	 * <p>Get {@code PlayerID}
	 * @return {@code this.PlayerID}
	 */
	public int getPlayerID() {
		return PlayerID;
	}
	/**
	 * <p>Get {@code Vcard}
	 * @return {@code this.victorycard}
	 */
	public Card getvictorycard() {
		return victorycard;
	}
	/**
	 * <p>Set victoryCard
	 * @param vcard {@code Card}
	 */
	public void setvictorycard(Card vcard) {
		victorycard=vcard;
	}
	/**
	 * <p>Get {@code Cardinhand}
	 * @return {@code this.cardinhand}
	 */
	public Card getcardinhand() {
		return cardinhand;
	}
	/**
	 * <p>Set {@code cardinhande}
	 * @param vcard {@code cardinhande}
	 */
	public void setcardinhand(Card cardihand) {
		victorycard=cardihand;
	}
    /**
     * <p>Drow {@code Card} in the desk. get the card in the top of {@code desk.cardheap}
     * @param desk {@link Desk}
     */
	public void drow(Desk desk) {
		cardinhand = desk.cardheap.gettopcard();
	}
	/**
	 * <p> Insert {@code this.cardinhand} to the desk
	 * @param desk {@link Desk}
	 * @param key {@link Mapenodekey}
	 * @param card {@link Card}
	 * @return {@code successful} if insert successfully, {@code fails} if insert unsuccessfully
	 */
	public returnetat play(Desk desk,Mapenodekey key,Card card ) {
		returnetat rt = desk.map.insertcard(key, card);
		listofcard_played.add(this.getcardinhand()); //record every card has been played by player1
		return rt;
	} 
	/**
	 *  <p> Insert {@code this.cardinhand} to the desk
	 * @param desk {@link Desk}
	 * @param x {@code int}
	 * @param y {@code int}
	 * @return {@code successful} if insert successfully, {@code fails} if insert unsuccessfully
	 */
	public returnetat play(Desk desk,int x,int y) {
		 Mapenodekey key=desk.map.findkey(x, y);
		 returnetat rt=desk.map.insertcard(key, this.getcardinhand());
		 listofcard_played.add(getcardinhand()); //record every card has been played by player1
		 return rt;
	} 
	/**
	 * <p>Move {@code Card} from {@code key1} to {@code key2}
	 * @param desk {@link Desk}
	 * @param key1 {@link Mapenodekey}
	 * @param key2 {@link Mapenodekey}
	 * @return  {@code successful} if insert successfully, {@code fails} if insert unsuccessfully
	 */
	public returnetat move(Desk desk,Mapenodekey key1,Mapenodekey key2 ) {
		returnetat rt=desk.map.move(key1,key2);
		return rt;
	}
	/**
	 * <p>Show {@code Playerlist]
	 */
	public void showlistcard_played() {
		Iterator<Card> ite = listofcard_played.iterator();
		System.out.println("******ALL Cards Played By player"+this.PlayerID+"******");
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.println("********************************************************");
	}
	public boolean equals(Object obj) {
		 if( obj == this ) 
				return true;
			 if( obj == null || !(obj instanceof Player))
				return false;
	     Player player = (Player)obj; 	
	     return this.getPlayerID()==player.getPlayerID();
	}
	public String toString(){
		StringBuffer buf=new StringBuffer("Player");
		buf.append("("+"PlayerID="+this.PlayerID+","+"v"+this.victorycard+")");
		return buf.toString();
	}
	
	
	public static void main(String[] args) {
		Player player1 = new Player();
		Player player2=new Player();
		System.out.println("ID  "+player1.getPlayerID());
		System.out.println("ID  "+player2.getPlayerID());
		System.out.println(player1.equals(player2));
		System.out.println(player1.toString());
	}
	
}
