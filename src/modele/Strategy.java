package modele;
/**
 * <p>Interface of Stratehy
 * @author Wang Ziyan
 * @since 22 December 2020
 * @version 1.0
 */
public interface Strategy {
	/**
	 * <p>insert a card into the map 
	 * @param carinhand
	 * @param victoryCard
	 * @param map
	 * @return Mapenodekey
	 */
	public Mapenodekey insertVirtuel(Card carinhand,Card victoryCard, MapInDesk map);
	/**
	 * <p>Move a card
	 * @param victoryCard
	 * @param map
	 * @return Mapenodekey
	 */ 
	public Mapenodekey[] moveVirtuel(Card victoryCard, MapInDesk map);
}
