import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Room {
	private boolean[] borders = {false, false, false, false};//l,r,u,d
	private ArrayList<GameObject> objectsInRoom = new ArrayList<>();
	public Room() {
		for(int i = 0; i < 5; i++) {
			int rand = Game.random.nextInt(150);
			if(rand <= 25) {
				objectsInRoom.add(new AppleTree(Game.random.nextInt(Game.WIDTH-64-64)+32, Game.random.nextInt(Game.HEIGHT-70-64-64)+32, this));
			}else if(rand <= 50) {
				objectsInRoom.add(new Tree(Game.random.nextInt(Game.WIDTH-64-64)+32, Game.random.nextInt(Game.HEIGHT-70-64-64)+32, this));
			}else if(rand <= 75) {
				objectsInRoom.add(new Bush(Game.random.nextInt(Game.WIDTH-64-64)+32, Game.random.nextInt(Game.HEIGHT-70-64-64)+32, this));
			}else if(rand <=100) {
				objectsInRoom.add(new Puddle(Game.random.nextInt(Game.WIDTH-64-64)+32, Game.random.nextInt(Game.HEIGHT-70-64-64)+32, this));
			}else if(rand <=110) {
				objectsInRoom.add(new Pond(Game.random.nextInt(Game.WIDTH-64-64)+32, Game.random.nextInt(Game.HEIGHT-70-64-64)+32, this));
			}
		}
		
	}
	public Room(GameObject object) {
		this.objectsInRoom.add(object);
	}
	
	public void setBorders(boolean[] borders) {
		this.borders = borders;
	}
	public boolean[] getBorders() {
		return borders;
	}
	
	public void tick() {
		for(int i = 0; i < this.objectsInRoom.size(); i++) {
			this.objectsInRoom.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT-70);
		
		g.setColor(new Color(64,64,64));
		if(this.borders[0]) {
			g.fillRect(0, 0, 32, Game.HEIGHT-70);
		}
		if(this.borders[1]) {
			g.fillRect(Game.WIDTH-32, 0, 32, Game.HEIGHT-70);
		}
		if(this.borders[2]) {
			g.fillRect(0, 0, Game.WIDTH, 32);
		}
		if(this.borders[3]) {
			g.fillRect(0, Game.HEIGHT-32-70, Game.WIDTH, 32);
		}
		
		for(int i = 0; i < this.objectsInRoom.size(); i++) {
			this.objectsInRoom.get(i).render(g);
		}
		//Border.render(g, this.borders);
		//draw background
		//draw borders
	}
	
	public void addObject(GameObject object) {
		this.objectsInRoom.add(object);
	}
	public void removeObject(GameObject object) {
		this.objectsInRoom.remove(object);
	}
	public ArrayList<GameObject> getObjects(){
		return this.objectsInRoom;
	}
}
