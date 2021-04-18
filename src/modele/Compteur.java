package modele;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * <p> The class {@code Compteur} implements interface {@link Visitor} and we use this class to calculate the 
 * points of {@code Player}
 * @author Wang Taojun
 * @since 15 December 2020
 * @version 1.0
 *
 */
public class Compteur implements Visitor{
	private Card victorycard;
	private static Compteur instance;
	private Player playerVisited;
	private Desk deskVisited;

	public Compteur() {

	}
	/**
	 * <p>Get instance of the {@code Comtpeur}
	 * @return {@code instance}
	 */
	public static Compteur getInstance() {
		if(instance == null) {
			instance = new Compteur();
		}
		return instance;
	}
	/**
	 * <p>Implement abstract methods in visit interface
	 * @param o {@code Object}
	 */
	public void visit(Object o) {
		if(o instanceof Desk) {
			this.deskVisited = (Desk)o;
		}
		if(o instanceof Player) {
			this.playerVisited = (Player)o;
		}
	}
	/**
	 * <p> Calculate points in the {@code map} by {@code victorycard} of player.Calculate scores by row and by column
	 * @param desk {@code Desk}
	 * @param victorycard {@code victorycard}
	 * @return points {@code int}
	 */
	public int compte(Desk desk,Card victorycard) {
		return comptecollonneshape(desk,victorycard)+comptecollonnefilled(desk,victorycard)+comptecollonnecolor(desk,victorycard)
		+compteligneshape(desk,victorycard)+comptelignefilled(desk,victorycard)+comptelignecolor(desk,victorycard);
	}
	public  int comptecollonneshape(Desk desk,Card victorycard) {
		int point=0;
		Card[] card = new Card[5];
		LinkedList<Integer> sizelist =new LinkedList<Integer>();
		int size=0;
		int sign=0;
		//compte on collonne
		for(int i=0;i<=4;i++) {
			for(int j=0;j<=2;j++) {
				if(desk.map.findcard(i, j)!=null) {
					card[j]=desk.map.findcard(i, j);
				}
				else {//if this card==null we just calulate like firstcollonne
					break;
				}

			}
			for(int k=0;k<=2;k++) {
				if(victorycard.getShape()==card[k].getShape()) {
					if(sign==1) {
						size=size+1;

					}
					if(sign==0) {
						sign=1;
						size=size+1;
					}
				}
				else {
					if(sign==1) {
						sign=0;
						sizelist.addFirst(size);
						size=0;
					}
					if(sign==0) {
						// do notionh
					}
				}

				if(k==2) {
					if(sign==1) {
						sizelist.addFirst(size);
						sign=0;
					}
					sign=0;
					size=0;
				}

			}
			Iterator<Integer> ite = sizelist.iterator();
			while(ite.hasNext()) {
				switch(ite.next()){
				case 2:
					point=point+1;
					break;
				case 3:
					point=point+2;
					break;
				case 4:
					point=point+3;
					break;
				case 5:
					point=point+4;
				}

			}
			sizelist.clear();

		}
		return point;
	}
	/**
	 * <p>Calculate scores by column and filled
	 * @param desk {@code Desk}
	 * @param victorycard {@code Card} victorycard of player
	 * @return
	 */
	public  int comptecollonnefilled(Desk desk,Card victorycard) {
		int point=0;
		Card[] card = new Card[5];
		LinkedList<Integer> sizelist =new LinkedList<Integer>();
		int size=0;
		int sign=0;

		//compte on collonne
		for(int i=0;i<=4;i++) {
			for(int j=0;j<=2;j++) {
				if(desk.map.findcard(i, j)!=null) {
					card[j]=desk.map.findcard(i, j);
				}
				else {//if this card==null we just calulate like firstcollonne
					break;
				}

			}
			for(int k=0;k<=2;k++) {
				if(victorycard.getFilled()==card[k].getFilled()) {
					if(sign==1) {
						size=size+1;

					}
					if(sign==0) {
						sign=1;
						size=size+1;
					}
				}
				else {
					if(sign==1) {
						sign=0;
						sizelist.addFirst(size);
						size=0;
					}
					if(sign==0) {
						// do notionh
					}
				}

				if(k==2) {
					if(sign==1) {
						sizelist.addFirst(size);
						sign=0;
					}
					sign=0;
					size=0;
				}

			}
			Iterator<Integer> ite = sizelist.iterator();
			while(ite.hasNext()) {
				switch(ite.next()){
				case 3:
					point=point+3;
				}
			}
			sizelist.clear();

		}
		return point;
	} 
	/**
	 * <p>Calculate scores by column and colour of victoeycard
	 * @param desk {@code Desk}
	 * @param victorycard {@code Card} victorycard of player
	 * @return points
	 */
	public int comptecollonnecolor(Desk desk,Card victorycard) {
		int point=0;
		Card[] card = new Card[5];
		LinkedList<Integer> sizelist =new LinkedList<Integer>();
		int size=0;
		int sign=0;

		//compte on collonne
		for(int i=0;i<=4;i++) {
			for(int j=0;j<=2;j++) {
				if(desk.map.findcard(i, j)!=null) {
					card[j]=desk.map.findcard(i, j);
				}
				else {//if this card==null we just calulate like firstcollonne
					break;
				}

			}
			for(int k=0;k<=2;k++) {
				if(victorycard.getColour()==card[k].getColour()) {
					if(sign==1) {
						size=size+1;

					}
					if(sign==0) {
						sign=1;
						size=size+1;
					}
				}
				else {
					if(sign==1) {
						sign=0;
						sizelist.addFirst(size);
						size=0;
					}
					if(sign==0) {
						// do notionh
					}
				}

				if(k==2) {
					if(sign==1) {
						sizelist.addFirst(size);
						sign=0;
					}
					sign=0;
					size=0;
				}

			}
			Iterator<Integer> ite = sizelist.iterator();
			while(ite.hasNext()) {
				switch(ite.next()){
				case 3:
					point=point+4;
				}
			}
			sizelist.clear();

		}
		return point;
	}
	/**
	 * <p>Calculate scores by line and shape of victorycard
	 * @param desk {@code Desk}
	 * @param victorycard {@code Card} victorycard of player
	 * @return points {@code Int}
	 */
	public int compteligneshape(Desk desk,Card victorycard) {
		int point=0;
		Card[] card = new Card[5];
		LinkedList<Integer> sizelist =new LinkedList<Integer>();
		int size=0;
		int sign=0;
		//compte en ligne
		for(int j=0;j<=2;j++) {
			for(int i=0;i<=4;i++) {
				if(desk.map.findcard(i, j)!=null) {
					card[i]=desk.map.findcard(i, j);
				}
				else {//if this card==null we just calulate like firstligne
					break;
				}

			}
			for(int k=0;k<=4;k++) {
				if(victorycard.getShape()==card[k].getShape()) {
					if(sign==1) {
						size=size+1;

					}
					if(sign==0) {
						sign=1;
						size=size+1;
					}
				}
				else {
					if(sign==1) {
						sign=0;
						sizelist.addFirst(size);
						size=0;
					}
					if(sign==0) {
						// do notionh
					}
				}

				if(k==4) {
					if(sign==1) {
						sizelist.addFirst(size);
						sign=0;
					}
					sign=0;
					size=0;
				}

			}
			Iterator<Integer> ite = sizelist.iterator();
			while(ite.hasNext()) {
				switch(ite.next()){
				case 2:
					point=point+1;
					break;
				case 3:
					point=point+2;
					break;
				case 4:
					point=point+3;
					break;
				case 5:
					point=point+4;
				}

			}
			sizelist.clear();

		}
		return point;
	}
	/**
	 * <p>Calculate scores by ligne and filled
	 * @param desk {@code Desk}
	 * @param victorycard {@code Card} victorycard of player
	 * @return points
	 */
	public  int comptelignefilled(Desk desk,Card victorycard) {
		int point=0;
		Card[] card = new Card[5];
		LinkedList<Integer> sizelist =new LinkedList<Integer>();
		int size=0;
		int sign=0;

		//compte en ligne
		for(int j=0;j<=2;j++) {
			for(int i=0;i<=4;i++) {
				if(desk.map.findcard(i, j)!=null) {
					card[i]=desk.map.findcard(i, j);

				}
				else {//if this card==null we just calulate like firstligne
					break;
				}

			}
			for(int k=0;k<=4;k++) {
				if(victorycard.getFilled()==card[k].getFilled()) {
					if(sign==1) {
						size=size+1;
					}
					if(sign==0) {
						sign=1;
						size=size+1;
					}
				}
				else {
					if(sign==1) {
						sign=0;
						sizelist.addFirst(size);
						size=0;
					}
					if(sign==0) {
						// do notionh
					}
				}

				if(k==4) {
					if(sign==1) {
						sizelist.addFirst(size);
						sign=0;
					}
					sign=0;
					size=0;
				}

			}
			Iterator<Integer> ite = sizelist.iterator();
			while(ite.hasNext()) {
				switch(ite.next()){

				case 3:
					point=point+3;
					break;
				case 4:
					point=point+4;
					break;
				case 5:
					point=point+5;
				}

			}
			sizelist.clear();

		}
		return point;
	}
	/**
	 * <p>Calculate scores by ligne and colour
	 * @param desk {@code Desk}
	 * @param victorycard {@code Card} victorycard of player
	 * @return points
	 */
	public  int comptelignecolor(Desk desk,Card victorycard) {
		int point=0;
		Card[] card = new Card[5];
		LinkedList<Integer> sizelist =new LinkedList<Integer>();
		int size=0;
		int sign=0;

		//compte en ligne
		for(int j=0;j<=2;j++) {
			for(int i=0;i<=4;i++) {
				if(desk.map.findcard(i, j)!=null) {
					card[i]=desk.map.findcard(i, j);

				}
				else {//if this card==null we just calulate like firstligne
					break;
				}

			}
			for(int k=0;k<=4;k++) {
				if(victorycard.getColour()==card[k].getColour()) {
					if(sign==1) {
						size=size+1;

					}
					if(sign==0) {
						sign=1;
						size=size+1;
					}
				}
				else {
					if(sign==1) {
						sign=0;
						sizelist.addFirst(size);
						size=0;
					}
					if(sign==0) {
						// do notionh
					}
				}

				if(k==4) {
					if(sign==1) {
						sizelist.addFirst(size);
						sign=0;
					}
					sign=0;
					size=0;
				}

			}
			Iterator<Integer> ite = sizelist.iterator();
			while(ite.hasNext()) {
				switch(ite.next()){

				case 3:
					point=point+4;
					break;
				case 4:
					point=point+5;
					break;
				case 5:
					point=point+6;
				}

			}
			sizelist.clear();

		}
		return point;
	}
	//drow first card of the cardheap, and set cardinhand as desk




}
