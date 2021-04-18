package Controle;

import vue.CommentjouerVue;
import vue.DeuxiemeChoisi;
import vue.MapVue;
import vue.MapVue3per;
import vue.MapVueV1;
import vue.MapVueV2;
import vue.QuitterVue;

public class ChoisiControleV {
	public String process(int message) {
		if(message==1) {
			MapVueV1.mapvuev1Main();
		}else if(message==2) {
			MapVueV2.mapvuev2Main();
		}	
		
		
		return ""+message;
	}

}
