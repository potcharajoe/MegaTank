package JoePotchara;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class NoobMonster extends Monster {

	public NoobMonster(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/monster1.png");
		monstersize = 105;
		monstertime = 320;
		originaltime = 320;
		collisionrange = 40;
		monsterHP = 1;
		standardHP = 1;
		monsterscore = 5;
		dead = new Sound("res/noobdead.wav");
	}
}
