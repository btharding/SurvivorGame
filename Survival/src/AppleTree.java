import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class AppleTree extends FoodSource{		
		
		private static BufferedImage sprite = null;
		
		public AppleTree(int x, int y, Room room) {
			super(x, y, 64, 64, ID.AppleTree, 5, AppleTree.sprite, room);
		}
		
		public static void load() {
			if(AppleTree.sprite == null) {
				try {
					AppleTree.sprite = ImageIO.read(new File("./img/Tree2.png"));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}


	}
