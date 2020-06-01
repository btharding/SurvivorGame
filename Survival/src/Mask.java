import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Mask {
	private static BufferedImage sprite = null;
	private static int x, y;
	
	public Mask() {
		if(sprite == null) {
			try {
				Mask.sprite = ImageIO.read(new File("./img/Mask.png"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static void tick() {
		Mask.x = Game.player.getX() - 600;
		Mask.y = Game.player.getY() - 450;
	}
	
	public static void render(Graphics g) {
		g.drawImage(sprite, x, y, null);
	}

}
