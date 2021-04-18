package modele;
import java.util.*;
import java.util.Random;  
/**
 * <p>card heap which stores {@link Card} and provide methodes of wash cardheap
 * 
 * @since  15 December 2020
 * @author Wang Taojun
 * @version 1.0
 *
 */
public class CardHeap {
	private LinkedList<Card> cardlist = new LinkedList<Card>();
	/**
	 * <p> The construction method of {@link CardHeap} 
	 */
	public CardHeap() {
	    for(int i=0;i<3;i++) {
			cardlist.add(new Card(i,0,0));
			cardlist.add(new Card(i,0,1));
			cardlist.add(new Card(i,0,2));
			cardlist.add(new Card(i,1,0));
			cardlist.add(new Card(i,1,1));
			cardlist.add(new Card(i,1,2));
		}
	    System.out.println("creer une nouvelle cardheap qui comportes"+cardlist.size()+"cartes");
//	    System.out.println("get 1er carte"+cardlist.get(0));
	}
	/**
	 * <p> change order of cards in this {@linkp cardheap}} 
	 */
	public void washHeap() {
		 LinkedList<Card> cardlistcopy = new LinkedList<Card>();
		 Random random = new Random();
		 while(cardlist.size()!=0) {
			 int currentsize = cardlist.size();//initial a 18
			 double r = random.nextInt(10);
			 int currentnum = (int)Math.floor( r*currentsize/10);
			 cardlistcopy.addFirst(cardlist.get(currentnum));
			 cardlist.remove(currentnum);
		 }
		 cardlist=cardlistcopy;
	}   
	/**
	 * <p>Delete the card with compound conditions (colour,filled,shape) in the library
	 * @param c colour 
	 * @param f filled
	 * @param s shape
	 * @version 1.0
	 */
	public void removeOneCard(int c, int f, int s) {
		Card cardtraget = new Card(c,f,s);
		int length=cardlist.size(); //stocker length d'originale
		Iterator<Card> ite1 =  cardlist.iterator();
	    while(ite1.hasNext()) {
	    	if(ite1.next().equals(cardtraget))
	    	  ite1.remove();
	    }
	    System.out.println("cardlist.size()="+cardlist.size());
		
	    if(cardlist.size()<length) {
			System.out.println("this card has been deleted");
			System.out.println("cardlist.size()="+cardlist.size());
		}
		else if(cardlist.size()==length) 
			System.out.print("this card not exsist");
	}
 /**
  * <p>Return the top card in the {@link CardHeap} and remove it
  * @return Card
  */
	public Card gettopcard() {
		return cardlist.remove() ;
	}
	
	/**
	 *<p> Display all the cards in the cardheap
	 */
	public void showCardHeap() {
		Iterator<Card> iter2 = cardlist.iterator();
		while (iter2.hasNext()) {
			System.out.println(iter2.next().toString());
		}
	}
	
	//test mode
	public static void main(String[] args) {
		 CardHeap cardheap = new CardHeap();
		 cardheap.removeOneCard(20, 20, 20);
		 cardheap.showCardHeap();
		 cardheap.washHeap();
		 System.out.println("***************************");
		 cardheap.showCardHeap();
		 cardheap.gettopcard();
		 System.out.println("***************************");
		 cardheap.showCardHeap();
	}
}
