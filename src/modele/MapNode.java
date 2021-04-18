package modele;
/**
 *<p> The class {@code MapNode} contains {@code card} and {@code disponible} 
 * @author Wang Taojun
* @since 16 December 2020
 *@version 1.0
 */
public class MapNode {
	private Card card;
	private Integer disponible;
	/**
	 * <p>Creat a MapNode with {@code colour},{@code colour}.{@code colour}, and set {@code disponible}=0
	 * @param c {@code colour}
	 * @param f {@code colour}
	 * @param s {@code colour}
	 */
	public MapNode(Colour c, Filled f, Shape s) {
		this.card =new Card(c,f,s);
		this.disponible=0;
		
	}
	/**
	 *  <p>Creat a MapNode with {@code Card},and set {@code disponible}=0
	 * @param card {@code Card}
	 */
	public MapNode(Card card) {
		this.card =card;
		this.disponible=0;
	}
	/**
	 * <p>Creat a MapNode, set {@code card}=null and {@code disponible}=0
	 * @param card {@code Card}
	 */
	public MapNode() {
		this.card =null;
		this.disponible=0;
	}
	/**
	 * <p>Creat a MapNode with {@code colour},{@code colour}.{@code colour}, and set {@code disponible}=0
	 * @param c {@code colour}
	 * @param f {@code colour}
	 * @param s {@code colour}
	 */
	public MapNode(int c, int f, int s) {
		this.card =new Card(c,f,s);
		this.disponible=0;
	}
	/**
	 * <p>Creat a MapNode with {@code Card}, and {@code disponible}
	 * @param card 
	 * @param disponible
	 */
	public MapNode(Card card,Integer disponible) {
		this.card =card;
		this.disponible=disponible;
	}
	/**
	 * <p>Get card in this {@code mapnode}
	 * @return {@code Card}
	 */
	public Card getcard() {
		return this.card;
	}
	/**
	 * <p>Set card of this {@code mapnode}
	 * @param card {@code Card}
	 */
	public void setcard(Card card) {
		this.card=card;
	}
	/**
	 * <p>Get {@code disponible} of this Card
	 * @return {@code this.disponible}
	 */
	public Integer getDisponible() {
		return this.disponible;
	}
	/**
	 * <p>The champe disponible plus {@code i}
	 * @param {@code i}
	 */
	public void setDisponible(int i) {
		this.disponible=this.disponible+i;
	}
	/**
	 * <p>Show {@code Card} and {@code disponible}
	 * @return {@code String}
	 */
	public String toString(){
		StringBuffer buf=new StringBuffer();
		if(this.card==null) {
			buf.append("card=null");
			buf.append("disponible="+disponible);
			return buf.toString();
		}
	    //buf.append("\n");
		else{
			buf.append(card.toString());
			buf.append(" disponible="+disponible);
			return buf.toString();
		}
	}
	/**
	 * <p>Compare {@code Card} in the {@code Mapnode}
	 */
	public boolean equals(Object obj) {
		 if( obj == this ) 
			return true;
		 if( obj == null || !(obj instanceof MapNode))
			return false;
		
		 MapNode mapnode = (MapNode)obj; 			//conversation 
	     return this.card.equals(mapnode.card);
	}
	
	
	
	public static void main(String[] args) {
		 MapNode mapnode0 = new MapNode(0,0,0);
		 MapNode mapnode1 = new MapNode(0,0,0);
		 System.out.println(mapnode0.getcard());
		 System.out.println(mapnode0.equals(mapnode1));
		 System.out.println(mapnode0.getDisponible().toString());
	}
}
