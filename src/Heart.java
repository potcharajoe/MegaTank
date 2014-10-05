import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Heart extends Monster {

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
			MegaTankGame.Playerhealth += 10;
			bullet.BulletReset();

		}
		;
	}
}
