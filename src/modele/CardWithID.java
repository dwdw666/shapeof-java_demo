package modele;
/**
 * <p>The {@link CardWithID} class is subclass of class {@link Card} and provide cardid
 * 
 * 
 * @author Wang Taojun
 * @since 15 December 2020
 * @version 1.0
 *       
 *
 */
public class CardWithID extends Card {
	private String cardid;
	/**
	 * <p>Creat a {@CardWithID} with (int colour, int filled,int shape). 
	 * 
	 * 
	 * 
	 * @param c  0 represents red, 1 represents green, represents blue
	 * @param f  0 represents Filled, 1 represents not Filled 
	 * @param s  0 represents CIRCLE , 1 represents RECTANGE, represents TRIANGLE
	 */
	public CardWithID(Integer c, Integer f, Integer s) {
		super(c, f, s);
		cardid=c.toString()+f.toString()+s.toString();
	} 
	public void setCardID(Card card) {
		
	}
	public static void main(String[] args) {
		CardWithID card = new CardWithID(0,1,0);
		System.out.print(card.cardid+card.toString());
		card.toString();
	}
}


