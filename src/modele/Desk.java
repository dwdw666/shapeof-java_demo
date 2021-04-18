package modele;

import Observer_Pattern.Observable;

/**
 * <p>The class  implements the interface {@link Accepteur} contains a {@link MapInDesk} and a {@link cardheap}
 * @author Wang Taojun
 *
 */
public class Desk implements Accepteur{
	public MapInDesk map;
	public CardHeap cardheap; 
	/**
	 * <p>Creat a {@code desk} by {@code map} and {@code cardheap}
	 * @param map {@code MapInDesk}
	 * @param cardheap {@code CardHeap}
	 */
	public Desk(MapInDesk map,CardHeap cardheap) {
		this.map=map;
		this.cardheap=cardheap;
	}
	/**
	 * <p>Creat a new {@code desk} 
	 */
	public Desk() {
		map = new MapInDesk();
		cardheap = new CardHeap();
	}
	/**
	 * <p>Get the {@code map} in the {@code desk}
	 * @return {@code this.map}
	 */
	public MapInDesk getmap() {
		return map;
	}
	/**
	 * <p>Get the {@code cardheap} in the {@code desk}
	 * @return {@code this.cardheap} 
	 */
	public CardHeap getcardheap() {
		return cardheap;
	}
	/**
	 * <p>Implement the abstract method of the interface {@code Accepteur}
	 *
	 */
	public void accepte(Visitor visitor) {
		Visitor.visit(this);
	}
	
}
