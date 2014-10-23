package JoePotchara;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BossMonster extends Monster {

	public BossMonster(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/bossmonster.png");
		monstersize = 94;
		monstertime = 850;
		collisionrange = 40;
		monsterHP = 8;
		standardHP = 8;
		monsterscore = 40;
	}
}
