import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

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
	public static float Playerhealth = 100;
	private Image background;
	private float countwave = 0;
	private boolean Isgameover = false;
	private boolean Newwave = false;

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
		background = new Image("res/ground.png");
		background.draw(GameWidth / 2 - backgroundsize / 2, GameHeight / 2
				- backgroundsize / 2);
		for (Entity entity : entities) {
			entity.render(g);
		}

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		bullet = new Bullet(GameWidth / 2, GameHeight / 2);
		entities.add(bullet);
		tank = new Tank(GameWidth / 2, GameHeight / 2);
		entities.add(tank);
		for (int i = 0; i < 4; i++) {
			fatMonster = new FatMonster(500, 500);
			entities.add(fatMonster);
		}
		for (int j = 0; j < 10; j++) {
			noobMonster = new NoobMonster(200, 100);
			entities.add(noobMonster);
		}
		for (int k = 0; k < 2; k++) {
			bossMonster = new BossMonster(500, 500);
			entities.add(bossMonster);
		}
		for (int l = 0; l < 3; l++) {
			heart = new Heart(500, 500);
			entities.add(heart);
		}

	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		checkNewwave();
		System.out.println(countwave);
		 if (Newwave) {
		 container.reinit();
		 Newwave = false;
		// Playerhealth = 100;
		// Isgameover = false;
		 }
		if (Isgameover) {
			{
				// if(Isstart = true){
				// container.reinit();
				// Isgameover = false;
				// Isstart=false;}
			}
		} else {
			for (Entity entity : entities) {
				entity.update(delta);
			}
			Randomrange();
			checkHealth();
			countwave+=0.08f;
			TIME += 0.05f;
			System.out.println(Playerhealth);
		}

	}

	private void checkHealth() {
		if (Playerhealth >= 100) {
			Playerhealth = 100;
		}
		if (Playerhealth < 0) {
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
	public void checkNewwave(){
		if(countwave>20){
			countwave = 0;
			Newwave = true;
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
		// if (key == Input.KEY_Y) {
		// Isgameover = false;
		// Isstart = true;

		// }
	}

	// NUt
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (button == 0) {
			Ispress = true;
			Tank.thiszetar = Tank.getZetar();
			System.out.println("Click!!");
		}
	}
	// Nut

}
