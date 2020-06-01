import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FoodSource extends GameObject{
	
	private int maxFruit;
	private BufferedImage sprite;
	private Room room;
	private int currentFruit = 0;
	
	public FoodSource(int x, int y, int width, int height, ID id, int fruit, BufferedImage sprite, Room room) {
		super(x, y, width, height, id);
		this.maxFruit = fruit;
		this.sprite = sprite;
		this.room = room;
		while(checkIntersects()) {
			this.x = Game.random.nextInt(Game.WIDTH-64-64)+32;
			this.y = Game.random.nextInt(Game.HEIGHT-70-64-64)+32;
		}
		this.room.addObject(this);
	}

	@Override
	public void tick() {
		if(this.maxFruit > 0 && this.currentFruit == 0) {
			if(Game.random.nextInt(1000)<=1) {
				if(this.id == ID.AppleTree) {
					new Apple((int)(this.x + (0.5*this.width) + Game.random.nextInt(65) -32), (int)(this.y + (0.5*this.height) + Game.random.nextInt(65)-32), this.room, this);
					this.currentFruit++;
					this.maxFruit --;
				}else {
					new Berry((int)(this.x + (0.5*this.width) + Game.random.nextInt(65) -32), (int)(this.y + (0.5*this.height) + Game.random.nextInt(65)-32), this.room, this);
					this.currentFruit++;
					this.maxFruit--;
				}
			}
		}		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(this.sprite, this.x, this.y, this.width, this.height, null);
		
	}
	
	private boolean checkIntersects() {
		for(int i =0; i<this.room.getObjects().size(); i++) {
			if(this.getBounds().intersects(this.room.getObjects().get(i).getBounds())) {
				return true;
			}
		}
		return false;
	}
	
	public void setCurrentFruit(int fruit) {
		this.currentFruit = fruit;
	}
	public Room getRoom() {
		return room;
	}

}
