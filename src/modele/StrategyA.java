package modele;
/**
 * <p>Specific strategy for virtual player implements interface {@link Strategy}
 * @author Wang Ziyan
 * @since 22 December 2020
 * @version 2.0
 */
public class StrategyA implements Strategy{
	/**
	 * <p>Insert card by random number  
	 * @param carinhand {@link Card}, card played by vplayer
	 * @param victoryCard {@link Card}, vcard of vplayer
	 * @param map {@link MapInDesk}
	 * @return  Mapenodekey
	 * 
	 */
	public Mapenodekey insertVirtuel(Card carinhand,Card victoryCard, MapInDesk map) {

		Mapenodekey key = null;
		boolean b = false;
		while(b == false) {
			int positionx = (int) Math.round(4*Math.random());
			int positiony = (int) Math.round(2*Math.random());

			if (map.getMapindesk().get(map.findkey(positionx,positiony)).getDisponible()>0 
					&&map.getMapindesk().get(map.findkey(positionx,positiony)).getcard()==null){
				key = map.findkey(positionx, positiony);
				b = true;
			}
		}


		return key;
	}
	/**
	 * <p>Move card by random number  
	 * @param carinhand {@link Card}, card played by vplayer
	 * @param victoryCard {@link Card}, vcard of vplayer
	 * @param map {@link MapInDesk}
	 * @return  Mapenodekey
	 * 
	 */
	public Mapenodekey[] moveVirtuel(Card victoryCard, MapInDesk map) {
		Mapenodekey key1 = null;
		Mapenodekey  key2 = null;
		double n = Math.random();
		if(n>=0.5) {
			boolean b = false;
			while(b == false) {
				int positionx = (int) Math.round(4*Math.random());
				int positiony = (int) Math.round(2*Math.random());
				if(map.getMapindesk().get(map.findkey(positionx,positiony)).getcard()!=null) {
					key1 = map.findkey(positionx, positiony);
					b = true;
				}
			}

			boolean c = false;
			while(c == false) {
				int positionc = (int) Math.round(4*Math.random());
				int positiond = (int) Math.round(2*Math.random());
				if (map.getMapindesk().get(map.findkey(positionc,positiond)).getDisponible()>0 
						&&map.getMapindesk().get(map.findkey(positionc,positiond)).getcard()==null
						&&map.findkey(positionc,positiond)!=key1) {
					key2 = map.findkey(positionc, positiond);
					c = true;

				}
			}
		}else {
			key1 = null;
			key2 = null;
		}
		Mapenodekey mapenodekey[] = new Mapenodekey[2];

		mapenodekey[0] = key1;
		mapenodekey[1] = key2;
		
		return mapenodekey;	
	}



}
