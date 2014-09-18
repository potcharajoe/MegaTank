import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BossMonster implements Entity {
	private float x, y;
	private Image bossmonster;
	private float bosssize = 94;

	public BossMonster(float Mx, float My) throws SlickException {
		this.x = Mx;
		this.y = My;
		MegaTankGame.Randomrange();
		if (MegaTankGame.RAN > 500) {
			x = (float) (Math.random()
					* (MegaTankGame.MAXX - MegaTankGame.MINX) + MegaTankGame.MINX);
			y = (float) (Math.random() * (MegaTankGame.GameHeight));
		} else {
			x = (float) (Math.random() * (MegaTankGame.GameWidth));
			y = (float) (Math.random()
					* (MegaTankGame.MAXY - MegaTankGame.MINY) + MegaTankGame.MINY);
		}

		bossmonster = new Image("res/bossmonster.png");

	}

	@Override
	public void render(Graphics g) {
		bossmonster.draw(x, y);
	}

	@Override
	public void update(int delta) {
		if (MegaTankGame.TIME > 25) {
			if (x > MegaTankGame.GameWidth / 2 - bosssize / 2) {
				if (y > MegaTankGame.GameHeight / 2 - bosssize / 2) {
					y -= 1;
					x -= 1;
				} else {
					y += 1;
					x -= 1;
				}
			} else {
				if (y > MegaTankGame.GameHeight / 2 - bosssize / 2) {
					y -= 1;
					x += 1;
				} else {
					y += 1;
					x += 1;
				}
			}
		}
	}

}
