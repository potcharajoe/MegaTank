import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Heart implements Entity {
	private float x, y;
	private Image heart;
	private float heartsize = 56;

	public Heart(float Mx, float My) throws SlickException {
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

		heart = new Image("res/heart.png");
	}

	@Override
	public void render(Graphics g) {
		heart.draw(x, y);
	}

	@Override
	public void update(int delta) {
		if (MegaTankGame.TIME > 18) {
			if (x > MegaTankGame.GameWidth / 2 - heartsize / 2) {
				if (y > MegaTankGame.GameHeight / 2 - heartsize / 2) {
					y -= 1;
					x -= 1;
				} else {
					y += 1;
					x -= 1;
				}
			} else {
				if (y > MegaTankGame.GameHeight / 2 - heartsize / 2) {
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
