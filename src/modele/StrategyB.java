package modele;
/**
 * /**
 * <p>Specific strategy for virtual player implements interface {@link Strategy}
 * @author Wang Ziyan
 * @since 22 December 2020
 * @version 2.0
 *
 */
public class StrategyB implements Strategy{
	/**
	 * <p>Insert card of virtual player  
	 * @param carinhand {@link Card}, card played by vplayer
	 * @param victoryCard {@link Card}, vcard of vplayer
	 * @param map {@link MapInDesk}
	 * @return  Mapenodekey
	 * 
	 */
	public Mapenodekey insertVirtuel(Card cardinhand, Card victoryCard, MapInDesk map) {
		Mapenodekey key = null;
		Colour cv = victoryCard.getColour();
		Shape sv = victoryCard.getShape();
		Filled fv  = victoryCard.getFilled();
		Colour chand = cardinhand.getColour();
		Shape shand = cardinhand.getShape();
		Filled fhand  = cardinhand.getFilled();
		for(int j = 0;j<=2;j++) {
			for(int i=0;i<=4;i++) {
				if(map.getMapindesk().get(map.findkey(i,j)).getcard()!=null
						&&map.getMapindesk().get(map.findkey(i,j)).getcard().getColour() ==cv
						&&chand==cv){

					if(i+1<=4&&map.getMapindesk().get(map.findkey(i+1,j)).getcard()==null) {
						key = map.findkey(i+1,j);
						break;
					}else if(i-1>=0&&i-1<=4&&map.getMapindesk().get(map.findkey(i-1,j)).getcard()==null) {
						key = map.findkey(i-1,j);
						break;
					}else if(j+1<=2&&map.getMapindesk().get(map.findkey(i,j+1)).getcard()==null) {
						key = map.findkey(i,j+1);
						break;
					}else if(j-1>=0&&j-1<=2&&map.getMapindesk().get(map.findkey(i,j-1)).getcard()==null) {
						key = map.findkey(i,j-1);
						break;
					}

				}else if(map.getMapindesk().get(map.findkey(i,j)).getcard()!=null
						&&map.getMapindesk().get(map.findkey(i,j)).getcard().getFilled() ==fv
						&&fhand == fv){

					if(i+1<=4&&map.getMapindesk().get(map.findkey(i+1,j)).getcard()==null) {
						key = map.findkey(i+1,j);
						break;
					}else if(i-1>=0&&i-1<=4&&map.getMapindesk().get(map.findkey(i-1,j)).getcard()==null) {
						key = map.findkey(i-1,j);
						break;
					}else if(j+1<=2&&map.getMapindesk().get(map.findkey(i,j+1)).getcard()==null) {
						key = map.findkey(i,j+1);
						break;
					}else if(j-1>=0&&j-1<=2&&map.getMapindesk().get(map.findkey(i,j-1)).getcard()==null) {
						key = map.findkey(i,j-1);
						break;
					}
				}else if(map.getMapindesk().get(map.findkey(i,j)).getcard()!=null
						&&map.getMapindesk().get(map.findkey(i,j)).getcard().getShape() ==sv
						&&shand == sv){

					if(i+1<=4&&map.getMapindesk().get(map.findkey(i+1,j)).getcard()==null) {
						key = map.findkey(i+1,j);
						break;
					}else if(i-1>=0&&i-1<=4&&map.getMapindesk().get(map.findkey(i-1,j)).getcard()==null) {
						key = map.findkey(i-1,j);
						break;
					}else if(j+1<=2&&map.getMapindesk().get(map.findkey(i,j+1)).getcard()==null) {
						key = map.findkey(i,j+1);
						break;
					}else if(j-1>=0&&j-1<=2&&map.getMapindesk().get(map.findkey(i,j-1)).getcard()==null) {
						key = map.findkey(i,j-1);
						break;
					}

				}
			}
		}

		if(key==null) {
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
		}

		return key;	
	}
	/**
	 * <p>Move card of virtual player
	 * @param carinhand {@link Card}, card played by vplayer
	 * @param victoryCard {@link Card}, vcard of vplayer
	 * @param map {@link MapInDesk}
	 * @return  Mapenodekey
	 * 
	 */
	public Mapenodekey[] moveVirtuel(Card victoryCard, MapInDesk map) {
		Colour cv = victoryCard.getColour();
		Shape sv = victoryCard.getShape();
		Filled fv  = victoryCard.getFilled();
		Mapenodekey key1 = null;
		Mapenodekey key2 = null;

		for(int j = 0;j<=2;j++) {
			for(int i=0;i<=4;i++) {
				Card c = map.getMapindesk().get(map.findkey(i,j)).getcard();
				if(c!=null&&c.getColour() !=cv) {
					if((i+1<=4&&map.getMapindesk().get(map.findkey(i+1,j)).getcard()!= null
							&&c.getColour() ==map.getMapindesk().get(map.findkey(i+1,j)).getcard().getColour())
							||(i-1>=0&&map.getMapindesk().get(map.findkey(i-1,j)).getcard()!= null
							&&c.getColour() ==map.getMapindesk().get(map.findkey(i-1,j)).getcard().getColour())
							||(j+1<=2&&map.getMapindesk().get(map.findkey(i,j+1)).getcard()!= null
							&&c.getColour() ==map.getMapindesk().get(map.findkey(i,j+1)).getcard().getColour())
							||(j-1>=0&&map.getMapindesk().get(map.findkey(i,j-1)).getcard()!= null
							&&c.getColour() ==map.getMapindesk().get(map.findkey(i,j-1)).getcard().getColour())){
						key1 = map.findkey(i,j);
						break;
					}
				}else if(c!=null&&c.getShape()!=sv) {
					if((i+1<=4&&map.getMapindesk().get(map.findkey(i+1,j)).getcard()!= null
							&&c.getShape() ==map.getMapindesk().get(map.findkey(i+1,j)).getcard().getShape())
							||(i-1>=0&&map.getMapindesk().get(map.findkey(i-1,j)).getcard()!= null
							&&c.getShape() ==map.getMapindesk().get(map.findkey(i-1,j)).getcard().getShape())
							||(j+1<=2&&map.getMapindesk().get(map.findkey(i,j+1)).getcard()!= null
							&&c.getShape() ==map.getMapindesk().get(map.findkey(i,j+1)).getcard().getShape())
							||(j-1>=0&&map.getMapindesk().get(map.findkey(i,j-1)).getcard()!= null
							&&c.getShape() ==map.getMapindesk().get(map.findkey(i,j-1)).getcard().getShape())){
						key1 = map.findkey(i,j);
						break;
					}
				}else if(c!=null&&c.getFilled()!=fv) {
					if((i+1<=4&&map.getMapindesk().get(map.findkey(i+1,j)).getcard()!= null
							&&c.getFilled() ==map.getMapindesk().get(map.findkey(i+1,j)).getcard().getFilled())
							||(i-1>=0&&map.getMapindesk().get(map.findkey(i-1,j)).getcard()!= null
							&&c.getFilled() ==map.getMapindesk().get(map.findkey(i-1,j)).getcard().getFilled())
							||(j+1<=2&&map.getMapindesk().get(map.findkey(i,j+1)).getcard()!= null
							&&c.getFilled() ==map.getMapindesk().get(map.findkey(i,j+1)).getcard().getFilled())
							||(j-1>=0&&map.getMapindesk().get(map.findkey(i,j-1)).getcard()!= null
							&&c.getFilled() ==map.getMapindesk().get(map.findkey(i,j-1)).getcard().getFilled())){
						key1 = map.findkey(i,j);
						break;
					}
				}
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
		Mapenodekey mapenodekey[] = new Mapenodekey[2];
		mapenodekey[0] = key1;
		mapenodekey[1] = key2;
		
		return mapenodekey;
	}



}
