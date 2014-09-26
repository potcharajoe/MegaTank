import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FatMonster extends Monster {
	public FatMonster(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image ("res/fatmonster.png");
		monstersize = 85;
		monstertime = 500;
		collisionrange = 40 ;
		monsterHP=4;
	}
}


//	protected float x;
//	protected float y;
//	private float dX;
//	private float dY;
//	protected Image fatmonster;
//	protected float randomspawnX;
//	protected float randomspawnY;
//	protected float fatmonstersize = 85;
//	private float fattime = 500;
//
//	
//
//	public FatMonster(float Mx, float My) throws SlickException {
//		this.x = Mx;
//		this.y = My;
//		MegaTankGame.Randomrange();
//		if (MegaTankGame.RAN > 500) {
//			x = (float) (Math.random()
//					* (MegaTankGame.MAXX - MegaTankGame.MINX) + MegaTankGame.MINX);
//			y = (float) (Math.random() * (MegaTankGame.GameHeight));
//		} else {
//			x = (float) (Math.random() * (MegaTankGame.GameWidth));
//			y = (float) (Math.random()
//					* (MegaTankGame.MAXY - MegaTankGame.MINY) + MegaTankGame.MINY);
//		}
//		fatmonster = new Image("res/fatmonster.png");
//		dX = MegaTankGame.GameWidth / 2 - fatmonstersize / 2 - x;
//		dY = MegaTankGame.GameHeight / 2 - fatmonstersize / 2 - y;
//
//	}
//
//	@Override
//	public void render(Graphics g) {
//		fatmonster.draw(x, y);
//
//	}
//
//	@Override
//	public void update(int delta) {
//
//		if (MegaTankGame.TIME > 10) {
//
//			if (Math.abs((x + fatmonstersize / 2) - MegaTankGame.GameWidth / 2) > 30
//					&& Math.abs((y + fatmonstersize / 2)
//							- MegaTankGame.GameHeight / 2) > 30) {
//				x += dX / fattime;
//				y += dY / fattime;
//			}
//		}
//	}
//
//	public boolean collision(float bulletX, float bulletY) {
//		if (Math.abs((x + fatmonstersize / 2) - bulletX) < 40
//				&& Math.abs((y + fatmonstersize / 2) - bulletY) < 40) {
//			MegaTankGame.score += 1;
//			return true;
//		}
//		return false;
//
//	}
//
//}
