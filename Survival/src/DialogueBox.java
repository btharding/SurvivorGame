import java.awt.Color;
import java.awt.Graphics;


public class DialogueBox {
	
	int x,y,width,height;
	public DialogueBox() {
		this.x = 0;
		this.y = Game.HEIGHT - 70;
		this.width = Game.WIDTH;
		this.height = 70;
	}
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.setColor(new Color(200,200,200));
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x+2, y+2, width-4, height-4);
		g.drawString("Health: " + (int)Player.health + "%", x+5, y+15);
		g.drawString("Food Level: "+ (int) Player.food + "%", x+5, y+30); 
		g.drawString("Water Level: "+ (int) Player.water + "%", x+5, y+45);
		if(Game.isNight) {
			g.drawString("Hours until day : " + Game.timer/1000, x+5, y+60);
		}else {
			g.drawString("Hours until night : " + Game.timer/1000, x+5, y+60);
		}
		g.setColor(Color.white);
		g.drawString("Day " + Game.day, 10, 15);
		g.drawString(Game.message, Game.player.getX()-20, Game.player.getY()-10);
	}

}
