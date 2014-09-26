import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Monster implements Entity {

	protected float x, y, dX, dY, monstersize, monstertime, monsterHP;
	protected Image monsterimage;
	protected float collisionrange;

	protected float groundsize = 200;

	protected Bullet bullet = new Bullet(MegaTankGame.GameWidth / 2,
			MegaTankGame.GameHeight / 2);

	public Monster(float Mx, float My) throws SlickException {
		this.x = Mx;
		this.y = My;
		MegaTankGame.Randomrange();
		if (MegaTankGame.RAN > 500) {
			Randomone();
		} else {
			Randomtwo();
		}
		dX = MegaTankGame.GameWidth / 2 - monstersize / 2 - x;
		dY = MegaTankGame.GameHeight / 2 - monstersize / 2 - y;

	}

	protected void Randomtwo() {
		x = (float) (Math.random() * (MegaTankGame.GameWidth));
		y = (float) (Math.random() * (MegaTankGame.MAXY - MegaTankGame.MINY) + MegaTankGame.MINY);
	}

	protected void Randomone() {
		x = (float) (Math.random() * (MegaTankGame.MAXX - MegaTankGame.MINX) + MegaTankGame.MINX);
		y = (float) (Math.random() * (MegaTankGame.GameHeight));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(monsterimage, x, y);

	}

	@Override
	public void update(int delta) {
		if (Math.abs((x + monstersize / 2) - MegaTankGame.GameWidth / 2) > 15
				&& Math.abs((y + monstersize / 2) - MegaTankGame.GameHeight / 2) > 15) {
			x += dX / monstertime;
			y += dY / monstertime;
		}
		handleCollision();

		if (nearground(x, y)) {
			MegaTankGame.Playerhealth -= 0.05f;
		}

	}

	protected void handleCollision() {

		if (collision(bullet.GetX(), bullet.GetY())) {
			monsterHP -= 1;
			{
				if (monsterHP == 0) {
					MegaTankGame.Randomrange();
					if (MegaTankGame.RAN > 500) {
						Randomone();
					} else {
						Randomtwo();
					}
				}
				System.out.println("COLLISION!!!!");
				bullet.BulletReset();

				// noobMonster.remove();
			}
			;
		}
	}

	public boolean collision(float bulletX, float bulletY) {
		if (Math.abs((x + monstersize / 2) - bulletX) < collisionrange
				&& Math.abs((y + monstersize / 2) - bulletY) < collisionrange) {
			MegaTankGame.score += 1;
			return true;
		}
		return false;

	}

	public boolean nearground(float x, float y) {
		if (Math.abs((MegaTankGame.GameWidth / 2) - x) < groundsize
				&& Math.abs((MegaTankGame.GameHeight / 2) - y) < groundsize) {
			monstertime = 4000;
			return true;
		}
		return false;

	}
}
