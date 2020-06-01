import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Player extends GameObject{
	
	private static int currentSpriteNum = 0;
	private float rotation =0;
	private int roomX, roomY;
	private boolean[] borders;
	enum animStates {Up, Down, Left, Right, Idle};
	public String state = "Idle";
	private HashMap<String, ArrayList<BufferedImage>> sprites = new HashMap<>();
	public static float health, food, water;
	public static float rateOfDamage = 0;
	
	public Player(int x, int y){
		super(x, y, 32, 32, ID.Player);
			ArrayList<BufferedImage> temp = new ArrayList<>();
			try {
				temp.add(ImageIO.read(new File("./img/Player/Up/1.png")));
				temp.add(ImageIO.read(new File("./img/Player/Up/2.png")));
			}catch(Exception e) {
				e.printStackTrace();
			}
			sprites.put("Up", temp);
			ArrayList<BufferedImage> temp2 = new ArrayList<>();
			try {
				temp2.add(ImageIO.read(new File("./img/Player/Down/1.png")));
				temp2.add(ImageIO.read(new File("./img/Player/Down/2.png")));
			}catch(Exception e) {
				e.printStackTrace();
			}
			sprites.put("Down", temp2);
			ArrayList<BufferedImage> temp3 = new ArrayList<>();
			try {
				temp3.add(ImageIO.read(new File("./img/Player/Left/1.png")));
				temp3.add(ImageIO.read(new File("./img/Player/Left/2.png")));
			}catch(Exception e) {
				e.printStackTrace();
			}
			sprites.put("Left", temp3);
			ArrayList<BufferedImage> temp4 = new ArrayList<>();
			try {
				temp4.add(ImageIO.read(new File("./img/Player/Right/1.png")));
				temp4.add(ImageIO.read(new File("./img/Player/Right/2.png")));
			}catch(Exception e) {
				e.printStackTrace();
			}
			sprites.put("Right", temp4);
			ArrayList<BufferedImage> temp5 = new ArrayList<>();
			try {
				temp5.add(ImageIO.read(new File("./img/Player/Idle/1.png")));
				temp5.add(ImageIO.read(new File("./img/Player/Idle/2.png")));
			}catch(Exception e) {
				e.printStackTrace();
			}
			sprites.put("Idle", temp5);
			
		ArrayList<Integer> temp6 = Map.occupiedRooms.get(0);
		this.roomX = temp6.get(0);
		this.roomY = temp6.get(1);
		Game.handler.addObject(this);
		Player.health = 100f;
		Player.food = 100f;
		Player.water = 100f;
	}

	public void tick(){
		Player.food -= 0.02f;
		Player.water -= 0.02f;
		
		if(Player.food <= 0) {
			Player.food = 0;
			Player.rateOfDamage = 0.05f;
			if(Player.water <= 0) {
				Player.water = 0;
				Player.rateOfDamage =0.1f;
				if(Game.isNight) {
					Player.rateOfDamage = 0.2f;
				}
			}else {
				if(Game.isNight) {
					Player.rateOfDamage = 0.15f;
				}
			}
		}else {
			if(Player.water <= 0) {
				Player.water = 0;
				Player.rateOfDamage = 0.05f;
				if(Game.isNight) {
					Player.rateOfDamage = 0.15f; 
				}
			}else {
				if(Game.isNight) {
					Player.rateOfDamage = 0.1f;
				}
			}
		}

	
		Player.health -= Player.rateOfDamage;
		Room currentRoom = Map.map[this.roomY][this.roomX];	
		Game.message = "";
		for(int i = 0; i<currentRoom.getObjects().size(); i++) {
			GameObject temp = currentRoom.getObjects().get(i);
			if(this.getBounds().intersects(temp.getBounds())) {
				if(temp.getId() == ID.Apple ||temp.getId() ==  ID.Berry) {
					Game.message = "Press Z to eat";
				}else if(temp.getId() == ID.Puddle || temp.getId() == ID.Pond) {
					Game.message = "Press Z to drink";
				}else if(temp.getId() == ID.Tent && Game.isNight) {
					Game.message = "Press X to sleep";
				}
			}
		}
		
		borders = currentRoom.getBorders();
		this.state = "Idle";
		if(KeyInput.arrowKeysDown[0]) {
			velX = -3;
			this.state = "Left";
		}else if(KeyInput.arrowKeysDown[3]) {
			velX = 3;
			this.state = "Right";
		}else {
			velX = 0;
		}
		
		if(KeyInput.arrowKeysDown[1]) {
			velY = -3;
			this.state = "Up";
		}else if(KeyInput.arrowKeysDown[2]) {
			velY = 3;
			this.state = "Down";
		}else {
			velY = 0;
		}
	
		if(borders[0] && this.velX < 0) {
			if(this.x + velX < 32) {
				this.x = 32;
				this.velX = 0;
			}
		}else if(borders[1] && this.velX > 0) {
			if(this.x + this.width + 32 + this.velX> Game.WIDTH) {
				this.x = Game.WIDTH - 32 - this.width;
				this.velX = 0;
			}
		}
		
		if(borders[2] && this.velY < 0) {
			if(this.y + velX < 32) {
				this.y = 32;
				this.velY = 0;
			}
		}else if(borders[3] && this.velY > 0) {
			if(this.y + this.height + 32 +70 + this.velX> Game.HEIGHT) {
				this.y = Game.HEIGHT - 32 - this.height - 70;
				this.velX = 0;
			}
		}
		

		this.y += this.velY;
		this.x += this.velX;
		
		if(this.x < 0) {
			this.x = Game.WIDTH - this.width;
			this.roomX --;
		}
		if(this.x + this.width > Game.WIDTH ) {
			this.x = 0;
			this.roomX ++;
		}
		if(this.y < 0) {
			this.y = Game.HEIGHT - this.height - 70;
			this.roomY --;
		}
		if(this.y > Game.HEIGHT - this.height - 70) {
			this.y = 0;
			this.roomY ++;
		}
		
		if(Game.animTimer < 5) {
			Player.currentSpriteNum = 0;
		}else {
			Player.currentSpriteNum = 1;
		}
		
		
	}

	public void render(Graphics g){
		g.setColor(Color.GRAY);
		//Graphics2D g2d = (Graphics2D) g;
		//g2d.rotate(this.rotation, this.x+(0.5*this.width), this.y+(0.5*this.height));
		BufferedImage sprite = this.sprites.get(this.state).get(Player.currentSpriteNum);
		g.drawImage(sprite,this.x, this.y, this.width, this.height, null);
		//g2d.rotate(-this.rotation, this.x+(0.5*this.width), this.y+(0.5*this.height));

	}
	
	public void eatDrink() {
		Room currentRoom = Map.map[this.roomY][this.roomX];	
		for(int i = 0; i<currentRoom.getObjects().size(); i++) {
			GameObject temp = currentRoom.getObjects().get(i);
			if(this.getBounds().intersects(temp.getBounds())) {
				if(temp.getId() == ID.Apple ||temp.getId() ==  ID.Berry) {
					currentRoom.removeObject(temp);
					Food food = (Food) temp;
					food.getParent().setCurrentFruit(0);
					food.getParent().getRoom().removeObject(temp);
					if(Player.food + 10 >100) {
						Player.food = 100;
					}else {
						Player.food += 10;
					}
				}else if(temp.getId() == ID.Puddle || temp.getId() == ID.Pond) {
					WaterSource waterSource = (WaterSource) temp;
					waterSource.drink();
					if(Player.water + 10>100) {
						Player.water = 100;
					}else {
						Player.water += 10;
					}
				}
			}
		}
	}
	
	public void sleep() {
		Room currentRoom = Map.map[this.roomY][this.roomX];	
		for(int i = 0; i<currentRoom.getObjects().size(); i++) {
			GameObject temp = currentRoom.getObjects().get(i);
			if(this.getBounds().intersects(temp.getBounds())) {
				if(temp.getId() == ID.Tent && Game.isNight) {
					Game.isNight = false;
					Game.timer = 12000;
					Player.health = 100;
					Game.day ++;
				}
			}
		}
	}
	
	public float getRotation() {
		return rotation;
	}
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	public int getRoomX() {
		return roomX;
	}
	public void setRoomX(int roomX) {
		this.roomX = roomX;
	}
	public int getRoomY() {
		return roomY;
	}
	public void setRoomY(int roomY) {
		this.roomY = roomY;
	}

}
