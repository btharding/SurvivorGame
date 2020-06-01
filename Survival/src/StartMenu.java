import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class StartMenu extends Menu{

	public StartMenu() {
		super(GameStates.Start);
		addButton(new Button(Game.WIDTH/2 - 100,200,200,50,"START", Game.WIDTH/2 - 50,235,new Font("Arial", Font.BOLD, 30),this,GameStates.Playing, Color.black, Color.white));
		addButton(new Button(Game.WIDTH/2 - 100,300,200,50,"INSTRUCTIONS", Game.WIDTH/2-94,335,new Font("Arial", Font.BOLD, 25),this,GameStates.Instructions, Color.black, Color.white));
		addButton(new Button(Game.WIDTH/2 - 100,400,200,50,"QUIT", Game.WIDTH/2 - 35,435,new Font("Arial", Font.BOLD, 30),this,GameStates.Exit, Color.black, Color.white));
	}
	
	public void render(Graphics g) {
		super.render(g);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("game", Game.WIDTH/2 - 35, 100);
	}
}
