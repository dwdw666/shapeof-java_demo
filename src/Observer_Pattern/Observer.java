package Observer_Pattern;
import modele.*;
public interface Observer {
   /**
    * insert card in map (x,y)
    * @param x
    * @param y
    * @param card
    */
   public void update(int x,int y,Card card);
   /**
    * remove card in map(x,y)
    * @param x
    * @param y
    */
   public void update(int x,int y);
   public void update(Object o);
   
}
