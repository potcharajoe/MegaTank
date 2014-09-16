import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Heart implements Entity {
	private float x, y;
	private Image heart;

	public Heart(float Mx, float My) throws SlickException {
		this.x = Mx;
		this.y = My;
		heart = new Image("res/heart.png");
	}

	@Override
	public void render(Graphics g) {
		heart.draw(x, y);
	}

	@Override
	public void update(int delta) {
		if (x > MegaTankGame.GameWidth / 2) {
			if (y > MegaTankGame.GameHeight / 2) {
				y -= 1;
				x -= 1;
			} else {
				y += 1;
				x -= 1;
			}
		} else {
			if (y > MegaTankGame.GameHeight / 2) {
				y -= 1;
				x += 1;
			} else {
				y += 1;
				x += 1;
			}
		}
	}

}
