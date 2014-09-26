import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Heart implements Entity {
	private float x, y;
	private Image heart;
	private float heartsize = 56;
	private float dX,dY;
	private float hearttime = 850; 

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
		dX = MegaTankGame.GameWidth / 2 - heartsize / 2 - x;
		dY = MegaTankGame.GameHeight / 2 - heartsize / 2 - y;

		heart = new Image("res/heart.png");
	}

	@Override
	public void render(Graphics g) {
		heart.draw(x, y);
	}

	@Override
	public void update(int delta) {
		if (MegaTankGame.TIME > 18) {
			
					x += dX / hearttime;
					y += dY / hearttime;
					
		}
	}
	public boolean collision(float bulletX, float bulletY) {
		if (Math.abs((x + heartsize / 2) - bulletX) < 40
				&& Math.abs((y + heartsize / 2) - bulletY) < 40) {
			MegaTankGame.score += 1;
			return true;
		}
		return false;

	}

}
