import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Puddle extends WaterSource{
	
	private static BufferedImage sprite = null;

	public Puddle(int x, int y, Room room) {
		super(x, y, 32, 32, ID.Puddle, 4, sprite, room);
	}
	
	public static void load() {
		if(Puddle.sprite == null) {
			try {
				sprite = ImageIO.read(new File("./img/Puddle.png"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
