import java.util.LinkedList;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class MegaTankGame extends BasicGame {

	private LinkedList<Entity> entities;
	public static float GameWidth = 1024;
	public static float GameHeight = 720;
	public static float monsterspawnX = 1400;
	public static float monsterspawnY = 850;
	public static float MAXX;
	public static float MINX;
	public static float RAN;
	public static float MAXY;
	public static float MINY;
	public static float TIME;

	static boolean Ispress = false;

	public MegaTankGame(String title) {
		super(title);
		entities = new LinkedList<>();
	}

	public static void main(String[] args) {
		try {
			MegaTankGame game = new MegaTankGame("MegaTank!!!");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(1024, 720, false);
			appgc.setMinimumLogicUpdateInterval(1400 / 60);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		for (Entity entity : entities) {
			entity.render(g);
		}

	}

	@Override
	public void init(GameContainer container) throws SlickException {

		entities.add(new Bullet(GameWidth / 2, GameHeight / 2));
		entities.add(new Tank(GameWidth / 2, GameHeight / 2));
		for (int x = 0; x < 9; x++) {
			entities.add(new FatMonster(500, 500));
		}
		for (int m = 0; m < 6; m++) {
			entities.add(new BossMonster(600, 800));
		}
		for (int k = 0; k < 10; k++) {
			entities.add(new NoobMonster(1200, 450));
		}
		for (int j = 0; j < 5; j++) {
			entities.add(new Heart(900, 620));
		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		for (Entity entity : entities) {
			entity.update(delta);
		}
		Randomrange();
		TIME += 0.03f;
		System.out.println(TIME);
		// System.out.println(RAN);
		// System.out.println(MAXX);
		// System.out.println(MINX);
		// System.out.println(Math.random() * (MAXX - MINX) + MINX);
		// y = (float) Math.random() * 121 + 180;

	}

	public static void Randomrange() {
		RAN = (float) (Math.random() * 1000);
		if (RAN > 500) {
			if (RAN > 750) {
				MAXX = 1300;
				MINX = 1150;
			} else {
				MAXX = -120;
				MINX = -300;
			}
		} else {
			if (RAN < 250) {
				MAXY = 1050;
				MINY = 800;
			} else {
				MAXY = -100;
				MINY = -350;
			}

		}

	}

	public void keyPressed(int key, char c) {
		if (key == Input.KEY_SPACE) {
			Ispress = true;
			Tank.thiszetar = Tank.getZetar();
			System.out.println("Press!!");
			// isStarted = true;
			// dot.jump();
		}
	}

}
