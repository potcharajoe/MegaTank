package JoePotchara;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Bullet implements Entity {
	private static float ball_size = 24;
	private static Image bulletimage;
	public static float x;
	public static float y;

	public Bullet(float x, float y) throws SlickException {
		Bullet.x = x;
		Bullet.y = y;
		bulletimage = new Image("res/pokeball.png");
	}

	public float GetX() {
		return x + 12;
	}

	public float GetY() {
		return y - 12;
	}

	@Override
	public void render(Graphics g) {
		bulletimage.draw(x - ball_size / 2, y - ball_size / 2);
	}

	@Override
	public void update(int delta) {
		if (MegaTankGame.Ispress) {
			if (Mouse.getY() > 360) {
				x += 100 * (float) Math.cos(-Tank.thiszetar);
				y += 100 * (float) Math.sin(-Tank.thiszetar);
			} else {
				x += 100 * (float) Math.cos(Tank.thiszetar);
				y += 100 * (float) Math.sin(Tank.thiszetar);
			}
			if (x > 1024 || x < 0) {
				BulletReset();
			}
			if (y > 720 || y < 0) {
				BulletReset();
			}
		}
	}

	public void BulletReset() {
		MegaTankGame.Ispress = false;
		x = MegaTankGame.GameWidth / 2;
		y = MegaTankGame.GameHeight / 2;
	}
}
