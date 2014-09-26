import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class NoobMonster implements Entity {
	private float x, y;
	private Image noobmonster;
	private float noobmonstersize = 105;
	private float noobtime = 220;
	private float dX, dY;

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

		dX = MegaTankGame.GameWidth / 2 - noobmonstersize / 2 - x;
		dY = MegaTankGame.GameHeight / 2 - noobmonstersize / 2 - y;

		noobmonster = new Image("res/monster1.png");

	}

	@Override
	public void render(Graphics g) {
		noobmonster.draw(x, y);
	}

	@Override
	public void update(int delta) {
		if (Math.abs((x + noobmonstersize / 2) - MegaTankGame.GameWidth / 2) > 15
				&& Math.abs((y + noobmonstersize / 2) - MegaTankGame.GameHeight
						/ 2) > 15) {
			x += dX / noobtime;
			y += dY / noobtime;
		}
	}

	public boolean collision(float bulletX, float bulletY) {
		if (Math.abs((x + noobmonstersize / 2) - bulletX) < 60
				&& Math.abs((y + noobmonstersize / 2) - bulletY) < 60) {
			MegaTankGame.score += 1;
			return true;
		}
		return false;

	}

}
