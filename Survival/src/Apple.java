import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Apple extends Food{
	private static BufferedImage sprite = null;
	
	public Apple(int x, int y, Room room, FoodSource parent ) {
		super(x, y, 8, 8, ID.Apple, room, 1000, parent, sprite);
	}
	
	public static void load() {
		if(Apple.sprite == null) {
			try {
				sprite = ImageIO.read(new File("./img/Apple.png"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
