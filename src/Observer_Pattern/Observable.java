package Observer_Pattern;
import modele.*;
public class Observable {
	public final static int MAX_OBSERVEUR=10;
	
	private Observer[] observers;
	private int numberofobservers;
	private boolean hasChanged;
	
	public Observable() {
		observers = new Observer[MAX_OBSERVEUR];
		numberofobservers=0;
		hasChanged=false;
	}
	
	public void addObserver(Observer o) {
		if(numberofobservers < Observable.MAX_OBSERVEUR) {
			observers[numberofobservers] = o;
			numberofobservers++;
		} else {
			System.err.println("Error: max number of observers reached");
			
		}
	}
	public void deleteObserver(Observer o) {
		boolean foundObserver = false;
		for (int i = 0 ; i<numberofobservers;i++) {
			if(foundObserver==false) {
				if(observers[i].equals(o)) {
					observers[i] = null;
					foundObserver = true;
				}
			}
			else {
				observers[i-1] = observers[i];
			}
		}
		
		if (foundObserver == true) {
			numberofobservers--;
		}
	}
	/**
	 * notify mapvue insert card or remove card
	 * @param x 
	 * @param y
	 * @param sign if sign==1,insert if sign==0 remove
	 * @param card
	 */
	public void notifyObservers(int x,int y,Card card) {
		System.out.println("has changed "+this.hasChanged);//test
		if(hasChanged == true) {
			for(int i=0; i<numberofobservers;i++) {
				observers[i].update(x,y,card);
			}
			hasChanged=false;
		}
	}
	public void notifyObservers(int x,int y) {
		if(hasChanged == true) {
			for(int i=0; i<numberofobservers;i++) {
				observers[i].update(x,y);
			}
			hasChanged=false;
		}
	}
	/**
	 * 
	 * @param o
	 */
	public void notifyObservers(Object o) {
		if(hasChanged == true) {
			for(int i=0; i<numberofobservers;i++) {
				observers[i].update(o);
			}
			hasChanged=false;
		}
	}
	public void setChanged() {
		hasChanged = true;
	}
	public void clearChanged() {
		hasChanged = false;
	}
}
