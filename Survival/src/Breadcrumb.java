import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Breadcrumb extends GameObject{
	
	private int life = 1000;
	private int roomX, roomY;
	private static BufferedImage sprite = null;
	
	public Breadcrumb(int x, int y) {
		super(x, y, 4, 4, ID.Breadcrumb);
		if(Breadcrumb.sprite == null) {
			try {
				Breadcrumb.sprite = ImageIO.read(new File("./img/Crumb.png"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		this.roomX = Game.player.getRoomX();
		this.roomY = Game.player.getRoomY();
		Map.map[this.roomY][this.roomX].addObject(this);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		life--;
		if(life < 0) {
			Map.map[this.roomY][this.roomX].removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(sprite, this.x, this.y, this.width, this.height, null);
	}

}
