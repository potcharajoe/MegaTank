import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BossMonster implements Entity {
	private float x, y;
	private Image bossmonster;

	public BossMonster(float Mx, float My) throws SlickException {
		this.x = Mx;
		this.y = My;
		bossmonster = new Image("res/bossmonster.png");

	}

	@Override
	public void render(Graphics g) {
		bossmonster.draw(x, y);
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
