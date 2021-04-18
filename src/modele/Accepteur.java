package modele;
/**
 * <p>Interface {@code Accepteur} for the Visitor mode
 * @author Wang Taojun
 *
 */
public interface Accepteur {
	/**
	 * <p> Abstract method for all the accepters
	 * @param Visitor 
	 */
	public void accepte(Visitor visitor);
	
}
