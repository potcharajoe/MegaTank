import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class MegaTankGame extends BasicGame {

	private LinkedList<Entity> entities;
	public static float GameWidth = 1024;
	public static float GameHeight = 720;
	public static float monsterspawnX = 1400;
	public static float monsterspawnY = 850;
	private float backgroundsize = 400;
	public static float MAXX;
	public static float MINX;
	public static float RAN;
	public static float MAXY;
	public static float MINY;
	public static float TIME;
	static float score = 0;
	private Bullet bullet;
	private FatMonster fatMonster;
	private NoobMonster noobMonster;
	private BossMonster bossMonster;
	private Heart heart;
	private Tank tank;
	private SuperBossMonster superBoss;
	public static float Playerhealth = 100;
	private Image background;
	private boolean Isgameover = false;
	private float countwave = 0;
	private Sound shoot,lose;
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
		// if (Playerhealth == 0) {
		// g.drawString("YOU LOSE", GameWidth, GameHeight);
		// }

		background = new Image("res/ground.png");
		background.draw(GameWidth / 2 - backgroundsize / 2, GameHeight / 2
				- backgroundsize / 2);
		for (Entity entity : entities) {
			entity.render(g);
		}

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		shoot = new Sound("res/shot.wav");
		lose = new Sound("res/loose.wav");
		bullet = new Bullet(GameWidth / 2, GameHeight / 2);
		entities.add(bullet);
		tank = new Tank(GameWidth / 2, GameHeight / 2);
		entities.add(tank);
		for (int i = 0; i < 5; i++) {
			fatMonster = new FatMonster(500, 500);
			entities.add(fatMonster);
		}
		for (int p = 0; p < 2; p++) {
			superBoss = new SuperBossMonster(500, 500);
			entities.add(superBoss);
		}
		for (int j = 0; j < 10; j++) {
			noobMonster = new NoobMonster(200, 100);
			entities.add(noobMonster);
		}
		for (int k = 0; k < 4; k++) {
			bossMonster = new BossMonster(500, 500);
			entities.add(bossMonster);
		}
		for (int l = 0; l < 5; l++) {
			heart = new Heart(500, 500);
			entities.add(heart);
		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		// checkNewwave();
		// System.out.println(countwave);
		// if (Newwave) {
		// container.reinit();
		// Newwave = false;
		//
		// }
		if (Isgameover) {
			{
//				lose.play();
			}
		} else {
			for (Entity entity : entities) {
				entity.update(delta);
			}
			// map.play();
			Randomrange();
			checkHealth();
			countwave += 0.08f;
			TIME += 0.05f;
			System.out.println(Playerhealth);
		}

	}

	private void checkHealth() {
		if (Playerhealth >= 100) {
			Playerhealth = 100;
		}
		if (Playerhealth < 0) {
			lose.play();
			Playerhealth = 0;
			Isgameover = true;

		}

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

	// public void checkNewwave() {
	// if (countwave > 30) {
	// countwave = 0;
	// Newwave = true;
	// }
	//
	// }

	public void keyPressed(int key, char c) {
		if (key == Input.KEY_SPACE) {
			Ispress = true;
			Tank.thiszetar = Tank.getZetar();
			shoot.play();
			// isStarted = true;
			// dot.jump();
		}
		// if (key == Input.KEY_ENTER) {
		// Isstart = true;
		// }
	}

	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (button == 0) {
			Ispress = true;
			Tank.thiszetar = Tank.getZetar();
			shoot.play();
			System.out.println("Click!!");
		}
	}
	// Nut

}
