import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PauseMenu extends Menu{

	public PauseMenu() {
		super(GameStates.Pause);
		addButton(new Button(Game.WIDTH/2 - 100, 250, 200, 50, "RESUME", Game.WIDTH/2 - 65, 285, new Font("Arial", Font.BOLD, 30),this,GameStates.Playing, Color.black, Color.white));
		addButton(new Button(Game.WIDTH/2 - 100, 350, 200, 50, "EXIT", Game.WIDTH/2 - 35, 385, new Font("Arial", Font.BOLD, 30),this,GameStates.Exit, Color.black, Color.white));
	}
	
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("PAUSED", Game.WIDTH/2 - 60, 50);
		g.drawString("Day " + Game.day, Game.WIDTH/2 - 45, 100);
		if(Game.isNight) {
			g.drawString("Hours until day : " + Game.timer/1000, Game.WIDTH/2-130, 150);
		}else {
			g.drawString("Hours until night : " + Game.timer/1000, Game.WIDTH/2-140, 150);
		}
	}

}
