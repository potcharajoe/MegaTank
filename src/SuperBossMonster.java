import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SuperBossMonster extends Monster {

	public SuperBossMonster(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/SuperBoss.png");
		monstersize = 120;
		monstertime = 1000;
		collisionrange = 40;
		monsterHP = 20;
	}

}
