import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Food extends GameObject{
	
	private int life;
	private Room room;
	private BufferedImage sprite;
	private FoodSource parent;
	
	public Food(int x, int y, int width, int height, ID id, Room room, int life, FoodSource parent, BufferedImage sprite) {
		super(x, y, width, height, id);
		this.life = life;
		this.room = room;
		this.room.addObject(this);
		this.sprite = sprite;
		this.parent = parent;
	}

	@Override
	public void tick() {	
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(this.sprite, this.x, this.y, this.width,this.height,null);		
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	public int getLife() {
		return this.life;
	}
	public void setParent(FoodSource parent) {
		this.parent = parent;
	}
	public FoodSource getParent() {
		return this.parent;
	}

}
