package modele;
/**
 * <p>class Mapenodekey contiens les coordonnees de mapnode qui est key de Map
 * @author Wang Taojun
 * @version 1.0
 */
public class Mapenodekey {
	private int positionx;
	private int positiony;
	/**
	 *<p>Creat a {@code Mapnodekey} by position 
	 * @param x {@code int} 
	 * @param y {@code int}
	 */
	public Mapenodekey (int x,int y) {
		if(x<0 || x>4) 
			System.out.println("please entry the x in [0,4]");
	    if(y<0 || y>2)
	    	System.out.println("please entry the y in [0,2]");
	    if(x>=0 && x<=4 && y>=0 && y<=2) {
	    	positionx=x;
	    	positiony=y;
	    	
	    }
	}	
	/**
	 * <p>Get position x 
	 * @return {@code positionx}
	 */
	public int getx() {
		return positionx;
	}
	/**
	 * <p>Get position y
	 * @return {@code positiony}
	 */
	public int gety() {
		return positiony;
	}
	/**
	 * <p>Set position x 
	 * @param {@code positionx}
	 */
	public void setx(int x) {
		if(x<0 || x>4) 
			System.out.println("entry the x [0,4]");
		else
			positionx=x;
	}
	/**
	 * <p>Set position y 
	 * @param {@code positionx}
	 */
	public void sety(int y) {
		if(y<0 || y>2)
		    	System.out.println("entry the y [0,2]");
		else
			positionx=y;
	}
	
	/**
	 * <p>This method compares whether the positions are the same to determine whether the two nodes are the same
	 * @param {@code Object}
	 */
	public boolean equals(Object obj) {
		 if( obj == this ) 
			return true;
		 if( obj == null || !(obj instanceof Mapenodekey))
			return false;
		
		 Mapenodekey mapnodekey = (Mapenodekey)obj; 			//conversation 
	     return this.positionx==mapnodekey.positionx && this.positiony==mapnodekey.positiony;
	}
	/**
	 * <p>Show node location
	 */
	public String toString(){
		StringBuffer buf=new StringBuffer("mapnodekey=");
		buf.append("("+this.getx()+","+this.gety()+")");
		return buf.toString();
	}
	public static void main(String[] args) {
		 Mapenodekey m = new  Mapenodekey(0,0);
		 Mapenodekey n = new  Mapenodekey(0,0);
		 System.out.println("aa"+m.toString());
		 
	}
}
