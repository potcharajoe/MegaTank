package JoePotchara;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Heart extends Monster {

	public Heart(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/heart.png");
		monstersize = 56;
		monstertime = 800;
		originaltime = 800;
		collisionrange = 30;
		monsterHP = 2;
		standardHP = 2;
	}

	@Override
	public void update(int delta) {
		if (MegaTankGame.Isstart) {
			if (Math.abs((x + monstersize / 2) - MegaTankGame.GameWidth / 2) > 15
					&& Math.abs((y + monstersize / 2) - MegaTankGame.GameHeight
							/ 2) > 15) {
				x += dX / monstertime;
				y += dY / monstertime;
			}
			handleCollision();
			if (monsterHP == 0) {
				MegaTankGame.score += monsterscore;
				monsterHP = standardHP;
			}
			if (nearground(x, y)) {
				MegaTankGame.Playerhealth -= 0.05f;
			}
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
						monstertime = originaltime;
						if (MegaTankGame.RAN > 500) {
							Randomone();
						} else {
							Randomtwo();
						}
						dX = GetdX();
						dY = GetdY();
					}
				}
			}
			MegaTankGame.Playerhealth += 10;
			bullet.BulletReset();
		}
	}
}
