import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Pond extends WaterSource{
	
	private static BufferedImage sprite = null;

	public Pond(int x, int y, Room room) {
		super(x, y, 64, 64, ID.Pond, 10, sprite, room);
	}
	
	public static void load() {
		if(Pond.sprite == null) {
			try {
				sprite = ImageIO.read(new File("./img/Pond.png"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
