import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Berry extends Food{
	private static BufferedImage sprite = null;
	
	public Berry(int x, int y, Room room, FoodSource parent ) {
		super(x, y, 8, 8, ID.Berry, room, 1000, parent, sprite);
	}
	
	public static void load() {
		if(Berry.sprite == null) {
			try {
				sprite = ImageIO.read(new File("./img/Berry.png"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}




