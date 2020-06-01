import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Bush extends FoodSource{		
		
		private static BufferedImage sprite = null;
		
		public Bush(int x, int y, Room room) {
			super(x, y, 64, 64, ID.Bush, 5, Bush.sprite, room);
		}
		
		public static  void load() {
			if(Bush.sprite == null) {
				try {
					Bush.sprite = ImageIO.read(new File("./img/Bush.png"));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
