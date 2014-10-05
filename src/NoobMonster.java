import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class NoobMonster extends Monster {

	public NoobMonster(float Mx, float My) throws SlickException {
		super(Mx, My);
		monsterimage = new Image("res/monster1.png");
		monstersize = 105;
		monstertime = 320;
		collisionrange = 40;
		monsterHP = 1;
	}
}
// private float x, y;
// private Image noobmonster;
// private float noobmonstersize = 105;
// private float noobtime = 320;
// private float dX, dY;
// private Bullet bullet1 = new Bullet(MegaTankGame.GameWidth / 2,
// MegaTankGame.GameHeight / 2);
//
// public NoobMonster(float Mx, float My) throws SlickException {
// this.x = Mx;
// this.y = My;
// MegaTankGame.Randomrange();
// if (MegaTankGame.RAN > 500) {
// Randomone();
// } else {
// Randomtwo();
// }
//
// dX = MegaTankGame.GameWidth / 2 - noobmonstersize / 2 - x;
// dY = MegaTankGame.GameHeight / 2 - noobmonstersize / 2 - y;
//
// noobmonster = new Image("res/monster1.png");
//
// }
//
// void Randomtwo() {
// x = (float) (Math.random() * (MegaTankGame.GameWidth));
// y = (float) (Math.random()
// * (MegaTankGame.MAXY - MegaTankGame.MINY) + MegaTankGame.MINY);
// }
//
// private void Randomone() {
// x = (float) (Math.random()
// * (MegaTankGame.MAXX - MegaTankGame.MINX) + MegaTankGame.MINX);
// y = (float) (Math.random() * (MegaTankGame.GameHeight));
// }
//
// @Override
// public void render(Graphics g) {
// noobmonster.draw(x, y);
// }
//
// @Override
// public void update(int delta) {
// if (Math.abs((x + noobmonstersize / 2) - MegaTankGame.GameWidth / 2) > 15
// && Math.abs((y + noobmonstersize / 2) - MegaTankGame.GameHeight
// / 2) > 15) {
// x += dX / noobtime;
// y += dY / noobtime;
// }
// handleCollision();
// }
//
// public boolean collision(float bulletX, float bulletY) {
// if (Math.abs((x + noobmonstersize / 2) - bulletX) < 40
// && Math.abs((y + noobmonstersize / 2) - bulletY) < 40) {
// MegaTankGame.score += 1;
// return true;
// }
// return false;
//
// }
// private void handleCollision() {
// // if (fatMonster.collision(bullet.GetX(), bullet.GetY())) {
// // {System.out.println("COLLISION!!!!");
// // bullet.BulletReset();
// // };
// // }
// // if (bossMonster.collision(bullet.GetX(), bullet.GetY())) {
// // {System.out.println("COLLISION!!!!");
// // bullet.BulletReset();
// // };
// // }
// if (collision(bullet1.GetX(), bullet1.GetY())) {
// {
// System.out.println("COLLISION!!!!");
// bullet1.BulletReset();
//
// //noobMonster.remove();
// }
// ;
// }
// // if (heart.collision(bullet.GetX(), bullet.GetY())) {
// // System.out.println("COLLISION!!!!");
// // ;
// // }
//
// }
//
//
// public void remove() {
// MegaTankGame.Randomrange();
// if (MegaTankGame.RAN > 500) {
// Randomone();
// } else {
// Randomtwo();
// }
//
// }
//
// }
