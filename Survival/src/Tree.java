import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Tree extends GameObject{		
		
		private static BufferedImage sprite = null;
		private Room room;
		
		public Tree(int x, int y, Room room) {
			super(x, y, 48, 72, ID.Tree);
			if(Tree.sprite == null) {
				try {
					Tree.sprite = ImageIO.read(new File("./img/Tree1.png"));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			this.room = room;
			while(checkIntersects()) {
				this.x = Game.random.nextInt(Game.WIDTH-64-64)+32;
				this.y = Game.random.nextInt(Game.HEIGHT-70-64-64)+32;
			}
			this.room.addObject(this);
		}
		
		private boolean checkIntersects() {
			for(int i =0; i<this.room.getObjects().size(); i++) {
				if(this.getBounds().intersects(this.room.getObjects().get(i).getBounds())) {
					return true;
				}
			}
			return false;
		}

		@Override
		public void tick() {
		}

		@Override
		public void render(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(sprite, this.x, this.y, this.width, this.height, null);
		}

	}
