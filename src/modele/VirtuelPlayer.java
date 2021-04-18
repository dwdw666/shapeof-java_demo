package modele;
import java.util.Scanner;
/**
 * <p>Virtual Player extends {@code Player}
 * @author Wang Taojun
 *
 */
public class VirtuelPlayer extends Player{
	private Strategy strategy;
	/**
	 * <p>Initialize the strategy of the virtual player
	 */
    public VirtuelPlayer() {
		super();
		this.strategy=new StrategyA();
	}

    /**
	 * <p>Change the strategy of the virtual player
	 * @param strategy0
	 */
	public void changeStrategy(Strategy strategy0) {
		this.strategy = strategy0;
		
	}
	/**
	 * <p>Decide what the virtual player should do based on his strategy
	 *
	 */
	public void decidePlay(MapInDesk map,Desk desk) {
		
		Mapenodekey decidedKey=
				this.strategy.insertVirtuel(this.getcardinhand(), this.getvictorycard(), map);
		Mapenodekey[] mapenodekey = this.strategy.moveVirtuel(this.getvictorycard(), map);
		Mapenodekey key1 = mapenodekey[0];
		Mapenodekey key2 = mapenodekey[1];
		System.out.println("virtuel player's play:");
		this.play(desk, decidedKey, this.getcardinhand());
		System.out.println("virtuel player's move:");
		if(key1!=null) {
			this.move(desk, key1, key2);
		}else {
			System.out.println("virtuel player don't move card");
		}
		
		
		
		
	}

}
