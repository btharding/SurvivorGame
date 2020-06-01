import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class WaterSource extends GameObject{
	
	private int drinks;
	private BufferedImage sprite;
	private Room room;
	
	public WaterSource(int x, int y, int width, int height, ID id, int water, BufferedImage sprite, Room room) {
		super(x, y, width, height, id);
		this.drinks = water;
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
		if(drinks ==0) {
			this.room.removeObject(this);
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
	
	public void drink() {
		this.drinks -- ;
	}
	public Room getRoom() {
		return room;
	}

}
