package JoePotchara;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class FatMonster extends Monster {
	public FatMonster(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/fatmonster.png");
		monstersize = 85;
		monstertime = 680;
		originaltime = 680;
		collisionrange = 40;
		monsterHP = 4;
		standardHP = 4;
		monsterscore = 20;
		dead = new Sound("res/fatdead.wav");
	}
}
