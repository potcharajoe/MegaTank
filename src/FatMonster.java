import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FatMonster extends Monster {
	public FatMonster(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/fatmonster.png");
		monstersize = 85;
		monstertime = 600;
		collisionrange = 40;
		monsterHP = 4;

	}
}
