import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Heart extends Monster {
	private boolean ishitheart = false;

	public Heart(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/heart.png");
		monstersize = 56;
		monstertime = 750;
		collisionrange = 30;
		monsterHP = 2;
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

	@Override
	protected void handleCollision() {

		if (collision(bullet.GetX(), bullet.GetY())) {
			{
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

				}
				;
			}
			MegaTankGame.Playerhealth += 20;
			//System.out.println("COLLISIONHEART!!!!");
			bullet.BulletReset();

			// noobMonster.remove();
		}
		;
	}
}

// private float x, y;
// private Image heart;
// private float heartsize = 56;
// private float dX, dY;
// private float hearttime = 750;
//
// public Heart(float Mx, float My) throws SlickException {
// this.x = Mx;
// this.y = My;
// MegaTankGame.Randomrange();
// if (MegaTankGame.RAN > 500) {
// x = (float) (Math.random()
// * (MegaTankGame.MAXX - MegaTankGame.MINX) + MegaTankGame.MINX);
// y = (float) (Math.random() * (MegaTankGame.GameHeight));
// } else {
// x = (float) (Math.random() * (MegaTankGame.GameWidth));
// y = (float) (Math.random()
// * (MegaTankGame.MAXY - MegaTankGame.MINY) + MegaTankGame.MINY);
// }
// dX = MegaTankGame.GameWidth / 2 - heartsize / 2 - x;
// dY = MegaTankGame.GameHeight / 2 - heartsize / 2 - y;
//
// heart = new Image("res/heart.png");
// }
//
// @Override
// public void render(Graphics g) {
// heart.draw(x, y);
// }
//
// @Override
// public void update(int delta) {
// if (MegaTankGame.TIME > 18) {
//
// x += dX / hearttime;
// y += dY / hearttime;
//
// }
// }
//
// public boolean collision(float bulletX, float bulletY) {
// if (Math.abs((x + heartsize / 2) - bulletX) < 40
// && Math.abs((y + heartsize / 2) - bulletY) < 40) {
// MegaTankGame.score += 1;
// return true;
// }
// return false;
//
// }
//
// }
