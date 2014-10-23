package JoePotchara;

import java.awt.Container;
import java.util.Deque;
import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
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
	public static float score = 0;
	private float gameoversize = 300;
	private float NOOBsize = 200;
	private Bullet bullet;
	private FatMonster fatMonster;
	private NoobMonster noobMonster;
	private BossMonster bossMonster;
	private Heart heart;
	private Tank tank;
	private SuperBossMonster superBoss;
	public static float Playerhealth = 100;
	private Image background, pikachu, logo, gameover, noobbg;
	public static boolean Isgameover = false;
	private Sound shoot, lose;
	static boolean Ispress = false;
	private boolean Howtoplay = true;
	public static boolean Isstart = false;
	private float pikachusize = 120;
	private float logowidth = 833;
	public float Highscore = 0;

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
		if (!Isstart && Howtoplay) {
			MainMenuState(g);
		} else if (!Isstart && !Howtoplay) {
			HowtoPlayState(g);

		} else if (!Isgameover && Isstart) {
			PlaySceneState(g);
		} else if (Isgameover) {
			GameOverState(g);
		}
	}

	private void PlaySceneState(Graphics g) throws SlickException {
		background = new Image("res/ground.png");
		background.draw(GameWidth / 2 - backgroundsize / 2, GameHeight / 2
				- backgroundsize / 2);
		g.drawString("PlayerHP : " + (int) MegaTankGame.Playerhealth, 800, 10);
		g.drawString("SCORE : " + (int) MegaTankGame.score, 500, 10);
		g.drawString("TIME : " + (int) MegaTankGame.TIME, 200, 10);
		for (Entity entity : entities) {
			entity.render(g);
		}
	}

	private void GameOverState(Graphics g) throws SlickException {
		pikachu = new Image("res/SuperBoss.png");
		pikachu.draw(GameWidth / 2 - 200, GameHeight / 2 - pikachusize / 2);
		gameover = new Image("res/Gameover.png");
		gameover.draw(GameWidth / 2 - gameoversize / 2, GameHeight / 2 - 200);
		noobbg = new Image("res/NOOB.png");
		noobbg.draw(GameWidth / 2 - 250, GameHeight / 2 + 40);
		g.drawString("YOU LOSE!!!", GameWidth / 2, (GameHeight / 2) - 40);
		g.drawString("SCORE : " + (int) score, GameWidth / 2,
				(GameHeight / 2) + 30);
		g.drawString("SURVIVAL TIME : " + (int) TIME, GameWidth / 2,
				(GameHeight / 2) + 100);
	}

	private void MainMenuState(Graphics g) throws SlickException {
		logo = new Image("res/MegaTank.png");
		logo.draw(GameWidth / 2 - logowidth / 2, 150);
		g.drawString("PRESS BUTTON", GameWidth / 2 - 80, GameHeight / 2);
		g.drawString("1)  START", GameWidth / 2 - 80, GameHeight / 2 + 80);
		g.drawString("2)  HOW TO PLAY", GameWidth / 2 - 80,
				GameHeight / 2 + 140);
	}

	private void HowtoPlayState(Graphics g) {
		g.drawString("<--HOW TO PLAY-->", GameWidth / 2 - 60,
				GameHeight / 2 - 200);
		g.drawString("1. MOVE YOUR MOUSE TO ROTATE MEGATANK",
				GameWidth / 2 - 150, GameHeight / 2 - 80);
		g.drawString("2. PRESS LEFT CLICK OR SPACEBAR TO SHOOT",
				GameWidth / 2 - 150, GameHeight / 2);
		g.drawString("PRESS 'B' TO GO TO MAIN MENU", GameWidth / 2 - 120,
				GameHeight / 2 + 100);
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
		for (int j = 0; j < 8; j++) {
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

		for (Entity entity : entities) {
			entity.update(delta);
		}
		Randomrange();
		checkHealth();
		if (Isstart && !Isgameover) {
			TIME += 0.05f;
		}
	}

	private void checkHealth() {
		if (Playerhealth >= 100) {
			Playerhealth = 100;
		}
		if ((Playerhealth < 0) && !Isgameover) {
			lose.play();
			Playerhealth = 0;
			Isgameover = true;
		}
	}

	public static void Randomrange() {
		RAN = (float) (Math.random() * 1000);
		if (RAN > 500) {
			if (RAN > 750) {
				SpawnRight();
			} else {
				SpawnLeft();
			}
		} else {
			if (RAN < 250) {
				SpawnDown();
			} else {
				SpawnUp();
			}
		}
	}

	private static void SpawnUp() {
		MAXY = -100;
		MINY = -350;
	}

	private static void SpawnDown() {
		MAXY = 1050;
		MINY = 800;
	}

	private static void SpawnLeft() {
		MAXX = -120;
		MINX = -300;
	}

	private static void SpawnRight() {
		MAXX = 1300;
		MINX = 1150;
	}

	public void keyPressed(int key, char c) {
		if (key == Input.KEY_SPACE) {
			Ispress = true;
			Tank.thiszetar = Tank.getZetar();
			shoot.play();
		}
		if (key == Input.KEY_1) {
			Isgameover = false;
			Isstart = true;
			Playerhealth = 100;
		}
		if (key == Input.KEY_2) {
			Howtoplay = false;
		}
		if (key == Input.KEY_B) {
			Howtoplay = true;
		}
	}

	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (button == 0) {
			Ispress = true;
			Tank.thiszetar = Tank.getZetar();
			shoot.play();
		}
	}
}
