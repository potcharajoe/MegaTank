import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FatMonster implements Entity {

	protected float x;
	protected float y;
	protected static Image fatmonster;
	protected float randomspawnX;
	protected float randomspawnY;
	protected float fatmonstersize = 85;

	// private float zetar;

	public FatMonster(float Mx, float My) throws SlickException {
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
		fatmonster = new Image("res/fatmonster.png");

	}

	@Override
	public void render(Graphics g) {
		fatmonster.draw(x, y);

	}

	// private void MonsterMove(float Mx, float My) {
	//
	// zetar=((float) Math.acos(((Mx - 512))
	// / Math.sqrt((Math.pow(Mx - 512, 2)) + (Math.pow(My - 360, 2)))));
	//
	// }

	@Override
	public void update(int delta) {
		if (MegaTankGame.TIME > 10) {
			if (x > MegaTankGame.GameWidth / 2 - fatmonstersize / 2) {
				if (y > MegaTankGame.GameHeight / 2 - fatmonstersize / 2) {
					x -= 1;
					y -= 1;
				} else {
					y += 1;
					x -= 1;
				}
			} else {
				if (y > MegaTankGame.GameHeight / 2 - fatmonstersize / 2) {
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
