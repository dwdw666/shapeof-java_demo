
package modele;
/**
 * <p> the basic class card
 * 
 * 
 * 
 * @author Wang Taojun
 * @since 15 December 2020
 *@version 1.0
 */
public class Card {
	private Colour colour;   //type de enume de colour
	private Filled filled;   //type de enume de colour
	private Shape  shape;	 //type de enume de colour
	
	/**
	 * <p> creat a card with colour filled and shape
	 * @param c colour of card
	 * @param f filled of card
	 * @param s shape of card
	 * @version 1.0
	 */
	public Card(Colour c, Filled f, Shape s) {
		colour=c;
		filled=f;
		shape=s;
	}
	/**
	 * <p> creat a card with 
	 * @param c  0 represents Red, 1 represents Green, represents Blue
	 * @param f  0 represents Filled, 1 represents not Filled 
	 * @param s  0 represents CIRCLE , 1 represents RECTANGE, represents TRIANGLE
	 * @version 1.0
	 */
	public Card(Integer c, Integer f, Integer s) {  
		 switch (c){
         case 0:
             colour=Colour.RED;
             break;
         case 1:
        	 colour=Colour.GREEN;
        	 break;
         case 2:
        	 colour=Colour.BLUE;
        	 break;
         default:
             System.out.println("wrong colour");
             break;
         }
		 switch (f){
         case 0:
        	 filled=Filled.HOLLOW;
             break;
         case 1:
        	 filled=Filled.FILLED;
        	 break;
         default:
             System.out.println("wrong filled");
             break;
         }
		 switch (s){
         case 0:
        	 shape=Shape.CIRCLE;
             break;
         case 1:
        	 shape=Shape.RECTANGE;
        	 break;
         case 2:
        	 shape=Shape.TRIANGLE;
        	 break;
         default:
             System.out.println("wrong circle");
             break;
         }
	}
	/**
	 * <p> get colour of card
	 * @return colour of card
	 * @version 1.0
	 */
	public Colour getColour() {return colour;}
	/**
	 * <p> get filled of card
	 * @return  boolean filled
	 * @version 1.0
	 */
	public Filled getFilled() {return filled;}
	/**
	 * <p> get shape of card 
	 * @return shape of this card
	 */
	public Shape getShape() {return shape;}
	/**
	 * <P>set shape of card
	 * @param shape of card
	 */
	public void setShape(Shape s) {shape=s;}
	/**
	 * <P> set colour of card
	 * @param c colour
	 */
	public void setColour(Colour c) {colour=c;}
	/**
	 * <P> set filled of card
	 * @param boolean filled
	 */
	public void setFilled(Filled f) {filled=f;}
	/**
	 * <p>Show card information
	 * @param string 
	 */
	public String toString(){
		StringBuffer buf=new StringBuffer("Card");
		buf.append("("+this.colour+","+this.filled+","+this.shape+")");
		return buf.toString();
	}
	/**
	 * <p>equals item colour filled and shape 
	 * @param objet
	 */
	public boolean equals(Object obj) {
		 if( obj == this ) 
			return true;
		 if( obj == null || !(obj instanceof Card))
			return false;
		
		 Card card = (Card)obj; 			//conversation 
	     return this.colour==card.colour && this.filled==card.filled && this.shape==card.shape;
	}
	
	
	
	
	public static void main(String[] args) {
//		Colour c = Colour.RED;
//		Filled f = Filled.HOLLOW;
//		Shape s = Shape.CIRCLE;
//		Card card0 = new Card(c,f,s);
//		System.out.println(card0.toString());
//		System.out.println(card0.getColour());
//		
//		Card card1 = new Card(0,1,0);
//		System.out.println(card1.toString());
//		Card card2 = new Card(0,1,1);
//		System.out.println(card2.toString());
		
		System.out.println(new Card(2,1,2));
	}
	
}

enum Colour {
RED,GREEN,BLUE
}

enum Filled {
HOLLOW,FILLED
}

enum Shape {
CIRCLE,RECTANGE,TRIANGLE
}

