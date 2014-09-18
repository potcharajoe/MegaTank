import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class NoobMonster implements Entity {
	private float x, y;
	private Image noobmonster;
	private float noobmonstersize = 105;

	public NoobMonster(float Mx, float My) throws SlickException {
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

		noobmonster = new Image("res/monster1.png");

	}

	@Override
	public void render(Graphics g) {
		noobmonster.draw(x, y);
	}

	@Override
	public void update(int delta) {
		if (x > MegaTankGame.GameWidth / 2 - noobmonstersize / 2) {
			if (y > MegaTankGame.GameHeight / 2 - noobmonstersize / 2) {
				y -= 1;
				x -= 1;
			} else {
				y += 1;
				x -= 1;
			}
		} else {
			if (y > MegaTankGame.GameHeight / 2 - noobmonstersize / 2) {
				y -= 1;
				x += 1;
			} else {
				y += 1;
				x += 1;
			}
		}
	}

}
