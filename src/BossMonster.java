import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BossMonster implements Entity {
	private float x, y;
	private Image bossmonster;
	private float bossmonstersize = 94;
	private float dY,dX;
	private float bosstime = 500;

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
		dX = MegaTankGame.GameWidth / 2 - bossmonstersize / 2 - x;
		dY = MegaTankGame.GameHeight / 2 - bossmonstersize / 2 - y;
		bossmonster = new Image("res/bossmonster.png");

	}

	@Override
	public void render(Graphics g) {
		bossmonster.draw(x, y);
	}

	@Override
	public void update(int delta) {
		
		if (MegaTankGame.TIME > 10) {
			
			if(Math.abs((x + bossmonstersize / 2) - MegaTankGame.GameWidth/2) > 30
					&& Math.abs((y + bossmonstersize / 2) - MegaTankGame.GameHeight/2) > 30){
					x += dX / bosstime;
					y += dY / bosstime;
					}
		}
	

	}
	public boolean collision(float bulletX, float bulletY) {
		if (Math.abs((x + bossmonstersize / 2) - bulletX) < 40
				&& Math.abs((y + bossmonstersize / 2) - bulletY) < 40) {
			MegaTankGame.score += 1;
			return true;
		}
		return false;

	}

}
