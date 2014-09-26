import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Input;

public class Tank implements Entity {
	private float x, y;
	private static float zetar;
	public static float thiszetar;
	public float Q_1 = (float) (-90 / 1.6);
	float Q_2 = (float) (-90 / 1.6);
	float Q_3 = (float) (90 / 1.6);
	float Q_4 = (float) (90 / 1.6);
	private String mouse_position = "Mouse Position X : " + Mouse.getX()
			+ "\nMouse Position Y : " + Mouse.getY();

	private Image tankimage;
	private float tanksize = 150;

	public Tank(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		tankimage = new Image("res/tank.png");

	}

	@Override
	public void render(Graphics g) {
		tankimage.draw(x - tanksize / 2, y - tanksize / 2);

		g.drawString(mouse_position, 800, 0);
		g.drawString("" + MegaTankGame.score, 400, 0);
		// g.drawString("" + getZetar(), 400, 0);

	}

	@Override
	public void update(int delta) {
		GetMouseLocation();
		Tankrotate(Mouse.getX(), Mouse.getY());
		Tankturn();

	}

	private void Tankturn() {
		if (getZetar() > 0 && getZetar() < 1.6) {
			if (Mouse.getY() > 360) {
				tankimage.setRotation(getZetar() * Q_1);
			} else {
				tankimage.setRotation(getZetar() * Q_4);
			}

		} else {
			if (Mouse.getY() > 360) {
				tankimage.setRotation(getZetar() * Q_2);
			} else {
				tankimage.setRotation(getZetar() * Q_3);

			}

		}

	}

	private void GetMouseLocation() {
		mouse_position = "Mouse Position X : " + Mouse.getX()
				+ "\nMouse Position Y : " + Mouse.getY();
	}

	private void Tankrotate(float Mx, float My) {

		zetar = ((float) Math.acos(((Mx - 512))
				/ Math.sqrt((Math.pow(Mx - 512, 2)) + (Math.pow(My - 360, 2)))));

	}

	public static float getZetar() {
		return zetar;
	}

}