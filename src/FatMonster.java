import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FatMonster implements Entity {

	protected float x;
	protected float y;
	protected static Image fatmonster;
	protected float randomspawnX;
	protected float randomspawnY;
	protected float fatmonstersize = 90;

	public FatMonster(float Mx, float My) throws SlickException {
		this.x = Mx;
		this.y = My;
		fatmonster = new Image("res/fatmonster.png");
		
	}

	@Override
	public void render(Graphics g) {
		fatmonster.draw(x, y);

	}

	@Override
	public void update(int delta) {
		if (x > MegaTankGame.GameWidth / 2) {
			if (y > MegaTankGame.GameHeight / 2) {
				y -= 1;
				x -= 1;
			} else {
				y += 1;
				x -= 1;
			}
		} else {
			if (y > MegaTankGame.GameHeight / 2) {
				y -= 1;
				x += 1;
			} else {
				y += 1;
				x += 1;
			}
		}
	}

}
