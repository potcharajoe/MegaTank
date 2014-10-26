package JoePotchara;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SuperBossMonster extends Monster {

	public SuperBossMonster(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/SuperBoss.png");
		monstersize = 120;
		monstertime = 1100;
		originaltime = 1100;
		collisionrange = 40;
		monsterHP = 20;
		standardHP = 20;
		monsterscore = 80;
	}
}
