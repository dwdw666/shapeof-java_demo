package Controle;

import modele.SysGraph2Per;
import vue.CommentjouerVue;
import vue.DeuxiemeChoisi;
import vue.QuitterVue;
import vue.MapVue;
import vue.MapVue3per;

public class ChoisiControle {
	private SysGraph2Per sys2per;


	public ChoisiControle() {

	}




	public String process(int message) {
		if(message==1) {
			MapVue.mapvue();
		}else if(message==2) {
			MapVue3per.mapvue3per();
		}else if(message==3) {
			DeuxiemeChoisi.deuxiemeChoisi();
		}else if(message==4) {
			CommentjouerVue.commentjouerVue();
		}else if(message==5) {
			QuitterVue.quitter();
		}

		return ""+message;
	}




}
