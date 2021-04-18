package modele;
import java.util.*;
/**
 * <p>The class {@code Playerlist} is used for store player
 * @author Wang Taojun
 *
 */
public class Playlist {
	private ArrayList<Player> playlist = new ArrayList<Player>();
	public Playlist() {
		
	}
	/**
	 * <p>Creat a new {@code Playerlist} with 2 {@code players}
	 * @param player1 {@link Player}
	 * @param player2 {@link Player}
	 */
	public Playlist(Player player1,Player player2) {
		playlist.add(player1);
		playlist.add(player2);
	}
	/**
	 * <p>Creat a new {@code Playerlist} with 3 {@code Player}
	 * @param player1 {@link Player}
	 * @param player2 {@link Player}
	 */
	public Playlist(Player player1,Player player2,Player player3) {
		playlist.add(player1);
		playlist.add(player2);
		playlist.add(player3);
	}
	/**
	 * <p>Add a {@code Player} to the {@code playerlist}
	 * @param player {@link Player}
	 */
	public void addplayer(Player player) {
		playlist.add(player);
	}
	/**
	 * <p>Get player by index {@code num}
	 * @param num {@code int}
	 * @return player {@link Player}
	 */
	public Player getplayer(int num) {
		return this.playlist.get(num);
	}
	/**
	 * <p>Show all pLayers in the list
	 */
	public void showallplayer() {
		Iterator<Player> ite =  playlist.iterator();
	    while(ite.hasNext()) {
	    	System.out.println("Player"+ite.next().getPlayerID());
	    }
	    System.out.println(playlist.size());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1 = new Player();
		Player player2=new Player();
		Playlist playerlist = new Playlist(player1,player2);
		playerlist.showallplayer();
		System.out.println(playerlist.getplayer(0));
		System.out.println(playerlist.getplayer(1));
	}

}
