package vue;
import javax.swing.*;
public class MapNodeVue extends JButton{

	private int positionx;
	private int positiony;
	
	public MapNodeVue(int x,int y) {
		Icon iconnull=new ImageIcon(this.getClass().getResource("/image/null.png")); //image null
		this.positionx=x;
		this.positiony=y;
		this.setIcon(iconnull);
	}
	
	public int getx() {
		return this.positionx;
	}
	public int gety() {
		return this.positiony;
	}
}
