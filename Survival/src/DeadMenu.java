import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DeadMenu extends Menu{

	public DeadMenu() {
		super(GameStates.Dead);
		addButton(new Button(Game.WIDTH/2 - 100, 250, 200, 50, "RESTART", Game.WIDTH/2 - 70, 285, new Font("Arial", Font.BOLD, 30),this,GameStates.Reset, Color.black, Color.white));
		addButton(new Button(Game.WIDTH/2 - 100, 350, 200, 50, "EXIT", Game.WIDTH/2 - 35, 385, new Font("Arial", Font.BOLD, 30),this,GameStates.Exit, Color.black, Color.white));
	}
	
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("YOU DIED ON DAY " + Game.day, Game.WIDTH/2 - 135, 150);
	}

}
