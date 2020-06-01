import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Tent extends GameObject {
	
	private static BufferedImage sprite = null;

	public Tent(int x, int y) {
		super(x, y, 58, 70, ID.Tent);
		if(sprite == null) {
			try {
				sprite = ImageIO.read(new File("./img/Tent.png"));
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error reading tent.png");
			}
		}
	}

	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, this.x, this.y, this.width, this.height, null);		
	}

}
