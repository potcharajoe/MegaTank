import java.util.LinkedList;

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
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		for (Entity entity : entities) {
			entity.update(delta);
		}

	}

	public void keyPressed(int key, char c) {
		if (key == Input.KEY_SPACE) {
			Ispress = true;
			Tank.thiszetar=Tank.getZetar();
			System.out.println("Press!!");
			// isStarted = true;
			// dot.jump();
		}
	}

}
